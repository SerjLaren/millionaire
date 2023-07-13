package com.bm.Droid.android.screens.main.models

sealed class MainScreenAction {
    data class ShowAlert(val message: String)
    data class ShowToast(val message: String)
}