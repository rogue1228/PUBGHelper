package com.mc_jh.pubghelper;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.mc_jh.pubghelper.data.database.PUBGDatabase;
import com.mc_jh.pubghelper.data.database.dao.PlayerDAO;
import com.mc_jh.pubghelper.data.repository.PlayersRepository;
import com.mc_jh.pubghelper.model.PlayerModel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import de.kevcodez.pubg.client.ApiClient;
import de.kevcodez.pubg.model.Region;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class PlayerRepositoryTest {
    final Logger logger = LoggerFactory.getLogger(PlayerRepositoryTest.class);
    private PlayerDAO mPlayerDAO;
    private PUBGDatabase mDb;
    private ApiClient apiClient;
    private PlayersRepository playersRepository;

    @Before
    public void setup() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor)
                .build();
        apiClient = new ApiClient(BuildConfig.API_KEY, httpClient);

        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, PUBGDatabase.class).allowMainThreadQueries().build();
        mPlayerDAO = mDb.playerDAO();

        playersRepository = new PlayersRepository(apiClient, mDb);
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void searchPlayer() throws Exception {
        String playerName = "Sleeptime_GRT";
        PlayerModel playerModel = playersRepository.searchPlayer(Region.PC_KOREA_JAPAN, playerName).blockingGet();
        assertEquals(playerModel.getAttribute().getName(), playerName);
    }

    @Test
    public void savePlayer() throws Exception {
        String playerName = "Sleeptime_GRT";
        PlayerModel playerModel = playersRepository.searchPlayer(Region.PC_KOREA_JAPAN, playerName).blockingGet();
        PlayerModel playerModel2 = playersRepository.savePlayer(playerModel).blockingGet();
        assertEquals(playerModel, playerModel2);
    }
}
