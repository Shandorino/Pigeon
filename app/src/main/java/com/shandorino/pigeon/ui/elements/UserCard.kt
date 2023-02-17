package com.shandorino.pigeon.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shandorino.domain.model.UserModel
import com.shandorino.pigeon.R
import com.shandorino.pigeon.ui.theme.background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCard(
    user: UserModel,
    onCardClicked: () -> Unit,
    onCardLongPress: () -> Unit
    ) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(background)
            .border(1.dp,Color.Black, RectangleShape)
    ) {
        Image(
            painter = painterResource(id = R.drawable.og),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 10.dp, end = 15.dp)
                .size(70.dp)
                .clip(CircleShape),
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.90f),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = user.username, fontSize = 20.sp, fontWeight = FontWeight.W600)
            Text(text = user.lastMessage, fontSize = 17.sp)
            Spacer(modifier = Modifier.padding(3.dp))
        }

        if (!user.isReaded) {
            Badge(modifier = Modifier.size(10.dp), containerColor = Color(0xFFD2BAB0))
        }

        if (user.newMessageCount > 0) {
            Badge(containerColor = Color(0xFFD2BAB0)) {
                Text(text = user.newMessageCount.toString())
            }
        }
    }


}

//@Preview
//@Composable
//fun UserCardPreview() {
//    val user = UserModel("Dimon", null)
//    UserCard(user = user, lastMessage = "Привет", isReaded = false, newMessageCount = 0, {}, {})
//}