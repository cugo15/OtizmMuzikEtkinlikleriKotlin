package com.aecg.oyunvemuzikae.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.domain.MenuType
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentMenuBinding
import com.aecg.oyunvemuzikae.ui.adapter.MenuAdapter
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.ui.viewmodel.MenuViewModel
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.scrollInDirection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {
    private val menuViewModel: MenuViewModel by viewModels()
    private lateinit var animationZoom: Animation
    private lateinit var menuList: ArrayList<MenuModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationZoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)
        menuList = MenuFragmentArgs.fromBundle(requireArguments()).menuList.toList() as ArrayList<MenuModel>
        val category = menuList[0].type
        setupLayout(category)
        setupRecyclerView(menuList)
        setupScrollButtons()
    }
    private fun setupRecyclerView(menuList: ArrayList<MenuModel>) {
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvMenu.adapter = MenuAdapter(menuList, { name, type ->
            menuViewModel.handleMenuClick(name, type)?.let { action ->
                findNavController().navigate(action)
            }
        }) { view ->
            view.startAnimation(animationZoom)
        }
    }

    private fun setupLayout(category: MenuType){
        if (category== MenuType.MEMORYLEVEL){ binding.rvMenu.background = null }
        binding.textViewMenuHeader.text = category.displayName
        binding.layoutMenu.loadLayoutBackgroundWithGlide(requireContext(), category.backgroundResource)
    }
    private fun setupScrollButtons(){
        with(binding){
            btnScrollLeftMenu.setOnClickListener{rvMenu.scrollInDirection(-1)}
            BtnScrollRightMenu.setOnClickListener {rvMenu.scrollInDirection(1)}
        }
    }
}