package com.bm.Droid.android.screens.main

import com.bm.Droid.managers.SettingsManager
import com.bm.Droid.android.screens.base.BaseViewModel
import com.bm.Droid.android.screens.main.models.MainScreenAction
import com.bm.Droid.android.screens.main.models.MainScreenButton
import com.bm.Droid.android.screens.main.models.MainScreenButtonType
import com.bm.Droid.android.screens.main.models.MainScreenEvent
import com.bm.Droid.android.screens.main.models.MainScreenViewState
import com.bm.Droid.repositories.QuestionsRepository
import org.koin.core.component.inject

class MainViewModel : BaseViewModel<MainScreenViewState, MainScreenAction, MainScreenEvent>(
    initialState = MainScreenViewState.Initial
) {

    private val settingsManager: SettingsManager by inject()
    private val questionsRepository: QuestionsRepository by inject()

    override fun obtainEvent(viewEvent: MainScreenEvent) {
        when (viewEvent) {
            MainScreenEvent.InitScreen -> {
                viewState = MainScreenViewState.Content(
                    buttons = listOf(
                        MainScreenButton(type = MainScreenButtonType.StartGame),
                        MainScreenButton(type = MainScreenButtonType.Records),
                        MainScreenButton(type = MainScreenButtonType.About),
                        MainScreenButton(type = MainScreenButtonType.OtherGames),
                    ),
                    isSoundMuted = settingsManager.isSoundEnabled
                )
            }
            is MainScreenEvent.OnMainScreenButtonClicked -> {
                when (viewEvent.buttonType) {
                    MainScreenButtonType.StartGame -> {
                        viewAction = MainScreenAction.OpenGameScreen
                    }
                    MainScreenButtonType.Records -> TODO()
                    MainScreenButtonType.About -> TODO()
                    MainScreenButtonType.OtherGames -> TODO()
                }
            }
            MainScreenEvent.OnMuteSoundButtonClicked -> {
                settingsManager.isSoundEnabled = !settingsManager.isSoundEnabled
                viewState = (viewState as MainScreenViewState.Content).copy(isSoundMuted = settingsManager.isSoundEnabled)
            }
            MainScreenEvent.Close -> {
                viewAction = null
            }
        }
    }
}