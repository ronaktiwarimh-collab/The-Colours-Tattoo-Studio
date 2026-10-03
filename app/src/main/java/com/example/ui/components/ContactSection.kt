package com.example.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.TattooDataProvider
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun ContactSection(
    onCallClick: () -> Unit,
    onCallSecondaryClick: () -> Unit,
    onWhatsAppClick: () -> Unit,
    onDirectionsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "Studio Location & Inquiries",
            title = "CONTACT THE COLOURS TATTOO STUDIO",
            subtitle = "Reach out directly to Shekhar Nayak to discuss your tattoo idea, size, and schedule."
        )

        Spacer(modifier = Modifier.height(16.dp))

        LuxuryCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                // Founder & Experience
                ContactInfoBlock(
                    label = "FOUNDER & TATTOO ARTIST",
                    value = "Shekhar Nayak",
                    subValue = "9+ Years of Professional Tattooing",
                    icon = Icons.Default.Person
                )

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = BorderColor, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(14.dp))

                // Phone Numbers
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(
                        imageVector = Icons.Default.Call,
                        contentDescription = null,
                        tint = AntiqueGold,
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "PHONE",
                            style = MaterialTheme.typography.labelSmall,
                            color = AntiqueGold,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = TattooDataProvider.PHONE_PRIMARY,
                                style = MaterialTheme.typography.titleMedium,
                                color = WarmIvory,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { onCallClick() }
                            )
                            Text(
                                text = "  /  ",
                                style = MaterialTheme.typography.titleMedium,
                                color = SecondaryText
                            )
                            Text(
                                text = TattooDataProvider.PHONE_SECONDARY,
                                style = MaterialTheme.typography.titleMedium,
                                color = WarmIvory,
                                fontWeight = FontWeight.SemiBold,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(4.dp))
                                    .clickable { onCallSecondaryClick() }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = BorderColor, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(14.dp))

                // WhatsApp
                ContactInfoBlock(
                    label = "WHATSAPP",
                    value = "+91 ${TattooDataProvider.WHATSAPP_NUMBER}",
                    subValue = "Fastest response for designs & consultations",
                    icon = Icons.Default.Chat,
                    onValueClick = onWhatsAppClick
                )

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = BorderColor, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(14.dp))

                // Address
                ContactInfoBlock(
                    label = "ADDRESS",
                    value = TattooDataProvider.STUDIO_ADDRESS,
                    subValue = null,
                    icon = Icons.Default.Place,
                    onValueClick = onDirectionsClick
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Action Buttons
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    LuxuryGoldButton(
                        text = "WHATSAPP NOW",
                        onClick = onWhatsAppClick,
                        icon = Icons.Default.Chat,
                        modifier = Modifier.fillMaxWidth(),
                        testTag = "contact_whatsapp_button"
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        LuxuryOutlineButton(
                            text = "CALL NOW",
                            onClick = onCallClick,
                            icon = Icons.Default.Call,
                            modifier = Modifier.weight(1f),
                            testTag = "contact_call_button"
                        )

                        LuxuryOutlineButton(
                            text = "GET DIRECTIONS",
                            onClick = onDirectionsClick,
                            icon = Icons.Default.Navigation,
                            modifier = Modifier.weight(1f),
                            testTag = "contact_directions_button"
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ContactInfoBlock(
    label: String,
    value: String,
    subValue: String?,
    icon: ImageVector,
    onValueClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = AntiqueGold,
            modifier = Modifier
                .padding(top = 2.dp)
                .size(18.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(
            modifier = if (onValueClick != null) Modifier.clickable { onValueClick() } else Modifier
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = AntiqueGold,
                letterSpacing = 1.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = WarmIvory,
                fontWeight = FontWeight.Medium,
                lineHeight = 22.sp
            )
            if (subValue != null) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = subValue,
                    style = MaterialTheme.typography.bodySmall,
                    color = SecondaryText
                )
            }
        }
    }
}
