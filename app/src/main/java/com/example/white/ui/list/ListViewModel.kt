package com.example.white.ui.list

import com.example.white.core.BaseViewModel
import com.example.white.core.Failure
import com.example.white.data.Repository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.net.ConnectException
import java.net.UnknownHostException

class ListViewModel(private val repository: Repository) : BaseViewModel(

) {
    val liveData = repository.getLocalLive()
    private val disposable = CompositeDisposable()

    init {
        refreshFromRemote()
    }

    fun refreshFromRemote() {
        disposable.add(
            repository.getRemote()
                .subscribeOn(Schedulers.io())
                .doOnError { error ->
                    if (error is UnknownHostException || error is ConnectException) {
                        handleFailure(Failure.NetworkConnection())
                    } else {
                        handleFailure(Failure.UnknownError(error.localizedMessage))
                    }
                }
                .subscribe())
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}