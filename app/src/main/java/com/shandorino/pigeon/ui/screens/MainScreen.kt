package com.shandorino.pigeon.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shandorino.domain.model.UserModel
import com.shandorino.pigeon.R
import com.shandorino.pigeon.ui.elements.UserCard
import com.shandorino.pigeon.ui.theme.background

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}

val userList = listOf<UserModel>(
    UserModel(1,"asd", null, "asd", false, 0),
    UserModel(2,"qwe", null, "qwe", true, 1),
    UserModel(3,"zxc", null, "zxc", false, 0),
    UserModel(4,"vbn", null, "vbn", true, 5),
    UserModel(5,"asd", null, "asd", false, 0),
    UserModel(6,"qwe", null, "qwe", true, 1),
    UserModel(7,"zxc", null, "zxc", false, 0),
    UserModel(8,"vbn", null, "vbn", true, 5),
    UserModel(9,"asd", null, "asd", false, 0),
    UserModel(10,"qwe", null, "qwe", true, 1),
    UserModel(11,"zxc", null, "zxc", false, 0),
    UserModel(12,"vbn", null, "vbn", true, 5),
)



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopBar()
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .nestedScroll(connection = object : NestedScrollConnection {})
        ) {
            itemsIndexed(
                items = userList,
                key = {_, user -> user.id}
            ) { index, user ->
                UserCard(user = user, onCardClicked = { }, onCardLongPress = {})
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(45.dp)
        .background(Color(0xFFE7CDC2)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = R.drawable.baseline_dehaze_24),
            contentDescription = "",
        modifier = Modifier
            .size(35.dp)
            .padding(start = 10.dp))
        Spacer(modifier = Modifier.padding(horizontal = 10.dp))
        Text(text = "Pigeon", fontSize = 20.sp, fontWeight = FontWeight.W600)
    }
}