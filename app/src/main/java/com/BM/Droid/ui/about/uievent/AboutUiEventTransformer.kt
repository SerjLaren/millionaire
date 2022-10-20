package com.BM.Droid.ui.about.uievent

import com.bm.about.AboutFeature

class AboutUiEventTransformer : (AboutUiEvent) -> AboutFeature.Wish {
    override fun invoke(uiEvent: AboutUiEvent): AboutFeature.Wish = when (uiEvent) {
        AboutUiEvent.AboutMeButtonClicked -> AboutFeature.Wish.ShowAboutMe
        AboutUiEvent.AppInfoButtonClicked -> AboutFeature.Wish.ShowAppInfo
        AboutUiEvent.FeedbackButtonClicked -> AboutFeature.Wish.ShowFeedback
        AboutUiEvent.SourceCodeButtonClicked -> AboutFeature.Wish.ShowSourceCode
    }
}