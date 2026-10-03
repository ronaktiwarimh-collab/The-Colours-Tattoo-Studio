package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.ProcessStep
import com.example.model.TattooDataProvider
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun ProcessSection(
    onStartJourneyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "The Experience",
            title = "TATTOO PROCESS",
            subtitle = "A thoughtful, transparent 5-step journey ensuring comfort, clarity, and exceptional results."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 5-step timeline cards
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            TattooDataProvider.processSteps.forEachIndexed { index, step ->
                TimelineStepRow(
                    step = step,
                    isLast = index == TattooDataProvider.processSteps.lastIndex
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LuxuryGoldButton(
            text = "START YOUR TATTOO JOURNEY",
            onClick = onStartJourneyClick,
            icon = Icons.AutoMirrored.Filled.ArrowForward,
            modifier = Modifier.fillMaxWidth(),
            testTag = "process_start_journey_button"
        )
    }
}

@Composable
private fun TimelineStepRow(
    step: ProcessStep,
    isLast: Boolean
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        // Step number indicator column with connecting line
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(44.dp)
        ) {
            Surface(
                color = CardBackground,
                shape = CircleShape,
                border = androidx.compose.foundation.BorderStroke(1.dp, AntiqueGold),
                modifier = Modifier.size(36.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = step.stepNumber,
                        style = MaterialTheme.typography.labelSmall,
                        color = AntiqueGold,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(1.5.dp)
                        .height(64.dp)
                        .background(BorderColor)
                )
            }
        }

        Spacer(modifier = Modifier.width(12.dp))

        // Step content card
        LuxuryCard(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = if (isLast) 0.dp else 14.dp)
        ) {
            Column(
                modifier = Modifier.padding(14.dp)
            ) {
                Text(
                    text = step.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontFamily = FontFamily.Serif,
                    color = WarmIvory,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.5.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = step.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = SecondaryText,
                    lineHeight = 19.sp
                )
            }
        }
    }
}
