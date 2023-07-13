package com.bm.Droid.android.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.adeo.kviewmodel.odyssey.StoredViewModel
import com.bm.Droid.android.R
import com.bm.Droid.android.screens.main.models.MainScreenButtonType
import com.bm.Droid.android.screens.main.models.MainScreenEvent
import com.bm.Droid.android.screens.main.models.MainScreenViewState
import ru.alexgladkov.odyssey.compose.local.LocalRootController

internal const val MAIN_SCREEN_NAV_ID = "main"

@Composable
fun MainScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { MainViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().collectAsState()
        val viewAction = viewModel.viewActions().collectAsState(null)

        when (val state = viewState.value) {
            is MainScreenViewState.Content -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colors.background,
                                    MaterialTheme.colors.primary
                                )
                            )
                        )
                ) {
                    Column(
                        modifier = Modifier.align(Alignment.Center),
                        horizontalAlignment = CenterHorizontally,
                    ) {
                        state.buttons.forEach { mainScreenButton ->
                            Button(
                                modifier = Modifier
                                    .size(width = 240.dp, height = 50.dp)
                                    .clip(RoundedCornerShape(14.dp)),
                                onClick = {
                                    viewModel.obtainSingleEvent(
                                        MainScreenEvent.OnMainScreenButtonClicked(
                                            mainScreenButton.type
                                        )
                                    )
                                },
                            ) {
                                MainScreenButtonText(type = mainScreenButton.type)
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                    Row(modifier = Modifier
                        .align(BottomCenter)
                        .clickable {
                            viewModel.obtainSingleEvent(MainScreenEvent.OnMuteSoundButtonClicked)
                        }
                    ) {
                        Icon(
                            painterResource(id = if (state.isSoundMuted) R.drawable.music_note_off else R.drawable.music_note_on),
                            contentDescription = null,
                            modifier = Modifier
                                .size(width = 50.dp, height = 50.dp)
                                .padding(10.dp),
                            tint = MaterialTheme.colors.onPrimary
                        )
                        Text(
                            text = stringResource(id = if (state.isSoundMuted) R.string.scr_main_txt_sounds_off else R.string.scr_main_txt_sounds_on),
                            style = TextStyle(
                                color = MaterialTheme.colors.onPrimary
                            ),
                            modifier = Modifier.align(CenterVertically).padding(end = 10.dp)
                        )
                    }
                }
            }

            MainScreenViewState.Initial -> {}
        }

        LaunchedEffect(key1 = Unit, block = {
            viewModel.obtainSingleEvent(MainScreenEvent.InitScreen)
        })
    }
}

@Composable
private fun MainScreenButtonText(type: MainScreenButtonType) = Text(
    text = stringResource(
        id = when (type) {
            MainScreenButtonType.StartGame -> R.string.scr_main_btn_start_game
            MainScreenButtonType.Records -> R.string.scr_main_btn_records
            MainScreenButtonType.About -> R.string.scr_main_btn_info
            MainScreenButtonType.OtherGames -> R.string.scr_main_btn_other_games
        }
    ).uppercase(),
    style = MaterialTheme.typography.body1
)