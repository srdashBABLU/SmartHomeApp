package com.example.smarthomeapp.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
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
import com.example.smarthomeapp.data.DMSansRegular
import com.example.smarthomeapp.data.DMSansSemiBold
import com.example.smarthomeapp.ui.theme.black
import com.example.smarthomeapp.ui.theme.deepGray
import com.example.smarthomeapp.ui.theme.gray
import com.example.smarthomeapp.ui.theme.purple
import com.example.smarthomeapp.ui.theme.violet
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
                modifier = Modifier.fillMaxWidth().height(160.dp),
                colors = CardDefaults.cardColors(deepGray),
                shape = RoundedCornerShape(32.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                tint = violet.copy(0.6f),
                                modifier = Modifier
                            )
                            Text(
                                text = "72°F",
                                style = TextStyle(
                                    fontFamily = DMSansSemiBold,
                                    fontSize = 28.sp
                                ),
                                color = white
                            )
                            Text(
                                text = "Room \nTemperature",
                                style = TextStyle(
                                    fontFamily = DMSansSemiBold,
                                    fontSize = 10.sp
                                ),
                                color = gray
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = null,
                                tint = white.copy(0.6f),
                                modifier = Modifier
                            )
                            Column {
                                Text(
                                    text = "4/6",
                                    style = TextStyle(
                                        fontFamily = DMSansSemiBold,
                                        fontSize = 16.sp
                                    ),
                                    color = white
                                )
                                Text(
                                    text = "Active Device",
                                    style = TextStyle(
                                        fontFamily = DMSansSemiBold,
                                        fontSize = 10.sp
                                    ),
                                    color = gray
                                )
                            }
                        }
                    }
                    Row {
                        Card(
                            modifier = Modifier.padding(8.dp).fillMaxWidth().height(56.dp),
                            shape = CircleShape,
                            colors = CardDefaults.cardColors(violet)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxSize().clickable(onClick = {}),
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = null,
                                    tint = white
                                )
                                Text(
                                    text = "Living Room",
                                    style = TextStyle(
                                        fontFamily = DMSansSemiBold,
                                        fontSize = 18.sp
                                    ),
                                    color = white
                                )
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowDown,
                                    contentDescription = null,
                                    tint = white
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun homeScreenPrev(){
    HomeScreen()
}