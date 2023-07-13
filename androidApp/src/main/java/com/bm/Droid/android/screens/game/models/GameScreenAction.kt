package com.bm.Droid.android.screens.game.models

sealed class GameScreenAction {
    data class ShowAlert(val message: String) : GameScreenAction()
}