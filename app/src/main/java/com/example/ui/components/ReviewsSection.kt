package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.TattooDataProvider
import com.example.model.Testimonial
import com.example.ui.theme.AntiqueGold
import com.example.ui.theme.BorderColor
import com.example.ui.theme.CardBackground
import com.example.ui.theme.DeepCharcoal
import com.example.ui.theme.SecondaryCharcoal
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.WarmIvory
import kotlinx.coroutines.launch

@Composable
fun ReviewsSection(
    onReviewOnGoogleClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    val testimonials = TattooDataProvider.testimonials
    val pagerState = rememberPagerState(pageCount = { testimonials.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        SectionHeader(
            tag = "Client Words",
            title = "CLIENT REVIEWS",
            subtitle = "Genuine words from clients who entrusted their ideas and stories to our needles."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Testimonial Carousel
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .testTag("reviews_carousel")
        ) { page ->
            val review = testimonials[page]
            TestimonialCard(
                testimonial = review,
                pageNumber = page + 1,
                totalPages = testimonials.size
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Pager Navigation & Dots
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    if (pagerState.currentPage > 0) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                },
                enabled = pagerState.currentPage > 0,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Previous Review",
                    tint = if (pagerState.currentPage > 0) AntiqueGold else SecondaryText.copy(alpha = 0.4f)
                )
            }

            // Indicator Dots / Page Counter
            Text(
                text = "${pagerState.currentPage + 1} of ${testimonials.size}",
                style = MaterialTheme.typography.labelSmall,
                color = AntiqueGold,
                letterSpacing = 1.sp
            )

            IconButton(
                onClick = {
                    if (pagerState.currentPage < testimonials.size - 1) {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                },
                enabled = pagerState.currentPage < testimonials.size - 1,
                modifier = Modifier.size(36.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Next Review",
                    tint = if (pagerState.currentPage < testimonials.size - 1) AntiqueGold else SecondaryText.copy(alpha = 0.4f)
                )
            }
        }

        if (onReviewOnGoogleClick != null) {
            Spacer(modifier = Modifier.height(14.dp))
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Surface(
                    onClick = onReviewOnGoogleClick,
                    shape = RoundedCornerShape(20.dp),
                    color = SecondaryCharcoal,
                    border = androidx.compose.foundation.BorderStroke(1.dp, AntiqueGold.copy(alpha = 0.75f)),
                    modifier = Modifier
                        .height(36.dp)
                        .testTag("reviews_section_google_review_button")
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "⭐ REVIEW US ON GOOGLE",
                            style = MaterialTheme.typography.labelSmall,
                            color = AntiqueGold,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            letterSpacing = 0.8.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TestimonialCard(
    testimonial: Testimonial,
    pageNumber: Int,
    totalPages: Int
) {
    LuxuryCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Client Avatar Initial
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Surface(
                        color = SecondaryCharcoal,
                        shape = CircleShape,
                        border = androidx.compose.foundation.BorderStroke(1.dp, AntiqueGold),
                        modifier = Modifier.size(42.dp)
                    ) {
                        Box(contentAlignment = Alignment.Center) {
                            Text(
                                text = testimonial.initial,
                                style = MaterialTheme.typography.titleMedium,
                                fontFamily = FontFamily.Serif,
                                color = AntiqueGold,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = testimonial.name,
                            style = MaterialTheme.typography.titleMedium,
                            fontFamily = FontFamily.Serif,
                            color = WarmIvory,
                            fontWeight = FontWeight.SemiBold
                        )
                        Row(modifier = Modifier.padding(top = 2.dp)) {
                            repeat(testimonial.rating) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = null,
                                    tint = AntiqueGold,
                                    modifier = Modifier.size(13.dp)
                                )
                            }
                        }
                    }
                }

                Icon(
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = null,
                    tint = AntiqueGold.copy(alpha = 0.4f),
                    modifier = Modifier.size(28.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = testimonial.comment,
                style = MaterialTheme.typography.bodyLarge,
                color = WarmIvory,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Normal
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Client Testimonial #${testimonial.id}",
                style = MaterialTheme.typography.labelSmall,
                color = SecondaryText,
                fontSize = 10.sp
            )
        }
    }
}
