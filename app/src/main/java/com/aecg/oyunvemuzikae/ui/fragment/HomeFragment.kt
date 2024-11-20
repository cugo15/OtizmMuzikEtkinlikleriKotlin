package com.aecg.oyunvemuzikae.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentHomeBinding
import com.aecg.oyunvemuzikae.ui.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }
    private fun setupClickListeners() {
        binding.btnHomePiyano.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToPianoFragment())
        }

        binding.btnHomeSesler.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToMenuFragment(homeViewModel.sesMenuList))
        }

        binding.btnHomeOyunlar.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToMenuFragment(homeViewModel.oyunMenuList))
        }

        binding.btnHomeMuzikler.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.homeFragmentToMuzikFragment(homeViewModel.muzikMenuList))
        }

    }

}