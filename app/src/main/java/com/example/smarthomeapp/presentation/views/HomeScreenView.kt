package com.example.smarthomeapp.presentation.views

import android.content.ClipData.Item
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeapp.data.DMSansSemiBold
import com.example.smarthomeapp.ui.theme.black
import com.example.smarthomeapp.ui.theme.deepGray
import com.example.smarthomeapp.ui.theme.gray
import com.example.smarthomeapp.ui.theme.lightOrange
import com.example.smarthomeapp.ui.theme.orange
import com.example.smarthomeapp.ui.theme.purple
import com.example.smarthomeapp.ui.theme.violet
import com.example.smarthomeapp.ui.theme.white
import com.example.smarthomeapp.ui.theme.yellow

@Composable
fun HomeScreen(navController: NavController){
    BlurredCanvasWithRoundedCorners()
    Column(
        modifier = Modifier.fillMaxSize().background(Color.Transparent)
    ) {
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth().padding(22.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = Modifier.size(56.dp),
                colors = CardDefaults.cardColors(gray.copy(0.4f)),
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
                colors = CardDefaults.cardColors(gray.copy(0.4f)),
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
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
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
//        StackedScrollableCards()
//        StackedCards()
//        StackedCardsWithScroll()
        StackedCardsWithCanvas()
    }
}

@Composable
fun BlurredCanvasWithRoundedCorners() {
    Box(
        modifier = Modifier.fillMaxSize().background(black)
            .blur(96.dp), // Apply blur as a modifier
        contentAlignment = Alignment.TopCenter
    ) {
        Canvas(
            modifier = Modifier.width(300.dp).height(80.dp).offset(y = (-20).dp).scale(1.3f)
        ) {
            val cornerRadius = 24.dp.toPx()
            val rectSize = size

            // Draw a rounded rectangle
            drawRoundRect(
                color = yellow.copy(alpha = 0.5f), // Semi-transparent color
                topLeft = Offset(0f, 0f),
                size = rectSize,
                cornerRadius = CornerRadius(cornerRadius, cornerRadius)
            )
        }
        Canvas(
            modifier = Modifier.width(200.dp).height(80.dp).offset(y = 30.dp).scale(0.9f)
        ) {
            val cornerRadius = 24.dp.toPx()
            val rectSize = size

            // Draw a rounded rectangle
            drawRoundRect(
                color = orange.copy(alpha = 0.6f), // Semi-transparent color
                topLeft = Offset(0f, 0f),
                size = rectSize,
                cornerRadius = CornerRadius(cornerRadius, cornerRadius)
            )
        }
    }
}

@Composable
fun StackedScrollableCards() {
    val cardData = listOf("Smart TV", "Light", "AC", "Music Box", "Smart TV", "Light", "AC", "Music Box") // Card titles
    val colors = listOf(
        Color(0xFFDCE775),
        Color(0xFFFF7043),
        Color(0xFFFFA726),
        Color(0xFFCE93D8),
        Color(0xFFDCE775),
        Color(0xFFFF7043),
        Color(0xFFFFA726),
        Color(0xFFCE93D8)
    ) // Card colors

    // Track the expanded state of cards
    val expandedCardIndex = remember { mutableStateOf(0) } // Default expanded card index

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .pointerInput(Unit) {
                detectVerticalDragGestures { change, dragAmount ->
                    change.consume() // Consume gesture
                    if (dragAmount > 0) {
                        // Swipe down
                        if (expandedCardIndex.value > 0) {
                            expandedCardIndex.value -= 1
                        }
                    } else {
                        // Swipe up
                        if (expandedCardIndex.value < cardData.lastIndex) {
                            expandedCardIndex.value += 1
                        }
                    }
                }
        },
        //contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        itemsIndexed(cardData) { index, title ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .graphicsLayer {
                        translationY = if (index > expandedCardIndex.value) (index - expandedCardIndex.value) * 50.dp.toPx() else 0f
                        scaleX = if (index == expandedCardIndex.value) 1f else 0.95f
                        scaleY = if (index == expandedCardIndex.value) 1f else 0.95f
                    }
                    .zIndex(if (index == expandedCardIndex.value) 1f else 0f)
                    .animateContentSize() // Smooth animation when size changes
                    .clip(RoundedCornerShape(24.dp))
                    .background(colors[index])
                    .clickable {
                        expandedCardIndex.value = index // Expand the clicked card
                    }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp, // Example icon
                        contentDescription = "Card Icon",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = title,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.PlayArrow, // Power icon
                        contentDescription = "Power Button",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp)) // Space between cards
        }
    }
}

