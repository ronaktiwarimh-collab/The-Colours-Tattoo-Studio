package com.example.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Palette
import androidx.compose.material.icons.filled.Sanitizer
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun AboutSection(
    onEnquireClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "Our Philosophy",
            title = "The Art of Meaningful Tattooing",
            subtitle = "Founded on craftsmanship, meticulous hygiene, and personalized artistic expression."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Main narrative card
        LuxuryCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(18.dp)
            ) {
                Text(
                    text = "A Personalized Tattoo Experience",
                    style = MaterialTheme.typography.titleLarge,
                    fontFamily = FontFamily.Serif,
                    color = AntiqueGold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = "At The Colours Tattoo Studio, tattooing is more than ink on skin — it is the visual celebration of your personal story, values, and journey. Led by Shekhar Nayak with over 9+ years of professional tattooing experience, we deliver tailored tattoo concepts crafted with artistic quality, rigorous hygiene, and uncompromising attention to detail.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = WarmIvory,
                    lineHeight = 24.sp
                )

                Spacer(modifier = Modifier.height(18.dp))

                // Feature grid
                AboutFeatureItem(
                    title = "Personalised Consultation",
                    desc = "Every piece begins with understanding your story, aesthetic preferences, and anatomical placement."
                )
                Spacer(modifier = Modifier.height(12.dp))

                AboutFeatureItem(
                    title = "Custom Tattoo Concepts",
                    desc = "Original artwork conceptualized and adapted to your specifications rather than repeated templates."
                )
                Spacer(modifier = Modifier.height(12.dp))

                AboutFeatureItem(
                    title = "Hygiene & Responsible Care",
                    desc = "Single-use sterile needles, medical-grade sanitization, and structured post-tattoo guidance."
                )
                Spacer(modifier = Modifier.height(12.dp))

                AboutFeatureItem(
                    title = "9+ Years of Refined Craft",
                    desc = "Over nine years of hands-on tattooing mastery across realism, portraiture, cover-ups, and fine linework."
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LuxuryGoldButton(
            text = "ENQUIRE NOW",
            onClick = onEnquireClick,
            modifier = Modifier.fillMaxWidth(),
            testTag = "about_enquire_button"
        )
    }
}

@Composable
private fun AboutFeatureItem(
    title: String,
    desc: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            tint = AntiqueGold,
            modifier = Modifier
                .padding(top = 2.dp)
                .size(18.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                color = WarmIvory,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = desc,
                style = MaterialTheme.typography.bodySmall,
                color = SecondaryText,
                lineHeight = 18.sp
            )
        }
    }
}
