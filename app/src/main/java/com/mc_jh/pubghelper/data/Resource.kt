package com.mc_jh.pubghelper.data


/**
 * Created by minchul on 2018-02-28.
 */

class Resource<T> private constructor(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS, ERROR, LOADING;

        val isSuccess: Boolean
            get() = this == SUCCESS
        val isError: Boolean
            get() = this == ERROR
        val isLoading: Boolean
            get() = this == LOADING
    }

    companion object {

        fun <T> success(data: T): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}
