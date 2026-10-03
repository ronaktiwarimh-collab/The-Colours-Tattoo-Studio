package com.example.model

import androidx.annotation.DrawableRes
import com.example.R

data class GalleryItem(
    val id: String,
    val title: String,
    val category: String,
    @DrawableRes val imageRes: Int,
    val isAiConcept: Boolean = true,
    val description: String = ""
)

data class TattooStyle(
    val id: String,
    val name: String,
    val description: String,
    val iconName: String = ""
)

data class SpecialityItem(
    val title: String,
    val description: String,
    val highlight: String,
    @DrawableRes val imageRes: Int? = null
)

data class ProcessStep(
    val stepNumber: String,
    val title: String,
    val description: String
)

data class Testimonial(
    val id: Int,
    val name: String,
    val comment: String,
    val rating: Int = 5,
    val initial: String = name.take(1)
)

data class FaqItem(
    val question: String,
    val answer: String
)

object TattooDataProvider {
    const val PHONE_PRIMARY = "7976234747"
    const val PHONE_SECONDARY = "9860158785"
    const val WHATSAPP_NUMBER = "7976234747"
    const val WHATSAPP_COUNTRY_CODE = "91"
    const val MAPS_URL = "https://maps.app.goo.gl/jvi92n73G8gtYf1v9"
    const val INSTAGRAM_URL = "https://www.instagram.com/the_colours_tattooz?stkn=a3IzcXp6ZTY2aThn"
    const val STUDIO_ADDRESS = "Shubham Complex, Multi Dham / Near Mukti Dham Mandir, Rajwada Nagar, Bitco Point, Nashik Road, Nashik, Maharashtra 422101"

    val specialities = listOf(
        SpecialityItem(
            title = "COVER-UP TATTOOS",
            description = "Creative cover-up solutions carefully designed based on your existing tattoo's pigment, size, and your desired new vision.",
            highlight = "Precision Adaptation",
            imageRes = R.drawable.img_concept_realism
        ),
        SpecialityItem(
            title = "CUSTOMISED TATTOOS",
            description = "Unique custom artwork tailored specifically to your personality, story, and placement preference with custom sketches.",
            highlight = "100% Original Craft",
            imageRes = R.drawable.img_hero_tattoo
        ),
        SpecialityItem(
            title = "PORTRAIT TATTOOS",
            description = "Detailed portrait tattoo work with careful focus on facial anatomy, proportions, smooth tonal gradations, and realism.",
            highlight = "Master Realism",
            imageRes = R.drawable.img_concept_portrait
        )
    )

    val styles = listOf(
        TattooStyle("black_grey", "Black & Grey", "Classic tonal depth and smooth gradations using premium black ink washes."),
        TattooStyle("realism", "Realism", "Photographic accuracy, textures, and lifelike dimensions rendered on skin."),
        TattooStyle("portrait", "Portrait", "Emotion-filled depictions of loved ones, historical icons, or inspiring figures."),
        TattooStyle("minimal", "Minimal", "Clean, understated aesthetics that deliver powerful meaning with quiet subtlety."),
        TattooStyle("fine_line", "Fine Line", "Delicate micro-needlework with crisp lines, botanical motifs, and elegant curves."),
        TattooStyle("lettering", "Lettering", "Bespoke calligraphy, quotes, scripts, and meaningful typographic compositions."),
        TattooStyle("geometric", "Geometric", "Sacred geometry, mandala symmetries, and sharp mathematical precision."),
        TattooStyle("traditional", "Traditional", "Bold outlines, timeless motifs, and classic heritage tattoo craftsmanship."),
        TattooStyle("custom_designs", "Custom Designs", "One-of-a-kind artwork developed collaboratively from your unique story."),
        TattooStyle("cover_up", "Cover-Up", "Intelligent camouflage and dark shading techniques to transform old or faded ink."),
        TattooStyle("colour_tattoos", "Colour Tattoos", "Vibrant, rich saturation using premium safe pigments for striking contrast."),
        TattooStyle("abstract", "Abstract", "Modern artistic expressions, brushstrokes, and conceptual visual storytelling.")
    )

