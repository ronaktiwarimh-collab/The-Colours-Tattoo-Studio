package com.example.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.example.model.TattooDataProvider
import java.net.URLEncoder

object IntentHelper {

    fun openWhatsApp(context: Context, customMessage: String? = null) {
        try {
            val message = customMessage ?: "Hello Shekhar Nayak, I would like to enquire about getting a tattoo at The Colours Tattoo Studio."
            val encodedMessage = URLEncoder.encode(message, "UTF-8")
            val url = "https://wa.me/${TattooDataProvider.WHATSAPP_COUNTRY_CODE}${TattooDataProvider.WHATSAPP_NUMBER}?text=$encodedMessage"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to open WhatsApp: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    fun callPhone(context: Context, phoneNumber: String = TattooDataProvider.PHONE_PRIMARY) {
        try {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber")).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to initiate call: ${e.localizedMessage}", Toast.LENGTH_SHORT).show()
        }
    }

    fun openGoogleMaps(context: Context) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TattooDataProvider.MAPS_URL)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to open Google Maps", Toast.LENGTH_SHORT).show()
        }
    }

    fun openInstagram(context: Context) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(TattooDataProvider.INSTAGRAM_URL)).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }
            context.startActivity(intent)
        } catch (e: Exception) {
            Toast.makeText(context, "Unable to open Instagram", Toast.LENGTH_SHORT).show()
        }
    }
}
