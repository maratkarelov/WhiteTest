package com.example.white.core


sealed class Failure {
    class NetworkConnection() : Failure()
    class UnknownError(val message: String?) : Failure()
}