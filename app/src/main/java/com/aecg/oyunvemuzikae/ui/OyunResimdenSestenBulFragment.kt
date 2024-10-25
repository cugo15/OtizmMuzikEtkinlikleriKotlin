package com.aecg.oyunvemuzikae.ui

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.Sesler.SesModel
import com.aecg.oyunvemuzikae.databinding.FragmentOyunResimdenSestenBulBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OyunResimdenSestenBulFragment : Fragment() {
    
    private var _binding: FragmentOyunResimdenSestenBulBinding? = null
    private val binding get() = _binding!!

    private lateinit var enstrumanList: ArrayList<SesModel>
    private lateinit var enstrumanFullList: ArrayList<SesModel>
    
    private lateinit var gameType: String

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var soundListSestenBul: ArrayList<Int>

    private val wrongSoundResId = R.raw.sound_yanlis_cevap

    private var wrongMediaPlayer: MediaPlayer? = null

    private var currentIndex = 0

    private val myApplication: MyApplication by lazy {
        requireActivity().application as MyApplication
    }

    private val imageViews: List<ImageView> by lazy {
        listOf(
            binding.imgOyunResimdenSestenBulAnswer1,
            binding.imgOyunResimdenSestenBulAnswer2,
            binding.imgOyunResimdenSestenBulAnswer3
        )
    }
    private val correctImageView: ImageView by lazy { imageViews.random() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOyunResimdenSestenBulBinding.inflate(inflater, container, false)
        val view = binding.root
        isAnswerButtonsEnabled(false)
        initializeGameData()

        // Doğru enstrümanı rastgele seç ve listeden çıkar
        val correctInstrument = enstrumanList.random().also { enstrumanList.remove(it) }
        binding.txtOyunResimdenSestenBulHeader.text = correctInstrument.sesName

        setInstrumentImages(correctImageView,correctInstrument.imageResourceId,selectWrongInstruments(correctInstrument))
        setupGameLayout(gameType, correctInstrument)
        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer1,binding.imgOyunResimdenSestenBulAnswer1)
        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer2, binding.imgOyunResimdenSestenBulAnswer2)
        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer3, binding.imgOyunResimdenSestenBulAnswer3)
        binding.btnOyunResimdenSestenBulReplay.setOnClickListener { listenSoundAgain() }

        return view
    }
    private fun initializeGameData() {
        val args = OyunResimdenSestenBulFragmentArgs.fromBundle(requireArguments())
        gameType = args.resimdenSestenBulType
        enstrumanFullList = if (gameType == "Resimden Bul") {//Resimden bul ise
            myApplication.oyunResimdenBulList.toCollection(ArrayList())
        } else {//Sesten Bul Oyunu ise
            myApplication.enstrumanList.toCollection(ArrayList())
        }
        enstrumanList = args.resimdenSestenBulList.toCollection(ArrayList())
    }

    private fun createSoundList(correctInstrument: SesModel, isResimdenBul: Boolean) {
        soundListSestenBul = if (isResimdenBul) {
            arrayListOf(correctInstrument.sesResourceId, R.raw.sound_oyun_resimdenbul_soru, R.raw.sound_cevap_dogru)
        } else {
            arrayListOf(R.raw.sound_oyun_sestenbul_soru, correctInstrument.sesResourceId, R.raw.sound_cevap_dogru)
        }
    }

    private fun selectWrongInstruments(correctInstrument: SesModel): Pair<Int, Int> {
        enstrumanFullList.remove(correctInstrument)
        val shuffledList = enstrumanFullList.map { it.imageResourceId }.shuffled()
        return shuffledList.take(2).let { Pair(it[0], it[1]) } // Yanlış enstrümanları çift olarak döndür
    }

    private fun setCardViewClickListener(cardView: CardView, imageView: ImageView) {
        cardView.setOnClickListener {
            handleAnswerSelection(imageView, cardView)
        }
    }

    private fun handleAnswerSelection(selectedAnswer: ImageView, cardView: CardView) {
        cardView.setBackgroundResource(if (selectedAnswer == correctImageView) {
            R.drawable.border.also {
                increaseIndexAndPlayNextSound()
                isAnswerButtonsEnabled(false)
            }
        } else {
            R.drawable.border_red.also { playWrongSound() }
        })
    }

    private fun setInstrumentImages(
        correctImageView: ImageView,
        correctInstrument: Int,
        wrongInstruments: Pair<Int, Int>,
    ) {
        // Doğru imgView'ın indexini bul
        val correctIndex = imageViews.indexOf(correctImageView)
        // Her bir imageView için işlemleri yap
        imageViews.forEachIndexed { index, imageView ->
            val imageResourceId = when (index) {
                correctIndex -> correctInstrument // Doğru enstrümanı ata
                (correctIndex + 1) % 3 -> wrongInstruments.first // Doğru enstrümandan sonraki yanlışı ata
                else -> wrongInstruments.second// Diğerine yanlışı ata
            }
            Glide.with(requireContext())
                .load(imageResourceId)
                .into(imageView)
        }
    }

    private fun isAnswerButtonsEnabled(isEnabled: Boolean) {
        binding.cardViewOyunResimdenSestenBulAnswer1.isEnabled = isEnabled
        binding.cardViewOyunResimdenSestenBulAnswer2.isEnabled = isEnabled
        binding.cardViewOyunResimdenSestenBulAnswer3.isEnabled = isEnabled
    }

    private fun playNextSound() {
        // Check if the current index is within the bounds of sound resources
        if (currentIndex < soundListSestenBul.size) {
            releaseAndCreateMediaPlayer()
            if (currentIndex == 1) {
                if(gameType == "Resimden Bul"){
                    lifecycleScope.launch {
                        delay(1000)
                        isAnswerButtonsEnabled(true)
                    }
                }else{
                    lifecycleScope.launch {
                        delay(2000)
                        isAnswerButtonsEnabled(true)
                    }
                }
            }
            mediaPlayer?.setOnCompletionListener {
                handleSoundCompletion()
            }
            mediaPlayer?.start()
        }
    }

    private fun handleSoundCompletion() {
        when (currentIndex) {
            2 -> navigateToSelf()
            0 -> increaseIndexAndPlayNextSound()
        }
    }
    private fun increaseIndexAndPlayNextSound() {
        currentIndex++
        playNextSound()
    }
    private fun releaseAndCreateMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundListSestenBul[currentIndex])
    }
    private fun navigateToSelf() {
        if (enstrumanList.isEmpty()) {
            enstrumanList = myApplication.enstrumanList
        }
        OyunResimdenSestenBulFragmentDirections
            .oyunResimdenSestenBulFragmentSelf(enstrumanList.toTypedArray(), gameType)
            .also { action -> findNavController().navigate(action) }
    }

    private fun listenSoundAgain() {
        isAnswerButtonsEnabled(false)
        currentIndex = if (gameType == "Resimden Bul") 0 else if(gameType == "Sesten Bul") 1 else 1
        playNextSound()
    }
    private fun setupGameLayout(gameType: String, correctInstrument: SesModel) {
        val (background, isFromImage) = when (gameType) {
            "Resimden Bul" -> R.drawable.resimdenbulback2 to true
            "Sesten Bul" -> R.drawable.sestenback to false
            else -> return
        }
        binding.layoutOyunResimdenSestenBul.loadLayoutBackgroundWithGlide(requireContext(), background, R.drawable.bg_doga)
        createSoundList(correctInstrument, isFromImage)
        playNextSound()
    }
    private fun playWrongSound() {
        // Yanlış ses dosyasını ayarlayın
        wrongMediaPlayer = MediaPlayer.create(requireContext(), wrongSoundResId) // Yanlış ses dosyasını belirtin
        wrongMediaPlayer?.start() // Yanlış sesi çal
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mediaPlayer?.release()
        wrongMediaPlayer?.release()
    }
}
