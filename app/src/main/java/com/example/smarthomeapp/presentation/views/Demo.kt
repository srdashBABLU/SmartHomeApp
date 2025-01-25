package com.example.smarthomeapp.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SmartHomeApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DeviceCard(
            deviceName = "Smart TV",
            deviceIcon = Icons.Default.Home,
            backgroundColor = Color(0xFFCFE49B)
        )
        DeviceCard(
            deviceName = "Light",
            deviceIcon = Icons.Default.Home,
            backgroundColor = Color(0xFFFF6F4A)
        )
        DeviceCard(
            deviceName = "AC",
            deviceIcon = Icons.Default.Home,
            backgroundColor = Color(0xFFFF9B84)
        )
        DeviceCard(
            deviceName = "Music Box",
            deviceIcon = Icons.Default.Home,
            backgroundColor = Color(0xFFD9B3FF)
        )
    }
}

@Composable
fun DeviceCard(deviceName: String, deviceIcon: ImageVector, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(vertical = 4.dp)
            .background(backgroundColor, RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = deviceIcon,
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = deviceName,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.weight(1f))
            VerticalButton()
        }
    }
}

@Composable
fun VerticalButton() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.White, RoundedCornerShape(25.dp))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Action",
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSmartHomeApp() {
    SmartHomeApp()
}