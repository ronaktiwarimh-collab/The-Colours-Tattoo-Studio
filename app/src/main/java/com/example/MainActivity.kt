package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import com.example.model.GalleryItem
import com.example.model.TattooDataProvider
import com.example.model.TattooStyle
import com.example.ui.components.AboutSection
import com.example.ui.components.AcademySection
import com.example.ui.components.AftercareSection
import com.example.ui.components.ArtistSection
import com.example.ui.components.BottomActionBar
import com.example.ui.components.CallDialog
import com.example.ui.components.ConceptsSection
import com.example.ui.components.ContactSection
import com.example.ui.components.FaqSection
import com.example.ui.components.FooterSection
import com.example.ui.components.GallerySection
import com.example.ui.components.GoogleReviewSection
import com.example.ui.components.HeroSection
import com.example.ui.components.HygieneSection
import com.example.ui.components.InstagramSection
import com.example.ui.components.LightboxDialog
import com.example.ui.components.NavSection
import com.example.ui.components.NavigationDrawerContent
import com.example.ui.components.ProcessSection
import com.example.ui.components.ReviewsSection
import com.example.ui.components.SpecialitiesSection
import com.example.ui.components.StickyHeader
import com.example.ui.components.StylesSection
import com.example.ui.components.WhyChooseSection
import com.example.ui.theme.ColoursTattooTheme
import com.example.ui.theme.DeepCharcoal
import com.example.util.IntentHelper
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ColoursTattooTheme {
                MainAppScreen()
            }
        }
    }
}

