package com.example.deeplinkstest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.deeplinkstest.R
import com.example.deeplinkstest.databinding.Fragment1Binding

class Fragment1: Fragment() {

  private var binding: Fragment1Binding? = null

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = Fragment1Binding.inflate(
      inflater,
      container,
      false
    )

    return binding?.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding?.button?.setOnClickListener {
      findNavController().navigate(R.id.action_fragment1_to_fragment2)
    }
  }
}