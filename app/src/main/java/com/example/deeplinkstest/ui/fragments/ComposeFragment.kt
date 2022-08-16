package com.example.deeplinkstest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.deeplinkstest.databinding.ComposeFragmentBinding
import com.example.deeplinkstest.ui.screens.ComposeScreen
import com.example.deeplinkstest.ui.screens.DEEP_LINK_DEST
import com.example.deeplinkstest.ui.theme.DeepLinksTestTheme

class ComposeFragment: Fragment() {

  private var _binding: ComposeFragmentBinding? = null
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    _binding = ComposeFragmentBinding.inflate(inflater, container, false)
    val view = binding.root
    binding.composeView.apply {
      // Dispose of the Composition when the view's LifecycleOwner
      // is destroyed
      setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
      setContent {
        // In Compose world
        DeepLinksTestTheme {
          // A surface container using the 'background' color from the theme
          Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
          ) {
            Column(
              modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
              verticalArrangement = Arrangement.Center,
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ComposeScreen(arguments?.getString(DEEP_LINK_DEST) ?: "")
            }
          }
        }
      }
    }
    return view
  }
}