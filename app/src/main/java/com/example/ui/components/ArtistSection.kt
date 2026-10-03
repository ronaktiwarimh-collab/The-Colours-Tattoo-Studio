package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun ArtistSection(
    onWhatsAppClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "Lead Artist",
            title = "Meet The Artist",
            subtitle = "Craft, patience, and visual storytelling shaped across nine years of dedicated tattooing."
        )

        Spacer(modifier = Modifier.height(14.dp))

        LuxuryCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Artist Photograph Container with strict placeholder label as required
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(SecondaryCharcoal)
                        .border(1.dp, BorderColor, RoundedCornerShape(4.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    // Atmospheric subtle background
                    Image(
                        painter = painterResource(id = R.drawable.img_hero_tattoo),
                        contentDescription = "Studio craft atmosphere",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(240.dp),
                        contentScale = ContentScale.Crop,
                        alpha = 0.35f
                    )

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Surface(
                            color = CardBackground.copy(alpha = 0.95f),
                            shape = CircleShape,
                            border = androidx.compose.foundation.BorderStroke(1.5.dp, AntiqueGold),
                            modifier = Modifier.size(72.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = Icons.Default.Person,
                                    contentDescription = null,
                                    tint = AntiqueGold,
                                    modifier = Modifier.size(36.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(12.dp))

                        // Required label: “ARTIST PHOTOGRAPH COMING SOON”
                        ComingSoonBadge(
                            text = "ARTIST PHOTOGRAPH COMING SOON"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "SHEKHAR NAYAK",
                    style = MaterialTheme.typography.headlineLarge,
                    fontFamily = FontFamily.Serif,
                    color = WarmIvory,
                    letterSpacing = 1.sp
                )

                Text(
                    text = "FOUNDER & TATTOO ARTIST",
                    style = MaterialTheme.typography.labelMedium,
                    color = AntiqueGold,
                    letterSpacing = 1.5.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 4.dp)
                )

                Text(
                    text = "9+ YEARS OF PROFESSIONAL TATTOOING",
                    style = MaterialTheme.typography.bodySmall,
                    color = SecondaryText,
                    letterSpacing = 1.sp,
                    modifier = Modifier.padding(top = 2.dp, bottom = 16.dp)
                )

                // 5 Core Highlights specified in prompt
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ArtistPillarRow("Artistic Vision", "Translating subtle emotions and abstract concepts into balanced visual tattoo art.")
                    ArtistPillarRow("Creativity", "Developing bespoke, original designs rather than copying standardized templates.")
                    ArtistPillarRow("Attention to Detail", "Meticulous line weight control, micro-depth accuracy, and soft gradient washes.")
                    ArtistPillarRow("Custom Design Approach", "Collaborating closely with each client to align sizing, flow, and anatomy.")
                    ArtistPillarRow("Professionalism", "Uncompromising hygiene discipline, punctuality, client comfort, and transparent communication.")
                }

                Spacer(modifier = Modifier.height(20.dp))

                LuxuryGoldButton(
                    text = "WHATSAPP NOW",
                    onClick = onWhatsAppClick,
                    icon = Icons.Default.Chat,
                    modifier = Modifier.fillMaxWidth(),
                    testTag = "artist_whatsapp_button"
                )
            }
        }
    }
}

@Composable
private fun ArtistPillarRow(
    title: String,
    description: String
) {
    Surface(
        color = SecondaryCharcoal.copy(alpha = 0.6f),
        shape = RoundedCornerShape(4.dp),
        border = androidx.compose.foundation.BorderStroke(0.5.dp, BorderColor),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                color = AntiqueGold,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodySmall,
                color = WarmIvory.copy(alpha = 0.85f),
                lineHeight = 17.sp
            )
        }
    }
}
