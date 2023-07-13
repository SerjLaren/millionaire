package com.bm.Droid.android.screens.game.models

enum class HintType {
    FiftyFifty,
    ByPeople,
    CallToFriend,
}

class HintButton(
    val type: HintType,
    val enabled: Boolean,
)

class VariantButton(
    val text: String
)

sealed class GameScreenViewState {
    object Loading : GameScreenViewState()
    data class Content(
        val question: String,
        val variants: List<VariantButton>,
        val hints: List<HintButton>,
        val currentLevel: String,
    ) : GameScreenViewState()
}