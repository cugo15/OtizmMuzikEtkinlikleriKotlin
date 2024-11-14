package com.aecg.oyunvemuzikae.ui.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentMuzikBinding
import com.aecg.oyunvemuzikae.ui.adapter.MuzikAdapter
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.domain.MuzikType

class MuzikFragment : BaseFragment<FragmentMuzikBinding>(FragmentMuzikBinding::inflate) {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var muzikList: ArrayList<MuzikModel>
    private lateinit var animationzoom: Animation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationzoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)
        muzikList = MuzikFragmentArgs.fromBundle(requireArguments()).muzikList.toCollection(ArrayList())
        setupRecyclerView(muzikList)
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
    }
}