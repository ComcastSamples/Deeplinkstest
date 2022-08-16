package com.example.deeplinkstest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deeplinkstest.R
import com.example.deeplinkstest.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

  private var binding: HomeFragmentBinding? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = HomeFragmentBinding.inflate(
      inflater,
      container,
      false
    )

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.goToComposeScreen?.setOnClickListener {
     findNavController().navigate(R.id.action_homeFragment_to_composeFragment)
    }

    binding?.goToTraditionalViews?.setOnClickListener {
      findNavController().navigate(R.id.action_homeFragment_to_fragment1)
    }

    binding?.goToTraditionalActivities?.setOnClickListener {
      findNavController().navigate(R.id.action_homeFragment_to_activity1)
    }
  }
}