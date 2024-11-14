package com.aecg.oyunvemuzikae.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.domain.MenuType
import com.aecg.oyunvemuzikae.app.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentMenuBinding
import com.aecg.oyunvemuzikae.domain.GameType
import com.aecg.oyunvemuzikae.ui.adapter.MenuAdapter
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.scrollInDirection

class MenuFragment : BaseFragment<FragmentMenuBinding>(FragmentMenuBinding::inflate) {

    private lateinit var animationZoom: Animation
    private lateinit var menuList: ArrayList<MenuModel>

    private val myApplication: MyApplication by lazy {
        requireActivity().application as MyApplication
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationZoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)

        menuList = MenuFragmentArgs.fromBundle(requireArguments()).menuList.toList() as ArrayList<MenuModel>
        val category = menuList[1].type
        setupRecyclerView(menuList)
        if (category== MenuType.MEMORYLEVEL){
         binding.rvMenu.background = null
        }
        binding.textViewMenuHeader.text = category.displayName

        val backgroundResourceMap = mapOf(
            MenuType.SES to R.drawable.bg_menu_ses,
            MenuType.OYUN to R.drawable.bg_menu_oyun,
            MenuType.MEMORYLEVEL to R.drawable.bg_oyun_menu_hafiza,
        )
        val backgroundResource = backgroundResourceMap[category] ?: R.drawable.bg_doga

        binding.layoutMenu.loadLayoutBackgroundWithGlide(requireContext(), backgroundResource)

        binding.btnScrollLeftMenu.setOnClickListener {
            binding.rvMenu.scrollInDirection(-1)
        }

        binding.BtnScrollRightMenu.setOnClickListener {
            binding.rvMenu.scrollInDirection(1)
        }
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
                    GameType.HIZLIYAVAS.displayName -> MenuFragmentDirections.menuFragmentToOyunHizliYavasFragment(myApplication.oyunHizliYavasList.toTypedArray())
                    GameType.RESIMDENBUL.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(myApplication.oyunResimdenBulList.toTypedArray(),
                        GameType.RESIMDENBUL
                    )
                    GameType.SESTENBUL.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(myApplication.enstrumanList.toTypedArray(),
                        GameType.SESTENBUL
                    )
                    GameType.ENSTRUMANTIPI.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(myApplication.enstrumanList.toTypedArray(),
                        GameType.ENSTRUMANTIPI
                    )
                    GameType.HAFIZA.displayName -> MenuFragmentDirections.menuFragmentToSelf(myApplication.oyunMemoryMenuList.toTypedArray())
                    else -> null // Geçersiz bir isim durumunda
                }
                action?.let { findNavController().navigate(it) }
            }else if(type == MenuType.MEMORYLEVEL){
                val action = when (name) {
                    "Seviye 1" -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(myApplication.enstrumanList.toTypedArray(),1,1)
                    "Seviye 2" -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(myApplication.enstrumanList.toTypedArray(),2,6)
                    "Seviye 3" -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(myApplication.enstrumanList.toTypedArray(),3,11)
                    "Seviye 4" -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(myApplication.enstrumanList.toTypedArray(),4,16)
                    "Seviye 5" -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(myApplication.enstrumanList.toTypedArray(),5,21)
                    else -> null // Geçersiz bir isim durumunda
                }
                action?.let { findNavController().navigate(it) }
            }


        }) { view ->
            // Animasyonu başlat
            view.startAnimation(animationZoom)
        }
    }
}