    // Exactly 8 gallery slots as strictly required
    val gallerySlots = listOf(
        GalleryItem(
            id = "slot_1",
            title = "Hyper-Realistic Lion & Timepiece",
            category = "REALISM",
            imageRes = R.drawable.img_concept_realism,
            isAiConcept = true,
            description = "Detailed black and grey realism exploring strength and the passage of time."
        ),
        GalleryItem(
            id = "slot_2",
            title = "Artistic Portrait Study",
            category = "PORTRAIT",
            imageRes = R.drawable.img_concept_portrait,
            isAiConcept = true,
            description = "Expressive portrait tattoo focusing on proportion and subtle grey wash shading."
        ),
        GalleryItem(
            id = "slot_3",
            title = "Delicate Botanical Constellation",
            category = "FINE LINE",
            imageRes = R.drawable.img_concept_fineline,
            isAiConcept = true,
            description = "Crisp, elegant single-needle linework with minimalist floral aesthetics."
        ),
        GalleryItem(
            id = "slot_4",
            title = "Studio Rotary Precision",
            category = "BLACK & GREY",
            imageRes = R.drawable.img_hero_tattoo,
            isAiConcept = true,
            description = "Precision needlecraft in action in our sterile, high-end studio workstation."
        ),
        GalleryItem(
            id = "slot_5",
            title = "Minimal Geometric Wristband",
            category = "MINIMAL",
            imageRes = R.drawable.img_concept_fineline,
            isAiConcept = true,
            description = "Clean geometric symmetry tailored to natural wrist contours."
        ),
        GalleryItem(
            id = "slot_6",
            title = "Sacred Script & Lettering Concept",
            category = "LETTERING",
            imageRes = R.drawable.img_concept_realism,
            isAiConcept = true,
            description = "Custom lettering concept with subtle shading and ornamental flourishes."
        ),
        GalleryItem(
            id = "slot_7",
            title = "Cover-Up Dark Wash Concept",
            category = "COVER-UP",
            imageRes = R.drawable.img_concept_portrait,
            isAiConcept = true,
            description = "High-contrast layering designed to seamlessly obscure underlying artwork."
        ),
        GalleryItem(
            id = "slot_8",
            title = "The Colours Emblem Concept",
            category = "OTHER",
            imageRes = R.drawable.img_app_icon,
            isAiConcept = true,
            description = "Studio brand insignia concept honoring 9+ years of tattoo mastery."
        )
    )

    val conceptHighlights = listOf(
        GalleryItem(
            id = "concept_1",
            title = "Mythological Realism Sleeve",
            category = "REALISM",
            imageRes = R.drawable.img_concept_realism,
            isAiConcept = true,
            description = "Dynamic realism with high contrast highlights and architectural perspective."
        ),
        GalleryItem(
            id = "concept_2",
            title = "Fine Line Floral Garland",
            category = "FINE LINE",
            imageRes = R.drawable.img_concept_fineline,
            isAiConcept = true,
            description = "Micro-botanicals crafted for subtle elegance and timeless grace."
        ),
        GalleryItem(
            id = "concept_3",
            title = "Realistic Tonal Portraiture",
            category = "PORTRAIT",
            imageRes = R.drawable.img_concept_portrait,
            isAiConcept = true,
            description = "Multi-layered ink washes providing photographic skin fidelity."
        )
    )

    val processSteps = listOf(
        ProcessStep(
            stepNumber = "01",
            title = "CONSULTATION",
            description = "Tell us about your tattoo idea, reference, meaning, size and preferred placement."
        ),
        ProcessStep(
            stepNumber = "02",
            title = "DESIGN",
            description = "We discuss the concept and customise the design according to your requirements."
        ),
        ProcessStep(
            stepNumber = "03",
            title = "PLACEMENT",
            description = "The size and placement are planned according to the body area and tattoo design."
        ),
        ProcessStep(
            stepNumber = "04",
            title = "TATTOO SESSION",
            description = "Once everything is finalised, the tattooing session begins in a professional studio environment."
        ),
        ProcessStep(
            stepNumber = "05",
            title = "AFTERCARE",
            description = "After completing the tattoo, you receive basic aftercare guidance for the healing process."
        )
    )

    val hygienePoints = listOf(
        "Clean and organised tattooing environment",
        "Proper preparation of the tattoo area",
        "Fresh, sterile, single-use tattoo needles for each client",
        "Appropriate disposable supplies where required",
        "Proper handling of tattoo equipment and consumables",
        "Clean workstation preparation",
        "Responsible disposal of used tattoo-related materials"
    )

    val aftercarePoints = listOf(
        "Keep the tattoo clean and follow the artist's instructions",
        "Avoid unnecessary touching or scratching",
        "Avoid picking or removing healing skin",
        "Avoid excessive soaking or swimming during healing",
        "Protect the tattoo from excessive direct sunlight while healing",
        "Follow the specific aftercare instructions provided by the artist"
    )

    val whyChoosePillars = listOf(
        SpecialityItem(
            title = "9+ YEARS OF EXPERIENCE",
            description = "Professional tattooing experience led by Shekhar Nayak.",
            highlight = "Mastery"
        ),
        SpecialityItem(
            title = "CUSTOM ARTWORK",
            description = "Tattoo concepts developed around the client's idea and preferences.",
            highlight = "Originality"
        ),
        SpecialityItem(
            title = "COVER-UP SPECIALISATION",
            description = "Creative cover-up solutions based on the existing tattoo and desired result.",
            highlight = "Transformation"
        ),
        SpecialityItem(
            title = "PORTRAIT SPECIALISATION",
            description = "Detailed portrait tattoo work with focus on proportion and artistic interpretation.",
            highlight = "Precision"
        ),
        SpecialityItem(
            title = "PERSONAL CONSULTATION",
            description = "Understand the client's idea, meaning, reference and requirements before the tattoo session.",
            highlight = "One-on-One"
        ),
        SpecialityItem(
            title = "PROFESSIONAL ENVIRONMENT",
            description = "Clean, organised and professional studio experience.",
            highlight = "Sterile & Safe"
        )
    )

