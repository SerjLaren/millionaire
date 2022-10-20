package com.bm.about

import android.os.Looper
import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.NewsPublisher
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import com.badoo.mvicore.feature.FeatureScheduler
import io.reactivex.Observable
import io.reactivex.Observable.just
import io.reactivex.android.schedulers.AndroidSchedulers

class AboutFeature :
    ActorReducerFeature<AboutFeature.Wish, AboutFeature.Effect, AboutFeature.State, AboutFeature.News>(
        initialState = State(),
        actor = ActorImpl(),
        reducer = ReducerImpl(),
        newsPublisher = NewsPublisherImpl(),
        featureScheduler = AndroidMainThreadFeatureScheduler(),
    ) {

    class State

    sealed class Wish {
        object ShowAboutMe : Wish()
        object ShowSourceCode : Wish()
        object ShowAppInfo : Wish()
        object ShowFeedback : Wish()
    }

    sealed class Effect {
        data class AboutMeScreenRequested(val url: String) : Effect()
        data class SourceCodeScreenRequested(val url: String) : Effect()
        data class FeedbackScreenRequested(val toMail: String) : Effect()
        object AppInfoScreenRequested : Effect()
    }

    sealed class News {
        data class ShowAboutMeScreen(val url: String) : News()
        data class ShowSourceCodeScreen(val url: String) : News()
        data class ShowFeedbackScreen(val toMail: String) : News()
        object ShowAppInfoScreen : News()
    }

    class ActorImpl : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<out Effect> = when (wish) {
            Wish.ShowAboutMe -> just(Effect.AboutMeScreenRequested(aboutMeUrl))
            Wish.ShowAppInfo -> just(Effect.AppInfoScreenRequested)
            Wish.ShowFeedback -> just(Effect.FeedbackScreenRequested(feedbackMail))
            Wish.ShowSourceCode -> just(Effect.SourceCodeScreenRequested(sourceCodeUrl))
        }
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(action: Wish, effect: Effect, state: State): News = when (effect) {
            is Effect.AboutMeScreenRequested -> News.ShowAboutMeScreen(effect.url)
            Effect.AppInfoScreenRequested -> News.ShowAppInfoScreen
            is Effect.FeedbackScreenRequested -> News.ShowFeedbackScreen(effect.toMail)
            is Effect.SourceCodeScreenRequested -> News.ShowSourceCodeScreen(effect.url)
        }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State {
            return state
        }
    }

    class AndroidMainThreadFeatureScheduler: FeatureScheduler {
        override val isOnFeatureThread = Looper.myLooper() == Looper.getMainLooper()
        override val scheduler = AndroidSchedulers.mainThread()!!
    }

    companion object {
        const val aboutMeUrl = "https://about.me"
        const val sourceCodeUrl = "https://github.com"
        const val feedbackMail = "support@gmail.com"
    }
}