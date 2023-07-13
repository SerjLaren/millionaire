package com.bm.Droid.android.screens.game.models

sealed class GameScreenEvent {
    object InitScreen : GameScreenEvent()
    object Close : GameScreenEvent()
    data class OnVariantButtonClicked(val variant: Int) : GameScreenEvent()
    data class OnHintButtonClicked(val hintType: HintType) : GameScreenEvent()
}