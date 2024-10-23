package com.aecg.oyunvemuzikae.ui

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.Sesler.SesAdapter
import com.aecg.oyunvemuzikae.Sesler.SesType
import com.aecg.oyunvemuzikae.Sesler.SesModel
import com.aecg.oyunvemuzikae.databinding.FragmentSesBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.scrollInDirection

class SesFragment : Fragment() {
    private var _binding: FragmentSesBinding? = null
    private val binding get() = _binding!!

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var sesList: ArrayList<SesModel>
    private lateinit var animationzoom: Animation


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSesBinding.inflate(inflater, container, false)
        val view = binding.root

        animationzoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)

        sesList = SesFragmentArgs.fromBundle(requireArguments()).sesList.toList() as ArrayList<SesModel>
        val category = sesList[1].type
        binding.textViewSesHeader.text = category.displayName

        val backgroundResourceMap = mapOf(
            SesType.HAYVAN to R.drawable.bg_hayvanlar,
            SesType.INSAN to R.drawable.bg_insanlar,
            SesType.ENSTRUMAN to R.drawable.bg_enstrumanlar,
            SesType.DOGA to R.drawable.bg_doga,
            SesType.ARAC to R.drawable.bg_araclar,
            SesType.SAYI to R.drawable.bg_sayilar,
            SesType.SEKIL to R.drawable.bg_sekiller
        )
        val backgroundResource = backgroundResourceMap[category] ?: R.drawable.bg_doga

        binding.layoutSes.loadLayoutBackgroundWithGlide(requireContext(), backgroundResource, R.drawable.bg_doga)


        setupRecyclerView(sesList)

        binding.btnScrollLeftSes.setOnClickListener {
            binding.rvSes.scrollInDirection(-1)
        }

        binding.BtnScrollRightSes.setOnClickListener {
            binding.rvSes.scrollInDirection(1)
        }


        return view
    }

    private fun setupRecyclerView(sesList: ArrayList<SesModel>) {
        // RecyclerView'e yatay (horizontal) LinearLayoutManager ata
        binding.rvSes.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        // SesAdapter'ı RecyclerView'e ata
        binding.rvSes.adapter = SesAdapter(sesList, { id ->
            // Sesi çal
            playSoundById(id)
        }) { view ->
            // Animasyonu başlat
            view.startAnimation(animationzoom)
        }
    }

    private fun playSoundById(id: Int) {
        // Önce var olan MediaPlayer nesnesini serbest bırak
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        mediaPlayer = MediaPlayer.create(requireContext(), id)
        mediaPlayer.start()

        // Ses bitince MediaPlayer'ı serbest bırak
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.release()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        sesList.clear()
        _binding = null
    }
}