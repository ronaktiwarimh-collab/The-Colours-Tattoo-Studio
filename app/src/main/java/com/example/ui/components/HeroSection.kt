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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.model.TattooDataProvider
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun HeroSection(
    onWhatsAppClick: () -> Unit,
    onCallClick: () -> Unit,
    onViewWorkClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        // Hero Background Image with Atmospheric Gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(490.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_hero_tattoo),
                contentDescription = "The Colours Tattoo Studio Workstation",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(490.dp),
                contentScale = ContentScale.Crop
            )

            // Multi-stop cinematic dark gradient overlay
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(490.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                DeepCharcoal.copy(alpha = 0.55f),
                                DeepCharcoal.copy(alpha = 0.85f),
                                DeepCharcoal
                            )
                        )
                    )
            )
        }

        // Hero Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Studio Crest / Mini Emblem
            Surface(
                color = CardBackground.copy(alpha = 0.9f),
                shape = RoundedCornerShape(20.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, AntiqueGold.copy(alpha = 0.7f)),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(7.dp)
                            .clip(CircleShape)
                            .background(AntiqueGold)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "9+ YEARS OF PROFESSIONAL TATTOOING",
                        style = MaterialTheme.typography.labelSmall,
                        color = AntiqueGold,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.2.sp
                    )
                }
            }

            // Headline
            Text(
                text = "“Where Your Story\nBecomes Art.”",
                style = MaterialTheme.typography.displayMedium,
                fontFamily = FontFamily.Serif,
                color = WarmIvory,
                textAlign = TextAlign.Center,
                lineHeight = 38.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Secondary Tagline
            Text(
                text = "“Your Idea. Your Story. Your Tattoo.”",
                style = MaterialTheme.typography.titleSmall,
                color = AntiqueGold,
                fontFamily = FontFamily.Serif,
                letterSpacing = 1.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Supporting Text
            Text(
                text = "Premium custom tattooing in Nashik, crafted with precision, creativity and personal meaning.",
                style = MaterialTheme.typography.bodyMedium,
                color = SecondaryText,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .padding(bottom = 18.dp)
            )

            // Founder & Artist Credential Card
            Surface(
                color = SecondaryCharcoal.copy(alpha = 0.85f),
                shape = RoundedCornerShape(4.dp),
                border = androidx.compose.foundation.BorderStroke(0.8.dp, BorderColor),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 22.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "FOUNDER & TATTOO ARTIST",
                            style = MaterialTheme.typography.labelSmall,
                            color = SecondaryText,
                            fontSize = 10.sp,
                            letterSpacing = 1.5.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "SHEKHAR NAYAK",
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = FontFamily.Serif,
                            color = WarmIvory,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 1.sp
                        )
                    }
                }
            }

            // CTAs
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                // Primary WhatsApp CTA
                Button(
                    onClick = onWhatsAppClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AntiqueGold,
                        contentColor = DeepCharcoal
                    ),
                    shape = RoundedCornerShape(2.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("hero_whatsapp_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Chat,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = DeepCharcoal
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "WHATSAPP NOW",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.2.sp
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    // Call Now
                    OutlinedButton(
                        onClick = onCallClick,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = WarmIvory),
                        border = androidx.compose.foundation.BorderStroke(1.dp, BorderColor),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("hero_call_button")
                    ) {
                        Icon(
                            imageVector = Icons.Default.Call,
                            contentDescription = null,
                            tint = AntiqueGold,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = "CALL NOW",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.8.sp
                        )
                    }

                    // View Our Work
                    OutlinedButton(
                        onClick = onViewWorkClick,
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = WarmIvory),
                        border = androidx.compose.foundation.BorderStroke(1.dp, AntiqueGold.copy(alpha = 0.8f)),
                        shape = RoundedCornerShape(2.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                            .testTag("hero_view_work_button")
                    ) {
                        Text(
                            text = "VIEW OUR WORK",
                            fontSize = 11.sp,
                            color = WarmIvory,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.8.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            tint = AntiqueGold,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }
            }
        }
    }
}
