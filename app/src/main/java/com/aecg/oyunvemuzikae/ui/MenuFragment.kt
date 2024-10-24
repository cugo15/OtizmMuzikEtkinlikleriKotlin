package com.aecg.oyunvemuzikae.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.MenuType
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentMenuBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.scrollInDirection


class MenuFragment : Fragment() {

    private var _binding: FragmentMenuBinding? = null
    private val binding get() = _binding!!
    private lateinit var animationZoom: Animation
    private lateinit var menuList: ArrayList<MenuModel>

    private val myApplication: MyApplication by lazy {
        requireActivity().application as MyApplication
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        val view = binding.root
        animationZoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)

        menuList = MenuFragmentArgs.fromBundle(requireArguments()).menuList.toList() as ArrayList<MenuModel>
        setupRecyclerView(menuList)
        val category = menuList[1].type
        binding.textViewMenuHeader.text = category.displayName

        val backgroundResourceMap = mapOf(
            MenuType.SES to R.drawable.bg_menu_ses,
            MenuType.OYUN to R.drawable.bg_menu_oyun,
        )
        val backgroundResource = backgroundResourceMap[category] ?: R.drawable.bg_doga

        binding.layoutMenu.loadLayoutBackgroundWithGlide(requireContext(), backgroundResource, R.drawable.bg_doga)

        binding.btnScrollLeftMenu.setOnClickListener {
            binding.rvMenu.scrollInDirection(-1)
        }

        binding.BtnScrollRightMenu.setOnClickListener {
            binding.rvMenu.scrollInDirection(1)
        }

        return view
    }
    private fun setupRecyclerView(menuList: ArrayList<MenuModel>) {
        // RecyclerView'e yatay (horizontal) LinearLayoutManager ata
        binding.rvMenu.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        // SesAdapter'ı RecyclerView'e ata
        binding.rvMenu.adapter = MenuAdapter(menuList, { name,type ->
            if (type == MenuType.SES) {
                val action = when (name) {
                    "Enstrüman" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.enstrumanList.toTypedArray())
                    "Doğa" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.dogaList.toTypedArray())
                    "İnsan" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.insanList.toTypedArray())
                    "Araçlar" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.aracList.toTypedArray())
                    "Hayvan" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.hayvanList.toTypedArray())
                    "Şekiller" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.sekilList.toTypedArray())
                    "Sayılar" -> MenuFragmentDirections.menuFragmentToSesFragment(myApplication.sayiList.toTypedArray())
                    else -> null // Geçersiz bir isim durumunda
                }
                action?.let { findNavController().navigate(it) }
            }else if(type == MenuType.OYUN){
                val action = when (name) {
                    "Hızlı Yavaş" -> MenuFragmentDirections.menuFragmentToOyunHizliYavasFragment(myApplication.oyunHizliYavasList.toTypedArray())
                    "Resimden Bul" -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(myApplication.enstrumanList.toTypedArray(),"Resimden Bul")
                    "Sesten Bul" -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(myApplication.enstrumanList.toTypedArray(),"Sesten Bul")
                    else -> null // Geçersiz bir isim durumunda
                }
                action?.let { findNavController().navigate(it) }
            }

        }) { view ->
            // Animasyonu başlat
            view.startAnimation(animationZoom)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}