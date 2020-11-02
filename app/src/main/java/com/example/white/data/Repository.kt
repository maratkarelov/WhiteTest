package com.example.white.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.example.white.core.Failure
import com.example.white.data.entities.MyCharacter
import com.example.white.network.ServerAPI
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.ConnectException
import java.net.UnknownHostException

class Repository(private val database: AppDatabase, private val serverAPI: ServerAPI) {
    @SuppressLint("CheckResult")

    fun getRemote(): Single<List<MyCharacter>> {
        return serverAPI.readCharacters()
            .doAfterSuccess {
                database.getCharacterDao().storeList(it)
            }
    }

    fun getLocalLive(): LiveData<List<MyCharacter>> {
        return database.getCharacterDao().getAllLive()
    }
}

