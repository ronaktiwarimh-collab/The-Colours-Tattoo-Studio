package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.model.TattooDataProvider
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("The Colours Tattoo", appName)
  }

  @Test
  fun `verify tattoo studio data constraints`() {
    assertEquals(8, TattooDataProvider.gallerySlots.size)
    assertEquals(15, TattooDataProvider.testimonials.size)
    assertEquals(12, TattooDataProvider.styles.size)
    assertEquals(3, TattooDataProvider.specialities.size)
    assertEquals(5, TattooDataProvider.processSteps.size)
    assertEquals("7976234747", TattooDataProvider.PHONE_PRIMARY)
  }
}
