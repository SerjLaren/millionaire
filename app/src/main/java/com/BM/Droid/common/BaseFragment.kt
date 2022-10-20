package com.BM.Droid.common

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.ObservableSource
import io.reactivex.Observer


abstract class BaseFragment<T>(@LayoutRes layoutResId: Int) : Fragment(layoutResId), ObservableSource<T> {
    private val uiEventSource = PublishRelay.create<T>()

    @Suppress("NULLABLE_TYPE_PARAMETER_AGAINST_NOT_NULL_TYPE_PARAMETER")
    protected fun onUiEvent(uiEvent: T) {
        uiEventSource.accept(uiEvent)
    }

    override fun subscribe(observer: Observer<in T>) {
        uiEventSource.subscribe(observer)
    }
}