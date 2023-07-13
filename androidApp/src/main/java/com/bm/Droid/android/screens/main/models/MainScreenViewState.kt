package com.bm.Droid.android.screens.main.models

enum class MainScreenButtonType {
    StartGame,
    Records,
    About,
    OtherGames,
}

data class MainScreenButton(
    val type: MainScreenButtonType,
)

sealed class MainScreenViewState {
    object Initial: MainScreenViewState()
    data class Content(
        val buttons: List<MainScreenButton>,
        val isSoundMuted: Boolean,
    ) : MainScreenViewState()
}