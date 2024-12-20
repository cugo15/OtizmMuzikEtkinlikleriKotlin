package com.aecg.oyunvemuzikae.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.app.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentOyunResimdenSestenBulBinding
import com.aecg.oyunvemuzikae.domain.GameType
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.setForegroundDrawable
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OyunResimdenSestenBulFragment : BaseFragment<FragmentOyunResimdenSestenBulBinding>(FragmentOyunResimdenSestenBulBinding::inflate) {

    private lateinit var possibleCorrectInstruments: ArrayList<SesModel>
    private lateinit var possibleWrongInstruments: ArrayList<SesModel>
    private lateinit var gameType: GameType

    private var mediaPlayer: MediaPlayer? = null
    private lateinit var soundListSestenBul: ArrayList<Int>

    private val wrongSoundResId = R.raw.sound_yanlis_cevap
    private var wrongMediaPlayer: MediaPlayer? = null
    private lateinit var correctInstrument : SesModel
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isAnswerButtonsEnabled(false)
        val args = OyunResimdenSestenBulFragmentArgs.fromBundle(requireArguments())
        gameType = args.gameType
        possibleCorrectInstruments = args.resimdenSestenBulList.toCollection(ArrayList())
        possibleWrongInstruments = getPossibleWrongInstruments()

        correctInstrument = possibleCorrectInstruments.random().also { possibleCorrectInstruments.remove(it) }
        soundListSestenBul = createSoundList(correctInstrument, gameType)
        binding.txtOyunResimdenSestenBulHeader.text = getGameHeaderText(gameType, correctInstrument)
        setInstrumentImages(correctImageView,correctInstrument.imageResourceId,selectWrongInstruments(correctInstrument))
        binding.layoutOyunResimdenSestenBul.loadLayoutBackgroundWithGlide(requireContext(),setupGameBackground(gameType))
        playSound()

        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer1,binding.imgOyunResimdenSestenBulAnswer1)
        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer2, binding.imgOyunResimdenSestenBulAnswer2)
        setCardViewClickListener(binding.cardViewOyunResimdenSestenBulAnswer3, binding.imgOyunResimdenSestenBulAnswer3)
        binding.btnOyunResimdenSestenBulReplay.setOnClickListener { listenSoundAgain() }
    }

    private fun getPossibleWrongInstruments(): ArrayList<SesModel> {
        return if (gameType == GameType.RESIMDENBUL) {
            // Resimden Bul oyunu için listeyi döndürüyoruz
            myApplication.oyunResimdenBulList.toCollection(ArrayList())
        } else {
            // Diğer oyun türleri için enstrüman listesini döndürüyoruz
            myApplication.enstrumanList.toCollection(ArrayList())
        }
    }

    private fun getGameHeaderText(gameType: GameType, correctInstrument: SesModel): String {
        return when (gameType) {
            GameType.ENSTRUMANTIPI -> {
                (correctInstrument.type as? SesType.ENSTRUMAN)?.displayGameHeader?.let {
                    "Aşağıdaki enstrümanlardan hangisi $it çalgıdır?"
                } ?: "Geçersiz enstrüman türü"
            }
            GameType.SESTENBUL -> {
                "Acaba bu ses hangi enstrümana ait?"
            }
            GameType.RESIMDENBUL -> {
                "Acaba ${correctInstrument.sesName} hangisi?"
            }
            else -> {
                "Geçersiz oyun tipi"
            }
        }
    }

    private fun createSoundList(correctInstrument: SesModel, gameType: GameType): ArrayList<Int> {
        return when (gameType) {
            GameType.RESIMDENBUL -> arrayListOf(
                correctInstrument.sesResourceId,
                R.raw.sound_oyun_resimdenbul_soru,
                R.raw.sound_cevap_dogru
            )
            GameType.SESTENBUL -> arrayListOf(
                R.raw.sound_oyun_sestenbul_soru,
                correctInstrument.sesResourceId,
                R.raw.sound_cevap_dogru
            )
            else -> when (correctInstrument.type) {
                SesType.ENSTRUMAN.UFLEMELI -> arrayListOf(
                    R.raw.sound_hayvan_name_at,// Yeni ses dosyası gelecek
                    R.raw.sound_cevap_dogru
                )
                SesType.ENSTRUMAN.ORFF -> arrayListOf(
                    R.raw.sound_arac_name_ambulans,// Yeni ses dosyası gelecek
                    R.raw.sound_cevap_dogru
                )
                SesType.ENSTRUMAN.VURMALI -> arrayListOf(
                    R.raw.sound_arac_name_ucak,// Yeni ses dosyası gelecek
                    R.raw.sound_cevap_dogru
                )
                else -> arrayListOf(
                    R.raw.sound_hayvan_name_kaz,// Yeni ses dosyası gelecek
                    R.raw.sound_cevap_dogru
                )
            }
        }
    }

    private fun selectWrongInstruments(correctInstrument: SesModel): Pair<Int, Int> {
        possibleWrongInstruments.remove(correctInstrument)
        // Eğer oyun türü ENSTRUMANTIPI ise, aynı türdeki enstrümanları çıkarıyoruz
        if (gameType == GameType.ENSTRUMANTIPI) {
            possibleWrongInstruments.removeIf { it.type == correctInstrument.type }
        }
        // Yanlış enstrümanları karıştırıyoruz ve ilk iki tanesini alıyoruz
        val shuffledList = possibleWrongInstruments.map { it.imageResourceId }.shuffled()
        return shuffledList.take(2).let { Pair(it[0], it[1]) }
    }

    private fun setCardViewClickListener(cardView: CardView, imageView: ImageView) {
        cardView.setOnClickListener {
            handleAnswerSelection(imageView, cardView)
        }
    }

    private fun handleAnswerSelection(selectedAnswer: ImageView, cardView: CardView) {
        cardView.setForegroundDrawable(if (selectedAnswer == correctImageView) {
            R.drawable.border_card_green.also {
                increaseIndexAndplayNextSound()
                isAnswerButtonsEnabled(false)
            }
        } else {
            R.drawable.border_card_red.also { playWrongSound() }
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

    private fun playSound() {
        // Check if the current index is within the bounds of sound resources
        if (currentIndex < soundListSestenBul.size) {
            releaseAndCreateMediaPlayer()

            // Use when statement for better clarity
            when (currentIndex) {
                0 -> handleSoundStartForType(GameType.ENSTRUMANTIPI, 1000)
                1 -> handleSoundStartForType(gameType, if (gameType == GameType.RESIMDENBUL) 1000 else 2000)
            }

            mediaPlayer?.start()
            mediaPlayer?.setOnCompletionListener {
                handleSoundCompletion()
            }
        }
    }
    private fun handleSoundStartForType(type: GameType, delayTime: Long) {
        if (gameType == type) {
            lifecycleScope.launch {
                delay(delayTime)
                isAnswerButtonsEnabled(true)
            }
        }
    }

    private fun handleSoundCompletion() {
        if (gameType== GameType.ENSTRUMANTIPI){
            when (currentIndex) {
                1 -> navigateToSelf()
            }
        }else{
            when (currentIndex) {
                2 -> navigateToSelf()
                0 -> increaseIndexAndplayNextSound()
            }
        }
    }
    private fun increaseIndexAndplayNextSound() {
        currentIndex++
        playSound()
    }
    private fun releaseAndCreateMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundListSestenBul[currentIndex])

        mediaPlayer?.setOnCompletionListener {
            // Ses tamamlandığında yapılacak işlemler
            increaseIndexAndplayNextSound()
        }
    }

    private fun navigateToSelf() {
        if (possibleCorrectInstruments.isEmpty()) {
            possibleCorrectInstruments = myApplication.enstrumanList
        }
        OyunResimdenSestenBulFragmentDirections.oyunResimdenSestenBulFragmentSelf(
            possibleCorrectInstruments.toTypedArray(),
            gameType
        )
            .also { action -> findNavController().navigate(action) }
    }

    private fun listenSoundAgain() {
        isAnswerButtonsEnabled(false)
        currentIndex = if (gameType == GameType.RESIMDENBUL) 0 else if(gameType == GameType.SESTENBUL) 1 else 1
        playSound()
    }
    private fun setupGameBackground(gameType: GameType): Int {
        return when (gameType) {
            GameType.RESIMDENBUL -> R.drawable.bg_oyun_resimdenbul
            GameType.SESTENBUL -> R.drawable.bg_oyun_sestenbul
            GameType.ENSTRUMANTIPI -> R.drawable.bg_oyun_resimdenbul // Arka plan değişecek
            else -> return 0 // Geçersiz gameType, 0 döner (geçersiz kaynak)
        }
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
        mediaPlayer?.release()
        wrongMediaPlayer?.release()
    }
}
