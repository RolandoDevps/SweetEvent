package com.example.sweetevent.view

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.sweetevent.R
import com.example.sweetevent.ui.theme.primaryColor
import com.example.sweetevent.ui.theme.secondaryColor
import kotlinx.coroutines.delay

@Composable
fun LoadingView() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background,
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = R.mipmap.ic_logo_foreground), contentDescription = "logo")
            LoaDingAnimation()
        }
    }

}

@Composable
fun Greeting(name: String){
    Text(text = "Hello $name!")
}

@Composable
fun LoaDingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 15.dp,
    circleBorder: Dp = 1.dp,
    circleColor: Color = secondaryColor,
    spaceBetween: Dp = 10.dp,
){
    val circles = listOf(
        remember { Animatable(primaryColor) },
        remember { Animatable(primaryColor) },
        remember { Animatable(primaryColor) }
    )

    circles.forEachIndexed { index, animatable ->
        /*LaunchedEffect(key1 = animatable, block = circles.get(index)){
            animatable.animateTo(
                secondaryColor,
                infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        primaryColor at 0 with LinearOutSlowInEasing
                        secondaryColor at 300 with LinearOutSlowInEasing
                        primaryColor at 600 with LinearOutSlowInEasing
                        primaryColor at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }*/

        LaunchedEffect(Unit) {
            delay(index * 1000L)
            animatable.animateTo(
                secondaryColor,
                //animationSpec = tween(1000))
                /*infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        primaryColor at 0 with LinearOutSlowInEasing
                        secondaryColor at 1200 with LinearOutSlowInEasing
                        /*primaryColor at 600 with LinearOutSlowInEasing
                        primaryColor at 1200 with LinearOutSlowInEasing*/
                    },
                    repeatMode = RepeatMode.Restart
                )*/
                repeatable(
                    1,
                    animation = keyframes {
                        durationMillis = 1200
                        primaryColor at 0 with LinearOutSlowInEasing
                        secondaryColor at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValues = circles.map{ it.value }
    val laxtCircleIndex = circleValues.size - 1

    Row(modifier = modifier) {
        circleValues.forEachIndexed { index, color -> 
            Box(modifier = Modifier
                .size(circleSize)
                .border(circleBorder, secondaryColor, CircleShape)
                .background(color, CircleShape)
            )

            if(index != laxtCircleIndex){
                Spacer(modifier = Modifier.width(spaceBetween))
            }
        }

    }
}