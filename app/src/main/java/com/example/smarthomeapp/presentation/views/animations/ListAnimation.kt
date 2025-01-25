package com.example.smarthomeapp.presentation.views.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.smarthomeapp.presentation.views.animations.common.Contact
import com.example.smarthomeapp.presentation.views.animations.utils.generateContrastingColors
import com.example.smarthomeapp.presentation.views.animations.utils.contactList

@Composable
fun ListAnimation() {

    val contactList by remember { mutableStateOf(contactList) }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Text(
            text = "All Contacts",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            contactList.forEach() { contact ->
                item(){
                    ContactItem(contact = contact)
                }
            }
        }
    }
}

@Composable
fun ContactItem(contact: Contact) {
    val (textColor, backgroundColor) = generateContrastingColors()

    var isVisible by remember { mutableStateOf(false ) }

    LaunchedEffect(Unit) {
        isVisible = true
    }

    val bgColor by animateColorAsState(
        targetValue = if (!isVisible)
            backgroundColor else Color(0xFF202020), label = ""
        , animationSpec = tween(600)
    )

    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(
            animationSpec = tween(500)
        ) + scaleIn(
            animationSpec = tween(500)
        ),
        exit = fadeOut(
            animationSpec = tween(500)
        ) + scaleOut(
            animationSpec = tween(500)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(bgColor, RoundedCornerShape(16.dp))
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(color = backgroundColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = contact.name.first().toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = textColor,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = contact.name,
                    color = Color.White,
                    fontSize = 18.sp
                )
                Text(
                    text = contact.number,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview
@Composable
private fun ListAnimationPreview() {
    ListAnimation()
}