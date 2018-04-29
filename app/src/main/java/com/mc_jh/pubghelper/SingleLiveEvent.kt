package com.mc_jh.pubghelper


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.MainThread
import org.slf4j.LoggerFactory
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Created by minchul on 2018-01-04.
 */

class SingleLiveEvent<T> : MutableLiveData<T>() {
    companion object {
        private const val TAG = "SingleLiveEvent"

    }

    private val logger = LoggerFactory.getLogger(SingleLiveEvent::class.java)

    private val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<T>) {
        if (hasActiveObservers()) {
            logger.warn(TAG, "마지막 옵저버에만 이벤트가 전달됩니다.")
        }
        super.observe(owner, Observer<T> {
            if (mPending.compareAndSet(true, false)) {
                observer.onChanged(it)
            }
        })
    }

    @MainThread
    override fun setValue(value: T?) {
        mPending.set(true)
        super.setValue(value)
    }

    @MainThread
    fun call() {
        setValue(null)
    }
}