@Composable
fun StackedCardsWithScroll() {
    val cardData = listOf("Smart TV", "Light", "AC", "Music Box")
    val colors = listOf(
        Color(0xFFDCE775),
        Color(0xFFFF7043),
        Color(0xFFFFA726),
        Color(0xFFCE93D8)
    )

    val scrollState = rememberLazyListState()

    LazyColumn(
        state = scrollState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        itemsIndexed(cardData) { index, title ->
            val offsetY = remember { Animatable(0f) }
            val scale = remember { Animatable(1f) }

            // Calculate position based on scroll
            LaunchedEffect(scrollState.firstVisibleItemIndex, scrollState.firstVisibleItemScrollOffset) {
                val targetOffset = if (scrollState.firstVisibleItemIndex > index) {
                    50f * (scrollState.firstVisibleItemIndex - index)
                } else {
                    0f
                }
                offsetY.animateTo(targetOffset)
                scale.animateTo(if (scrollState.firstVisibleItemIndex == index) 1f else 0.95f)
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .graphicsLayer {
                        translationY = offsetY.value
                        scaleX = scale.value
                        scaleY = scale.value
                        shadowElevation = 8f
                    }
                    .zIndex(if (scrollState.firstVisibleItemIndex == index) 1f else 0f)
                    .clip(RoundedCornerShape(24.dp))
                    .background(colors[index])
                    .clickable { }
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.ThumbUp,
                        contentDescription = "Card Icon",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = title,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Power Button",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun StackedCardsWithCanvas() {
    val cardData = listOf("Smart TV", "Light", "AC", "Music Box")
    val colors = listOf(
        yellow,
        orange,
        lightOrange,
        purple
    )

    val cardHeight = 250.dp
    val cardSpacing = 120.dp
    val totalScrollRange = (cardHeight + cardSpacing) * (cardData.size - 1)

    var scrollOffset by remember { mutableStateOf(0f) }

    // Gesture detection for scroll
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
//            .pointerInput(Unit) {
//                detectVerticalDragGestures { _, dragAmount ->
//                    scrollOffset = (scrollOffset + dragAmount).coerceIn(0f, totalScrollRange.toPx())
//                }
//            }
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            cardData.forEachIndexed { index, title ->
                val progress = (scrollOffset / totalScrollRange.toPx())
                val cardOffset = (index - progress) * cardSpacing.toPx()
                val scale = 0.9f //+ (0.05f * (index - progress).coerceAtLeast(0f))

                // Line parameters
                val lineWidth = 4.dp.toPx()
                val verticalLineLength = 5.dp.toPx() // Vertical segment length
                val horizontalLineLength = 70.dp.toPx() // Horizontal segment length
                val bendRadius = 64.dp.toPx() // Radius of the rounded bend

                // Starting position (left vertical side)
                val startX = 40.dp.toPx() // X position of the starting point
                val startY = 90.dp.toPx() // Y position of the starting point

                // Only draw visible cards
                if (cardOffset + cardHeight.toPx() > 0 && cardOffset < canvasHeight) {
                    drawIntoCanvas { canvas ->
                        val paint = android.graphics.Paint().apply {
                            color = colors[index].toArgb()
                            setShadowLayer(80f, 0f, 0f, android.graphics.Color.argb(128, 0, 0, 0))
                        }

                        // Draw shadowed rounded rectangle
                        canvas.nativeCanvas.drawRoundRect(
                            (canvasWidth - canvasWidth * scale) / 2,
                            cardOffset,
                            (canvasWidth + canvasWidth * scale) / 2,
                            cardOffset + cardHeight.toPx() * scale,
                            48.dp.toPx(), // Corner radius X
                            48.dp.toPx(), // Corner radius Y
                            paint
                        )
                        // Path for the rounded line
                        val path = Path().apply {
                            // Start from the left vertical side
                            moveTo(startX, startY)

                            // Draw vertical line upwards
                            lineTo(startX, startY - verticalLineLength)

                            // Arc for the rounded bend (90 degrees)
                            arcTo(
                                rect = Rect(
                                    left = startX ,
                                    top = startY - verticalLineLength - bendRadius,
                                    right = startX + bendRadius,
                                    bottom = startY
                                ),
                                startAngleDegrees = 180f, // Starting from the left
                                sweepAngleDegrees = 90f, // Sweep 90 degrees
                                forceMoveTo = false
                            )

                            // Draw horizontal line to the right
                            lineTo(startX + horizontalLineLength, startY - verticalLineLength - bendRadius)
                        }

                        // Draw the path with rounded stroke caps
                        drawPath(
                            path = path,
                            color = Color.White,
                            style = Stroke(
                                width = lineWidth,
                                cap = StrokeCap.Round
                            )
                        )
                    }

                    // Draw text inside the card
                    drawContext.canvas.nativeCanvas.apply {
                        val textPaint = android.graphics.Paint().apply {
                            color = android.graphics.Color.WHITE
                            textSize = 40f * scale
                            textAlign = android.graphics.Paint.Align.LEFT
                        }
                        drawText(
                            title,
                            canvasWidth / 2 - 150f * scale,
                            cardOffset + 80f * scale,
                            textPaint
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RoundedLineWithCustomBend() {
    Canvas(modifier = Modifier.size(300.dp).background(Color.Black)) {
        // Line parameters
        val lineWidth = 4.dp.toPx()
        val verticalLineLength = 50.dp.toPx() // Vertical segment length
        val horizontalLineLength = 50.dp.toPx() // Horizontal segment length
        val bendRadius = 24.dp.toPx() // Radius of the rounded bend

        // Starting position (left vertical side)
        val startX = 50.dp.toPx() // X position of the starting point
        val startY = 100.dp.toPx() // Y position of the starting point

        // Path for the rounded line
        val path = Path().apply {
            // Start from the left vertical side
            moveTo(startX, startY)

            // Draw vertical line upwards
            lineTo(startX, startY - verticalLineLength)

            // Arc for the rounded bend (90 degrees)
            arcTo(
                rect = Rect(
                    left = startX - bendRadius,
                    top = startY - verticalLineLength - bendRadius,
                    right = startX + bendRadius,
                    bottom = startY - verticalLineLength + bendRadius
                ),
                startAngleDegrees = 180f, // Starting from the left
                sweepAngleDegrees = 90f, // Sweep 90 degrees
                forceMoveTo = false
            )

            // Draw horizontal line to the right
            lineTo(startX + horizontalLineLength, startY - verticalLineLength - bendRadius)
        }

        // Draw the path with rounded stroke caps
        drawPath(
            path = path,
            color = Color.White,
            style = Stroke(
                width = lineWidth,
                cap = StrokeCap.Round
            )
        )
    }
}

@Composable
fun StackedCards(){
    LazyColumn(
        modifier = Modifier
    ) {
        item(){
            Card(
                modifier = Modifier.fillMaxWidth().padding(16.dp).height(298.dp),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(orange)
            ) {

            }
        }
        item(){
            Card(
                modifier = Modifier.fillMaxWidth().padding(16.dp).height(96.dp).offset(y = 20.dp),
                shape = RoundedCornerShape(32.dp),
                colors = CardDefaults.cardColors(orange)
            ) {

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPrev(){
    val nav = rememberNavController()
    HomeScreen(nav)
}