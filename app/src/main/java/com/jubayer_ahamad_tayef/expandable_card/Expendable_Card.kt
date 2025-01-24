package com.jubayer_ahamad_tayef.expandable_card

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun ExpendableCard(
    cardTitle: String,
    cardTitleFontSize: TextUnit = MaterialTheme.typography.headlineMedium.fontSize,
    cardTitleFontWeight: FontWeight = FontWeight.Bold,
    cardDescription: String,
    cardDescriptionFontSize: TextUnit = MaterialTheme.typography.bodyMedium.fontSize,
    cardDescriptionFontWeight: FontWeight = FontWeight.Normal,
    cardDescriptionMaxLines: Int = 4,
    cardCornerShape: CornerBasedShape = MaterialTheme.shapes.medium,
    padding: Dp = 12.dp
) {
    var expandedState by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(padding)
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = cardCornerShape,
        onClick = { expandedState = !expandedState }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(padding),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = cardTitle,
                    fontSize = cardTitleFontSize,
                    fontWeight = cardTitleFontWeight,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(
                    modifier = Modifier
                        .rotate(rotationState),
                    onClick = { expandedState = !expandedState }) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null)
                }
            }

            if (expandedState)
                Text(
                    text = cardDescription,
                    fontSize = cardDescriptionFontSize,
                    fontWeight = cardDescriptionFontWeight,
                    maxLines = cardDescriptionMaxLines,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = padding, end = padding, bottom = padding)
                        .align(Alignment.Start)
                )
        }
    }
}