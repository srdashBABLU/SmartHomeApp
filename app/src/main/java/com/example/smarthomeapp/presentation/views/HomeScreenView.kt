package com.example.smarthomeapp.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeapp.data.DMSansSemiBold
import com.example.smarthomeapp.ui.theme.black
import com.example.smarthomeapp.ui.theme.deepGray
import com.example.smarthomeapp.ui.theme.gray
import com.example.smarthomeapp.ui.theme.white

@Composable
fun HomeScreen(){
    Column(
        modifier = Modifier.fillMaxSize().background(black)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(56.dp),
                colors = CardDefaults.cardColors(gray.copy(0.5f)),
                shape = CircleShape
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier.size(32.dp).scale(0.9f)
                    )
                }
            }
            Card(
                modifier = Modifier.size(56.dp),
                colors = CardDefaults.cardColors(gray.copy(0.5f)),
                shape = CircleShape
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        tint = white,
                        modifier = Modifier.size(32.dp).scale(0.9f)
                    )
                }
            }
        }
        Text(
            text = "John's Home",
            style = TextStyle(
                fontFamily = DMSansSemiBold,
                fontSize = 36.sp
            ),
            color = white,
            modifier = Modifier.padding(start = 24.dp)
        )
        Text(
            text = "Monitor and control your home",
            style = TextStyle(
                fontFamily = DMSansSemiBold,
                fontSize = 14.sp
            ),
            color = gray,
            modifier = Modifier.padding(start = 24.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier,

            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun homeScreenPrev(){
    HomeScreen()
}