package com.example.white.data

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import com.example.white.data.entities.MyCharacter
import com.example.white.network.ServerAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class Repository(private val database: AppDatabase, private val serverAPI: ServerAPI) {
    @SuppressLint("CheckResult")
    fun getRemote() {
        serverAPI.readCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe { result ->
                database.getCharacterDao().storeList(result)
            }
    }

    fun getLocalLive(): LiveData<List<MyCharacter>> {
        return database.getCharacterDao().getAllLive()
    }
}

