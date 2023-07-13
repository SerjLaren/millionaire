package com.bm.Droid.android.navigation

import com.bm.Droid.android.screens.info.INFO_SCREEN_NAV_ID
import com.bm.Droid.android.screens.info.InfoScreen
import com.bm.Droid.android.screens.main.MAIN_SCREEN_NAV_ID
import com.bm.Droid.android.screens.main.MainScreen
import com.bm.Droid.android.screens.splash.SPLASH_SCREEN_NAV_ID
import com.bm.Droid.android.screens.splash.SplashScreen
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder

internal fun RootComposeBuilder.navigationGraph() {
    screen(SPLASH_SCREEN_NAV_ID) {
        SplashScreen()
    }
    screen(MAIN_SCREEN_NAV_ID) {
        MainScreen()
    }
    screen(INFO_SCREEN_NAV_ID) {
        InfoScreen()
    }
}