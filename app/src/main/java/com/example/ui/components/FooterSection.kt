package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
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
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun FooterSection(
    onNavigate: (NavSection) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = SecondaryCharcoal,
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderColor),
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Studio Crest / Logo
            Image(
                painter = painterResource(id = R.drawable.img_app_icon),
                contentDescription = "The Colours Tattoo Studio Logo",
                modifier = Modifier
                    .size(54.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, AntiqueGold, CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "THE COLOURS",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.Serif,
                color = WarmIvory,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp
            )

            Text(
                text = "TATTOO STUDIO — NASHIK",
                style = MaterialTheme.typography.labelSmall,
                color = AntiqueGold,
                letterSpacing = 2.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "“Where Your Story Becomes Art.”",
                style = MaterialTheme.typography.bodyMedium,
                fontFamily = FontFamily.Serif,
                color = WarmIvory.copy(alpha = 0.9f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(16.dp))
            HorizontalDivider(color = BorderColor, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(16.dp))

            // Quick Links
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "HOME",
                    style = MaterialTheme.typography.labelSmall,
                    color = SecondaryText,
                    modifier = Modifier.clickable { onNavigate(NavSection.HOME) }
                )
                Text(
                    text = "ARTIST",
                    style = MaterialTheme.typography.labelSmall,
                    color = SecondaryText,
                    modifier = Modifier.clickable { onNavigate(NavSection.ARTIST) }
                )
                Text(
                    text = "GALLERY",
                    style = MaterialTheme.typography.labelSmall,
                    color = SecondaryText,
                    modifier = Modifier.clickable { onNavigate(NavSection.GALLERY) }
                )
                Text(
                    text = "PROCESS",
                    style = MaterialTheme.typography.labelSmall,
                    color = SecondaryText,
                    modifier = Modifier.clickable { onNavigate(NavSection.PROCESS) }
                )
                Text(
                    text = "CONTACT",
                    style = MaterialTheme.typography.labelSmall,
                    color = SecondaryText,
                    modifier = Modifier.clickable { onNavigate(NavSection.CONTACT) }
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

            // Local SEO tags as specified in brief
            Text(
                text = "Tattoo Studio in Nashik • Tattoo Artist in Nashik Road • Custom Tattoos • Cover-Up • Realism • Fine Line",
                style = MaterialTheme.typography.bodySmall,
                color = SecondaryText.copy(alpha = 0.6f),
                fontSize = 10.sp,
                textAlign = TextAlign.Center,
                lineHeight = 16.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "© The Colours Tattoo Studio. Shekhar Nayak. All rights reserved.",
                style = MaterialTheme.typography.bodySmall,
                color = SecondaryText.copy(alpha = 0.5f),
                fontSize = 10.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(60.dp)) // Extra space for fixed bottom action bar
        }
    }
}
