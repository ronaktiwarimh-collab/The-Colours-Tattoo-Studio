package com.example.ui.components

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.AntiqueGoldHover
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun SectionHeader(
    tag: String,
    title: String,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    alignStart: Boolean = false
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalAlignment = if (alignStart) Alignment.Start else Alignment.CenterHorizontally
    ) {
        // Tag badge
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 6.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(width = 16.dp, height = 1.dp)
                    .background(AntiqueGold)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = tag.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                color = AntiqueGold,
                letterSpacing = 2.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.width(8.dp))
            Box(
                modifier = Modifier
                    .size(width = 16.dp, height = 1.dp)
                    .background(AntiqueGold)
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge,
            color = WarmIvory,
            textAlign = if (alignStart) TextAlign.Start else TextAlign.Center,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        if (subtitle != null) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = SecondaryText,
                textAlign = if (alignStart) TextAlign.Start else TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier.padding(horizontal = if (alignStart) 0.dp else 12.dp)
            )
        }
    }
}

@Composable
fun AiConceptBadge(
    modifier: Modifier = Modifier
) {
    Surface(
        color = DeepCharcoal.copy(alpha = 0.88f),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(0.75.dp, AntiqueGold.copy(alpha = 0.8f)),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = null,
                tint = AntiqueGold,
                modifier = Modifier.size(11.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "AI CONCEPT — DESIGN INSPIRATION",
                color = WarmIvory,
                fontSize = 9.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 0.5.sp
            )
        }
    }
}

@Composable
fun ComingSoonBadge(
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = SecondaryCharcoal.copy(alpha = 0.92f),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(1.dp, BorderColor),
        modifier = modifier
    ) {
        Text(
            text = text.uppercase(),
            color = AntiqueGold,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun LuxuryGoldButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    testTag: String = "luxury_gold_button"
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = AntiqueGold,
            contentColor = DeepCharcoal
        ),
        shape = RoundedCornerShape(2.dp),
        modifier = modifier
            .height(48.dp)
            .testTag(testTag)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = DeepCharcoal,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.2.sp
        )
    }
}

@Composable
fun LuxuryOutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    testTag: String = "luxury_outline_button"
) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = WarmIvory
        ),
        border = BorderStroke(1.dp, AntiqueGold),
        shape = RoundedCornerShape(2.dp),
        modifier = modifier
            .height(48.dp)
            .testTag(testTag)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = AntiqueGold,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Text(
            text = text.uppercase(),
            style = MaterialTheme.typography.labelLarge,
            color = WarmIvory,
            fontWeight = FontWeight.Medium,
            letterSpacing = 1.2.sp
        )
    }
}

@Composable
fun LuxuryCard(
    modifier: Modifier = Modifier,
    backgroundColor: Color = CardBackground,
    borderColor: Color = BorderColor,
    content: @Composable () -> Unit
) {
    Surface(
        color = backgroundColor,
        shape = RoundedCornerShape(6.dp),
        border = BorderStroke(1.dp, borderColor),
        modifier = modifier
    ) {
        content()
    }
}
