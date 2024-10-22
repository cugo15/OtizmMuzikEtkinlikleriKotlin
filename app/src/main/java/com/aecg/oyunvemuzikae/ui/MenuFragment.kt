package com.aecg.oyunvemuzikae.ui

import android.graphics.drawable.Drawable
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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition


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

        Glide.with(this)
            .load(backgroundResource)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    // Yüklenen Drawable'i arka plana set et
                    binding.layoutMenu.background = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // Yükleme iptal edildiğinde yapılacak işlemler
                }
                override fun onLoadFailed(errorDrawable: Drawable?) {
                    // Yükleme başarısız olursa varsayılan arka plan ayarla
                    binding.layoutMenu.setBackgroundResource(R.drawable.bg_doga) // varsayılan arka plan
                }
            })

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