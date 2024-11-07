package com.aecg.oyunvemuzikae.ui

import android.os.Bundle
import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.BaseFragment
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myApplication = requireActivity().application as MyApplication

        binding.btnHomePiyano.setOnClickListener {
            navigateToFragment(HomeFragmentDirections.homeFragmentToPianoFragment())
        }
        binding.btnHomeSesler.setOnClickListener {
            navigateToFragment(HomeFragmentDirections.homeFragmentToMenuFragment(myApplication.sesMenuList.toTypedArray()))
        }
        binding.btnHomeOyunlar.setOnClickListener {
            navigateToFragment(HomeFragmentDirections.homeFragmentToMenuFragment(myApplication.oyunMenuList.toTypedArray()))
        }
        binding.btnHomeMuzikler.setOnClickListener {
            navigateToFragment(HomeFragmentDirections.homeFragmentToMuzikFragment(myApplication.muzikMenuList.toTypedArray()))
        }
    }
    private fun navigateToFragment(action: NavDirections) {
        findNavController().navigate(action)
    }

}