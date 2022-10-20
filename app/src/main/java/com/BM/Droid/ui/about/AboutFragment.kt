package com.BM.Droid.ui.about

import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.BM.Droid.R
import com.BM.Droid.common.BaseFragment
import com.BM.Droid.databinding.FragmentAboutBinding
import com.BM.Droid.ui.about.uievent.AboutUiEvent
import com.bm.about.AboutFeature
import io.reactivex.functions.Consumer

class AboutFragment : BaseFragment<AboutUiEvent>(R.layout.fragment_about), Consumer<AboutFeature.News> {

    private val viewBinding: FragmentAboutBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(viewBinding) {
            aboutMeButton.setOnClickListener { onUiEvent(AboutUiEvent.AboutMeButtonClicked) }
            sourceCodeButton.setOnClickListener { onUiEvent(AboutUiEvent.SourceCodeButtonClicked) }
            aboutAppButton.setOnClickListener { onUiEvent(AboutUiEvent.AppInfoButtonClicked) }
            feedbackButton.setOnClickListener { onUiEvent(AboutUiEvent.FeedbackButtonClicked) }
        }
    }

    override fun accept(news: AboutFeature.News?) {
        when (news) {
            is AboutFeature.News.ShowAboutMeScreen -> {}
            AboutFeature.News.ShowAppInfoScreen -> {}
            is AboutFeature.News.ShowFeedbackScreen -> {}
            is AboutFeature.News.ShowSourceCodeScreen -> {}
            else -> {}
        }
    }
}