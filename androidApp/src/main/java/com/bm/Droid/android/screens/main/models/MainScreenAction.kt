package com.bm.Droid.android.screens.main.models

sealed class MainScreenAction {
    object OpenGameScreen : MainScreenAction()
    object OpenRecordsScreen : MainScreenAction()
    object OpenInfoScreen : MainScreenAction()
    object OpenOtherGamesScreen : MainScreenAction()
    data class ShowAlert(val message: String) : MainScreenAction()
    data class ShowToast(val message: String) : MainScreenAction()
}