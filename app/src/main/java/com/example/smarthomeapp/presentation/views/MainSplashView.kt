package com.example.smarthomeapp.presentation.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeapp.R
import com.example.smarthomeapp.data.DMSansRegular
import com.example.smarthomeapp.data.DMSansSemiBold
import com.example.smarthomeapp.ui.theme.deepGray
import com.example.smarthomeapp.ui.theme.gray
import com.example.smarthomeapp.ui.theme.violet
import com.example.smarthomeapp.ui.theme.white

@Composable
fun MainSplashScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.home),
            contentDescription = null,
            contentScale = ContentScale.FillHeight
        )
    }
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Seamless Control", 
            style = TextStyle(
                fontFamily = DMSansSemiBold,
                fontSize = 36.sp
            ),
            color = white
        )
        Text(
            text = "Ultimate Comfort",
            style = TextStyle(
                fontFamily = DMSansRegular,
                fontSize = 36.sp
            ),
            color = white
        )
        Spacer(modifier = Modifier.size(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            colors = CardDefaults.cardColors(deepGray),
            shape = RoundedCornerShape(32.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(onClick = {navController.navigate("home")})
                    .padding(start = 6.dp, end = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .height(54.dp)
                        .width(148.dp),
                    colors = CardDefaults.cardColors(violet),
                    shape = CircleShape
                ) {
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier,
                            tint = white
                        )
                        Spacer(modifier = Modifier.size(8.dp))
                        Text(
                            text = "Get Started",
                            style = TextStyle(
                                fontFamily = DMSansRegular,
                                fontSize = 14.sp
                            ),
                            color = white
                        )
                    }
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier
                        .size(54.dp)
                        .scale(0.7f),
                    tint = gray
                )
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun MainSplashScreenPreview(){
    val nav = rememberNavController()
    MainSplashScreen(nav)
}