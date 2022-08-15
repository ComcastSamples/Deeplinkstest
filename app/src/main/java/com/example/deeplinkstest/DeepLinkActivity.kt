package com.example.deeplinkstest

import android.content.ContentValues
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDeepLinkBuilder
import com.example.deeplinkstest.ui.screens.DEEP_LINK_DEST
import com.example.deeplinkstest.ui.screens.SCREEN1
import com.example.deeplinkstest.ui.screens.SCREEN2
import com.google.firebase.dynamiclinks.PendingDynamicLinkData
import com.google.firebase.dynamiclinks.ktx.dynamicLinks
import com.google.firebase.ktx.Firebase

class DeepLinkActivity: AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val uri = intent.data
      ?.buildUpon()
      ?.appendQueryParameter("referrer-host", referrer?.host)
      ?.build()

    val navDeepLinkBuilder = NavDeepLinkBuilder(applicationContext)
      .setGraph(R.navigation.traditional_view_nav)
      .setComponentName(MainActivity::class.java)

    uri?.path?.let { path ->

      println("path: $path")

      when {

        path.equals("/activity1", ignoreCase = true) -> {
          navDeepLinkBuilder.setDestination(R.id.activity1)
        }

        path.equals("/fragment1", ignoreCase = true) -> {
          navDeepLinkBuilder.setDestination(R.id.fragment1)
        }

        path.equals("/fragment2", ignoreCase = true) -> {
          navDeepLinkBuilder
            .addDestination(R.id.fragment1)
            .addDestination(R.id.fragment2)
        }

        path.equals("/composeFragment", ignoreCase = true) -> {
          navDeepLinkBuilder.setDestination(R.id.composeFragment)
        }

        path.equals("/composeFragment/Screen1", ignoreCase = true) -> {
          navDeepLinkBuilder
            .setDestination(R.id.composeFragment)
            .setArguments(
              Bundle().apply {
                putString(DEEP_LINK_DEST, SCREEN1)
              }
            )
        }

        path.equals("/composeFragment/Screen2", ignoreCase = true) -> {
          navDeepLinkBuilder
            .setDestination(R.id.composeFragment)
            .setArguments(
              Bundle().apply {
                putString(DEEP_LINK_DEST, SCREEN2)
              }
            )
        }

        else -> {
          navDeepLinkBuilder
          .setDestination(R.id.homeFragment)
        }
      }
    }

    navDeepLinkBuilder
      .createTaskStackBuilder()
      .startActivities()
  }

  private fun playWithFirebase() {
    Firebase.dynamicLinks
      .getDynamicLink(intent)
      .addOnSuccessListener(this) { pendingDynamicLinkData: PendingDynamicLinkData? ->
        // Get deep link from result (may be null if no link is found)
        var deepLink: Uri? = null
        if (pendingDynamicLinkData != null) {
          deepLink = pendingDynamicLinkData.link
        }

        // Handle the deep link. For example, open the linked
        // content, or apply promotional credit to the user's
        // account.
        // ...

      }
      .addOnFailureListener(this) { e -> Log.w(ContentValues.TAG, "getDynamicLink:onFailure", e) }
  }
}