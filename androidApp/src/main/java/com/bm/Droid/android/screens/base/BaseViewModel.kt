package com.bm.Droid.android.screens.base

import com.adeo.kviewmodel.BaseSharedViewModel
import com.bm.Droid.MultipleClicksCutter
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<State : Any, Action, Event>(initialState: State) :
    BaseSharedViewModel<State, Action, Event>(initialState), KoinComponent {

    private val multipleClicksCutter: MultipleClicksCutter by inject()

    fun obtainSingleEvent(viewEvent: Event) {
        multipleClicksCutter.processClick {
            obtainEvent(viewEvent)
        }
    }
}