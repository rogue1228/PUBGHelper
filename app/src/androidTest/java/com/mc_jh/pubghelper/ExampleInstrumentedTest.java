package com.mc_jh.pubghelper;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.internal.deps.guava.collect.Lists;
import android.support.test.runner.AndroidJUnit4;

import com.mc_jh.pubghelper.data.database.PUBGDatabase;
import com.mc_jh.pubghelper.data.database.dao.PlayerDAO;
import com.mc_jh.pubghelper.data.database.entity.PlayerEntity;
import com.mc_jh.pubghelper.data.mapper.PlayerMapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

import de.kevcodez.pubg.client.ApiClient;
import de.kevcodez.pubg.client.PlayerFilter;
import de.kevcodez.pubg.model.Region;
import de.kevcodez.pubg.model.player.PlayerResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    final Logger logger = LoggerFactory.getLogger(ExampleInstrumentedTest.class);
    private PlayerDAO mPlayerDAO;
    private PUBGDatabase mDb;
    private ApiClient apiClient;

    @Before
    public void setupApiManager() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();
        apiClient = new ApiClient(BuildConfig.API_KEY, httpClient);
    }

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, PUBGDatabase.class).allowMainThreadQueries().build();
        mPlayerDAO = mDb.playerDAO();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.mc_jh.pubghelper", appContext.getPackageName());
    }

    @Test
    public void loadAndSavePlayer() throws Exception {
        String playerName = "Sleeptime_GRT";
        PlayerFilter playerFilter = new PlayerFilter(Lists.newArrayList(), Lists.newArrayList(playerName));
        PlayerResponse playerResponse = apiClient.getPlayers(Region.PC_KOREA_JAPAN, playerFilter);
        List<PlayerEntity> playerEntityList = PlayerMapper.INSTANCE.apiToDBEntity(playerResponse.getPlayers());
        mPlayerDAO.insertPlayers(playerEntityList.toArray(new PlayerEntity[playerEntityList.size()]));
        PlayerEntity playerEntity = mPlayerDAO.loadAllPlayers().get(0);
        assertEquals(playerEntity.getId(), playerEntityList.get(0).getId());
        assertEquals(playerEntity.getAttributeEntity().getName(), playerName);
    }

}
