package com.BM.Droid.ui.about

import com.BM.Droid.ui.about.uievent.AboutUiEventTransformer
import com.badoo.mvicore.android.AndroidBindings
import com.bm.about.AboutFeature
import com.badoo.binder.using

class AboutBinding(
    view: AboutFragment,
    private val aboutFeature: AboutFeature,
) : AndroidBindings<AboutFragment>(view) {
    override fun setup(view: AboutFragment) {
        binder.bind(view to aboutFeature using AboutUiEventTransformer())
        binder.bind(aboutFeature.news to view)
    }
}