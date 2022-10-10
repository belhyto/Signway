package com.belhyto.signway

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.belhyto.signway.navigation.Screen

fun showToast(context: Context, message: String)
{
    Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
}
@Composable
fun SignWelcome(navController: NavHostController)
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center

    ) {
        Text(
            text = "Welcome to SignWay\n " +
                    "Learn sign language now ",
            color= MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h2,

            )

        Spacer(modifier = Modifier.size(100.dp))
        val context= LocalContext.current

        Button(onClick = { showToast(context,"Clicked on next") },
            modifier= Modifier
                .align(Alignment.BottomEnd)
                .width(width = 200.dp)
                .height(85.dp),

            elevation = ButtonDefaults.elevation(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary,
                contentColor = Color.White

            ))
        {
            Text(text = "Next",
                style = MaterialTheme.typography.h2,
                modifier= Modifier.clickable { navController.navigate(Screen.Menu.route) },
                )

        }
    }
}

@Composable
@Preview
fun HomePreview()
{
    SignWelcome(
        navController = rememberNavController()
    )
}