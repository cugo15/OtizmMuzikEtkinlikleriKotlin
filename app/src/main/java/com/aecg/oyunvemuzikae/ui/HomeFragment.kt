package com.aecg.oyunvemuzikae.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.BaseFragment
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myApplication = requireActivity().application as MyApplication
        binding.btnHomePiyano.setOnClickListener {
            findNavController().navigate(R.id.homeFragment_to_pianoFragment)
        }
        binding.btnHomeSesler.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToMenuFragment(myApplication.sesMenuList.toTypedArray())
            findNavController().navigate(action)
        }
        binding.btnHomeOyunlar.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToMenuFragment(myApplication.oyunMenuList.toTypedArray())
            findNavController().navigate(action)
        }
        binding.btnHomeMuzikler.setOnClickListener {
            val action = HomeFragmentDirections.homeFragmentToMuzikFragment(myApplication.muzikMenuList.toTypedArray())
            findNavController().navigate(action)
        }
    }

}