package com.shandorino.pigeon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shandorino.pigeon.Greeting
import com.shandorino.pigeon.R
import com.shandorino.pigeon.ui.theme.PigeonTheme
import com.shandorino.pigeon.ui.theme.background

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PigeonTheme {
        HelloScreen()
    }
}


@Composable
fun HelloScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo()
        Spacer(modifier = Modifier.padding(30.dp))
        Text(text = "Добро пожаловать в", fontSize = 25.sp)
        Text(text = "Pigeon", fontSize = 30.sp)
        Spacer(modifier = Modifier.padding(50.dp))
        Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = Color(0xFFE7CDC2),
                    contentColor = Color.Black
                )
            ) {
            Text(text = "Отправить голубя", fontSize = 20.sp)
        }
    }
}

@Composable
fun Logo() {
    Box(
        modifier = Modifier
            .padding(top = 50.dp)
            .size(225.dp)
            .clip(CircleShape)
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFFFEE2D5), Color(0xFFE7CDC2), Color(0xFFFEE9DF)),
                    start = Offset.Zero,
                    end = Offset.Infinite
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier.size(150.dp)

        )
    }
}