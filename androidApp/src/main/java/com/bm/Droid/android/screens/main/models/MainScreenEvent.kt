package com.bm.Droid.android.screens.main.models

sealed class MainScreenEvent {
    object InitScreen : MainScreenEvent()
    data class OnMainScreenButtonClicked(val buttonType: MainScreenButtonType) : MainScreenEvent()
    object OnMuteSoundButtonClicked : MainScreenEvent()
}