    // Exactly the 15 client-provided testimonials
    val testimonials = listOf(
        Testimonial(1, "Aarav Sharma", "बहुत अच्छा tattoo studio है! 😊 Tattoo की finishing और detailing काफी अच्छी लगी। Overall experience शानदार रहा। ❤️"),
        Testimonial(2, "Priya Patel", "Artist ने मेरी requirement अच्छे से समझी और बहुत अच्छा tattoo बनाया। 🙌 Professional service और अच्छा environment."),
        Testimonial(3, "Rohan Verma", "पहली बार tattoo करवाया और experience बहुत अच्छा रहा! 😍 पूरा process comfortable और professional था."),
        Testimonial(4, "Sneha Joshi", "Custom tattoo का काम बहुत अच्छा लगा। 🎨 Design और finishing दोनों शानदार हैं!"),
        Testimonial(5, "Aditya Singh", "Studio clean और comfortable है। 😊 Artist का काम काफी detailed है. Highly satisfied!"),
        Testimonial(6, "Neha Deshmukh", "Cover-up tattoo बहुत अच्छे से किया गया। 🔥 Result मेरी expectation के according रहा."),
        Testimonial(7, "Karan Mehta", "बहुत professional work! 👌 Artist ने मेरे idea को बहुत अच्छे से tattoo में convert किया."),
        Testimonial(8, "Pooja Sharma", "Tattoo की detailing और finishing काफी अच्छी है। ❤️ Overall बहुत अच्छा experience."),
        Testimonial(9, "Rahul Patil", "Friendly staff और professional service. 😊 Tattoo का final result बहुत अच्छा आया."),
        Testimonial(10, "Ishita Shah", "Design बिल्कुल पसंद के हिसाब से बनाया गया। 🎨 Great experience!"),
        Testimonial(11, "Vivek Kulkarni", "Studio का atmosphere अच्छा है और artist का काम काफी impressive है. 🔥"),
        Testimonial(12, "Anjali Gupta", "Tattoo की quality और finishing दोनों अच्छी लगी। 🙌 बहुत अच्छा experience रहा."),
        Testimonial(13, "Akash Yadav", "Artist ने पूरे process को properly explain किया। 😊 Service से काफी satisfied हूँ."),
        Testimonial(14, "Meera Nair", "Realistic/custom tattoo के लिए अच्छा experience रहा। 🎨 Work की detailing बहुत अच्छी है."),
        Testimonial(15, "Sahil Thakur", "Overall शानदार experience! ❤️ Professional work, अच्छा behaviour और beautiful tattoo.")
    )

    val faqs = listOf(
        FaqItem(
            question = "Do I need an appointment?",
            answer = "Appointments are recommended, especially for larger or detailed tattoos. Contact the studio to discuss availability."
        ),
        FaqItem(
            question = "Can I bring my own tattoo reference?",
            answer = "Yes. You can share your reference, idea or inspiration with the artist."
        ),
        FaqItem(
            question = "Can you create a customised tattoo?",
            answer = "Yes. Customised tattoos are one of the studio's specialities."
        ),
        FaqItem(
            question = "Do you do cover-up tattoos?",
            answer = "Yes. Cover-up possibilities depend on the existing tattoo, its size, colour, placement and the desired new design."
        ),
        FaqItem(
            question = "Do you do portrait tattoos?",
            answer = "Yes. Portrait tattoos are one of the studio's specialities."
        ),
        FaqItem(
            question = "How much does a tattoo cost?",
            answer = "Pricing depends on the design, size, placement, detailing and session requirements. Final pricing can be discussed after understanding your requirements."
        ),
        FaqItem(
            question = "How long does a tattoo session take?",
            answer = "Session time depends on the size, design, placement, level of detail and individual requirements."
        ),
        FaqItem(
            question = "Do you provide aftercare instructions?",
            answer = "Yes. Basic aftercare guidance is provided after the tattoo session."
        ),
        FaqItem(
            question = "Can I discuss my tattoo idea before getting it?",
            answer = "Yes. Contact the studio through WhatsApp or phone to discuss your idea."
        ),
        FaqItem(
            question = "Do you have a tattoo academy?",
            answer = "ACADEMY DETAILS COMING SOON."
        )
    )

    val galleryFilters = listOf(
        "ALL", "BLACK & GREY", "REALISM", "PORTRAIT", "MINIMAL",
        "FINE LINE", "LETTERING", "COLOUR", "COVER-UP", "OTHER"
    )
}