@Composable
fun MainAppScreen() {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    var currentActiveSection by remember { mutableStateOf(NavSection.HOME) }
    var lightboxItem by remember { mutableStateOf<GalleryItem?>(null) }
    var lightboxIndex by remember { mutableIntStateOf(0) }
    var showCallDialog by remember { mutableStateOf(false) }

    // Section scroll index mapping
    fun scrollToSection(section: NavSection) {
        currentActiveSection = section
        coroutineScope.launch {
            drawerState.close()
            val targetIndex = when (section) {
                NavSection.HOME -> 0
                NavSection.ABOUT -> 1
                NavSection.ARTIST -> 2
                NavSection.SPECIALITIES -> 3
                NavSection.STYLES -> 4
                NavSection.GALLERY -> 5
                NavSection.ACADEMY -> 7
                NavSection.PROCESS -> 8
                NavSection.REVIEWS -> 12
                NavSection.FAQ -> 15
                NavSection.CONTACT -> 16
            }
            listState.animateScrollToItem(targetIndex)
        }
    }

    // Handle back button when drawer or dialogs are open
    BackHandler(enabled = drawerState.isOpen || lightboxItem != null || showCallDialog) {
        if (drawerState.isOpen) {
            coroutineScope.launch { drawerState.close() }
        } else if (lightboxItem != null) {
            lightboxItem = null
        } else if (showCallDialog) {
            showCallDialog = false
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            NavigationDrawerContent(
                currentSection = currentActiveSection,
                onNavigate = { section -> scrollToSection(section) },
                onClose = { coroutineScope.launch { drawerState.close() } },
                onCallClick = { showCallDialog = true },
                onWhatsAppClick = { IntentHelper.openWhatsApp(context) },
                onDirectionsClick = { IntentHelper.openGoogleMaps(context) }
            )
        }
    ) {
        Scaffold(
            topBar = {
                StickyHeader(
                    onMenuClick = { coroutineScope.launch { drawerState.open() } },
                    onEnquireClick = {
                        IntentHelper.openWhatsApp(
                            context,
                            "Hello Shekhar Nayak, I would like to enquire about getting a tattoo at The Colours Tattoo Studio."
                        )
                    },
                    onLogoClick = { scrollToSection(NavSection.HOME) },
                    modifier = Modifier.statusBarsPadding()
                )
            },
            bottomBar = {
                BottomActionBar(
                    onWhatsAppClick = {
                        IntentHelper.openWhatsApp(
                            context,
                            "Hello Shekhar Nayak, I would like to consult about a tattoo design."
                        )
                    },
                    onCallClick = { showCallDialog = true },
                    modifier = Modifier.navigationBarsPadding()
                )
            },
            containerColor = DeepCharcoal,
            modifier = Modifier
                .fillMaxSize()
                .testTag("main_scaffold")
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(DeepCharcoal)
            ) {
                LazyColumn(
                    state = listState,
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag("main_lazy_column")
                ) {
                    // Index 0: Hero
                    item {
                        HeroSection(
                            onWhatsAppClick = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I saw your work at The Colours Tattoo Studio and would like to discuss my tattoo idea."
                                )
                            },
                            onCallClick = { showCallDialog = true },
                            onViewWorkClick = { scrollToSection(NavSection.GALLERY) }
                        )
                    }

                    // Index 1: About
                    item {
                        AboutSection(
                            onEnquireClick = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I would like to enquire about custom tattoo design options."
                                )
                            }
                        )
                    }

                    // Index 2: Artist Profile
                    item {
                        ArtistSection(
                            onWhatsAppClick = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I would like to book a consultation session for a tattoo."
                                )
                            }
                        )
                    }

                    // Index 3: Specialities
                    item {
                        SpecialitiesSection(
                            onEnquireSpeciality = { specialityTitle ->
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I would like to enquire specifically about $specialityTitle at The Colours Tattoo Studio."
                                )
                            }
                        )
                    }

                    // Index 4: Styles
                    item {
                        StylesSection(
                            onStyleClick = { style ->
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I am interested in a ${style.name} tattoo. Could we discuss size and placement?"
                                )
                            }
                        )
                    }

                    // Index 5: Main Gallery (8 slots)
                    item {
                        GallerySection(
                            onItemClick = { item, index ->
                                lightboxItem = item
                                lightboxIndex = index
                            }
                        )
                    }

                    // Index 6: Tattoo Concepts
                    item {
                        ConceptsSection(
                            onCreateCustomTattoo = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I have a custom tattoo concept in mind and would love to brainstorm the design with you."
                                )
                            }
                        )
                    }

                    // Index 7: Academy
                    item {
                        AcademySection(
                            onEnquireAcademy = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I would like to enquire about The Colours Tattoo Academy details and upcoming schedules."
                                )
                            }
                        )
                    }

                    // Index 8: Process (5 steps)
                    item {
                        ProcessSection(
                            onStartJourneyClick = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I am ready to start my tattoo journey. Here is my idea and preferred placement:"
                                )
                            }
                        )
                    }

                    // Index 9: Hygiene
                    item {
                        HygieneSection()
                    }

                    // Index 10: Aftercare
                    item {
                        AftercareSection(
                            onAftercareWhatsAppClick = {
                                IntentHelper.openWhatsApp(
                                    context,
                                    "Hello Shekhar Nayak, I have a question regarding my tattoo healing and aftercare."
                                )
                            }
                        )
                    }

                    // Index 11: Why Choose Us
                    item {
                        WhyChooseSection()
                    }

                    // Index 12: Client Reviews (15 authentic reviews)
                    item {
                        ReviewsSection(
                            onReviewOnGoogleClick = { IntentHelper.openGoogleMaps(context) }
                        )
                    }

                    // Index 13: Google Review CTA
                    item {
                        GoogleReviewSection(
                            onGiveReviewClick = { IntentHelper.openGoogleMaps(context) }
                        )
                    }

                    // Index 14: Instagram
                    item {
                        InstagramSection(
                            onFollowInstagramClick = { IntentHelper.openInstagram(context) }
                        )
                    }

                    // Index 15: FAQ Accordion
                    item {
                        FaqSection()
                    }

                    // Index 16: Contact Section
                    item {
                        ContactSection(
                            onCallClick = { IntentHelper.callPhone(context, TattooDataProvider.PHONE_PRIMARY) },
                            onCallSecondaryClick = { IntentHelper.callPhone(context, TattooDataProvider.PHONE_SECONDARY) },
                            onWhatsAppClick = { IntentHelper.openWhatsApp(context) },
                            onDirectionsClick = { IntentHelper.openGoogleMaps(context) }
                        )
                    }

                    // Index 17: Footer
                    item {
                        FooterSection(
                            onNavigate = { section -> scrollToSection(section) }
                        )
                    }
                }
            }
        }
    }

    // Lightbox Dialog
    lightboxItem?.let { item ->
        val slots = TattooDataProvider.gallerySlots
        LightboxDialog(
            item = item,
            currentIndex = lightboxIndex,
            totalCount = slots.size,
            onDismiss = { lightboxItem = null },
            onPrevious = {
                val newIndex = if (lightboxIndex > 0) lightboxIndex - 1 else slots.lastIndex
                lightboxIndex = newIndex
                lightboxItem = slots[newIndex]
            },
            onNext = {
                val newIndex = if (lightboxIndex < slots.lastIndex) lightboxIndex + 1 else 0
                lightboxIndex = newIndex
                lightboxItem = slots[newIndex]
            },
            onEnquireStyle = { styleName ->
                lightboxItem = null
                IntentHelper.openWhatsApp(
                    context,
                    "Hello Shekhar Nayak, I saw this design in your studio gallery ($styleName) and would like to enquire about getting something similar."
                )
            }
        )
    }

    // Call Picker Dialog
    if (showCallDialog) {
        CallDialog(
            onDismiss = { showCallDialog = false },
            onCallPrimary = { IntentHelper.callPhone(context, TattooDataProvider.PHONE_PRIMARY) },
            onCallSecondary = { IntentHelper.callPhone(context, TattooDataProvider.PHONE_SECONDARY) }
        )
    }
}
