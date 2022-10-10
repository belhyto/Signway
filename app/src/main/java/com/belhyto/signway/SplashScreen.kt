package com.belhyto.signway

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.belhyto.signway.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun SignSplash(navController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphaAnim= animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000 //3 seconds
        )
    )
    LaunchedEffect(key1 = true) //triggers code in block
    {
        startAnimation= true
        delay(3000)
        navController.popBackStack()
        navController.navigate(Screen.Home.route) //navigate to home screen once done
    }
    Splash(alpha= alphaAnim.value)

}
@Composable
fun Splash(alpha: Float)
{
    Box(modifier= Modifier
        .background(Color.White)
        .fillMaxSize(),
        contentAlignment = Alignment.Center

    ){

        Image(
            painter = painterResource(R.drawable.bookmark),
            contentDescription = "Logo",
            modifier = Modifier.size(120.dp)
                .alpha(alpha=alpha)

        )
    }
}

@Composable
@Preview
fun splashPreview()
{
    Splash(alpha= 1f)
}

