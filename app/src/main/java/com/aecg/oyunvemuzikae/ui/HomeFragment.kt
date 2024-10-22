package com.aecg.oyunvemuzikae.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        val myApplication = requireActivity().application as MyApplication
        binding.btnHomePiyano.setOnClickListener {
            findNavController().navigate(R.id.homeFragment_to_pianoFragment)
        }
        binding.btnHomeSesler.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToMenuFragment(myApplication.sesMenuList.toTypedArray())
            findNavController().navigate(action)
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}