package com.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.TattooDataProvider
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory

@Composable
fun SpecialitiesSection(
    onEnquireSpeciality: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "Studio Focus",
            title = "Our Specialities",
            subtitle = "Mastery in demanding tattoo disciplines requiring exceptional precision, design ingenuity, and technical execution."
        )

        Spacer(modifier = Modifier.height(16.dp))

        TattooDataProvider.specialities.forEachIndexed { index, spec ->
            LuxuryCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Column {
                    if (spec.imageRes != null) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp)
                        ) {
                            Image(
                                painter = painterResource(id = spec.imageRes),
                                contentDescription = spec.title,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(160.dp),
                                contentScale = ContentScale.Crop
                            )
                            // AI concept badge
                            AiConceptBadge(
                                modifier = Modifier
                                    .align(Alignment.BottomEnd)
                                    .padding(8.dp)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(bottom = 6.dp)
                        ) {
                            Text(
                                text = "0${index + 1} — ${spec.highlight.uppercase()}",
                                style = MaterialTheme.typography.labelSmall,
                                color = AntiqueGold,
                                letterSpacing = 1.sp
                            )
                        }

                        Text(
                            text = spec.title,
                            style = MaterialTheme.typography.titleLarge,
                            fontFamily = FontFamily.Serif,
                            color = WarmIvory,
                            fontWeight = FontWeight.Medium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = spec.description,
                            style = MaterialTheme.typography.bodyMedium,
                            color = SecondaryText,
                            lineHeight = 22.sp
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        LuxuryOutlineButton(
                            text = "ENQUIRE ABOUT ${spec.title}",
                            onClick = { onEnquireSpeciality(spec.title) },
                            modifier = Modifier.fillMaxWidth(),
                            testTag = "speciality_enquire_${index + 1}"
                        )
                    }
                }
            }
        }
    }
}
