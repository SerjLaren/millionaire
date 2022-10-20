package com.BM.Droid.ui.about.uievent

sealed class AboutUiEvent {
    object AboutMeButtonClicked : AboutUiEvent()
    object SourceCodeButtonClicked : AboutUiEvent()
    object AppInfoButtonClicked : AboutUiEvent()
    object FeedbackButtonClicked : AboutUiEvent()
}