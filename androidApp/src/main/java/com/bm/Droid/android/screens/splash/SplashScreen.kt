package com.bm.Droid.android.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bm.Droid.android.R
import com.bm.Droid.android.screens.main.MAIN_SCREEN_NAV_ID
import kotlinx.coroutines.delay
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import ru.alexgladkov.odyssey.core.LaunchFlag

internal const val SPLASH_SCREEN_NAV_ID = "splash"

@Composable
internal fun SplashScreen() {
    val rootController = LocalRootController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painterResource(id = R.drawable.ic_splash),
            modifier = Modifier
                .size(width = 70.dp, height = 70.dp)
                .align(Alignment.Center),
            contentDescription = null
        )
        Text(
            text = "by SerjLaren",
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 10.dp)
        )
    }

    LaunchedEffect(key1 = Unit, block = {
        delay(2000) // delay for logo and bottom text reading :)
        rootController.present(MAIN_SCREEN_NAV_ID, launchFlag = LaunchFlag.SingleNewTask)
    })
}