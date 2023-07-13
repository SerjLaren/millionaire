package com.bm.Droid.android.screens.game

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.odyssey.StoredViewModel
import com.bm.Droid.android.R
import com.bm.Droid.android.screens.game.models.GameScreenEvent
import com.bm.Droid.android.screens.game.models.GameScreenViewState
import com.bm.Droid.android.screens.game.models.HintType
import ru.alexgladkov.odyssey.compose.local.LocalRootController

internal const val GAME_SCREEN_NAV_ID = "game"

@Composable
fun GameScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { GameViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().collectAsState()
        val viewAction = viewModel.viewActions().collectAsState(null)
        val questionScroll = rememberScrollState(0)

        when (val state = viewState.value) {
            is GameScreenViewState.Content -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    MaterialTheme.colors.background,
                                    MaterialTheme.colors.secondary
                                )
                            )
                        )
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        state.hints.forEach { hintButton ->
                            OutlinedButton(
                                colors = ButtonDefaults.outlinedButtonColors(
                                    backgroundColor = Color.Transparent
                                ),
                                border = BorderStroke(0.dp, Color.Transparent),
                                modifier = Modifier.weight(1f).background(color = Color.Transparent),
                                onClick = {
                                    viewModel.obtainEvent(
                                        GameScreenEvent.OnHintButtonClicked(
                                            hintButton.type
                                        )
                                    )
                                }
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.music_note_on),
                                    contentDescription = null,
                                    modifier = Modifier
                                        .size(width = 40.dp, height = 40.dp)
                                        .padding(10.dp),
                                    tint = MaterialTheme.colors.onPrimary
                                )
                            }
                        }
                    }
                    Column(modifier = Modifier.align(Alignment.Center).padding(horizontal = 20.dp)) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(130.dp)
                                .background(color = MaterialTheme.colors.onPrimary, shape = RoundedCornerShape(14.dp))
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colors.primary,
                                    shape = RoundedCornerShape(14.dp)
                                )
                                .padding(10.dp)
                        ) {
                            Text(
                                text = state.question,
                                overflow = TextOverflow.Ellipsis,
                                color = MaterialTheme.colors.primaryVariant,
                                style = TextStyle(fontSize = 18.sp),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(questionScroll)
                                    .align(Center)
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        state.variants.forEach { variantButton ->
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(CenterHorizontally)
                                    .height(50.dp)
                                    .padding(horizontal = 40.dp),
                                onClick = {

                                },
                            ) {
                                Text(text = variantButton.text)
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                }
            }

            GameScreenViewState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }

        LaunchedEffect(key1 = Unit, block = {
            viewModel.obtainEvent(GameScreenEvent.InitScreen)
        })
    }
}

@Composable
private fun HintIcon(hintType: HintType) {
    Icon(
        painterResource(
            id = when (hintType) {
                HintType.FiftyFifty -> R.drawable.music_note_on
                HintType.ByPeople -> R.drawable.music_note_on
                HintType.CallToFriend -> R.drawable.music_note_on
            }
        ),
        contentDescription = null,
        modifier = Modifier
            .size(width = 50.dp, height = 50.dp)
            .padding(10.dp),
        tint = MaterialTheme.colors.onSecondary
    )
}