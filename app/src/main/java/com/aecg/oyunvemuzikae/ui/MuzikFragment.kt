package com.aecg.oyunvemuzikae.ui

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.BaseFragment
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentMuzikBinding



class MuzikFragment : BaseFragment() {

    private var _binding: FragmentMuzikBinding? = null
    private val binding get() = _binding!!

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var muzikList: ArrayList<MuzikModel>
    private lateinit var animationzoom: Animation

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMuzikBinding.inflate(inflater, container, false)
        val view = binding.root
        animationzoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)

        muzikList = MuzikFragmentArgs.fromBundle(requireArguments()).muzikList.toCollection(ArrayList())
        setupRecyclerView(muzikList)


        return view
    }

    private fun setupRecyclerView(muzikList: ArrayList<MuzikModel>) {
        // RecyclerView'e yatay (horizontal) LinearLayoutManager ata
        binding.rvMuzikler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        // SesAdapter'ı RecyclerView'e ata
        binding.rvMuzikler.adapter = MuzikAdapter(muzikList, { uri,type ->
            if (type== MuzikType.MUZIK){
                playSoundByUri(uri)
            }else{
                openVideo(uri)
            }
        }) { view ->
            // Animasyonu başlat
            view.startAnimation(animationzoom)
        }
    }

    private fun playSoundByUri(uri: String) {
        // Önce mevcut MediaPlayer nesnesini serbest bırak
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        // Yeni MediaPlayer nesnesi oluştur ve URI ayarla
        mediaPlayer = MediaPlayer().apply {
            setDataSource(requireContext(), Uri.parse(uri))
            prepare() // Asenkron yükleme gerekiyorsa prepareAsync() kullanabilirsiniz
            start()
        }
        // Ses tamamlandığında MediaPlayer'ı serbest bırak
        mediaPlayer.setOnCompletionListener {
            it.release()
        }
    }
    private fun openVideo(videoId: String) {
        val action = MuzikFragmentDirections.actionMuzikFragmentToWebViewDialogFragment(videoId)
        findNavController().navigate(action)
    }



    override fun onDestroyView() {
        super.onDestroyView()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        muzikList.clear()
        _binding = null
    }
}