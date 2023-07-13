package com.bm.Droid.android.screens.game

import com.bm.Droid.android.screens.base.BaseViewModel
import com.bm.Droid.android.screens.game.models.GameScreenAction
import com.bm.Droid.android.screens.game.models.GameScreenEvent
import com.bm.Droid.android.screens.game.models.GameScreenViewState
import com.bm.Droid.android.screens.game.models.HintButton
import com.bm.Droid.android.screens.game.models.HintType
import com.bm.Droid.android.screens.game.models.VariantButton

class GameViewModel : BaseViewModel<GameScreenViewState, GameScreenAction, GameScreenEvent>(
    initialState = GameScreenViewState.Loading
) {
    override fun obtainEvent(viewEvent: GameScreenEvent) {
        when (viewEvent) {
            GameScreenEvent.InitScreen -> {
                viewState = GameScreenViewState.Content(
                    question = "rhfdh gregjrej gejro gjreio jgoierjgo jerg joriejiog ejri jgluh uhg iuerhguier hlui ghilrghierhg iewrh gierhi guerhi guwerhui ghewril gerhu gh 111",
                    variants = listOf(
                        VariantButton(text = "gfewgweg"),
                        VariantButton(text = "gfewgweg"),
                        VariantButton(text = "gfewgweg"),
                        VariantButton(text = "gfewgweg"),
                    ),
                    hints = listOf(
                        HintButton(type = HintType.CallToFriend, enabled = true),
                        HintButton(type = HintType.ByPeople, enabled = true),
                        HintButton(type = HintType.FiftyFifty, enabled = true),
                    ),
                    currentLevel = "200",
                )
            }
            is GameScreenEvent.OnHintButtonClicked -> {

            }
            is GameScreenEvent.OnVariantButtonClicked -> {

            }
            GameScreenEvent.Close -> {
                viewAction = null
            }
        }
    }
}