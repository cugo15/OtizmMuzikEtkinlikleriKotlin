package com.aecg.oyunvemuzikae.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHafizaBinding
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.loadResourceImageWithGlide
import com.aecg.oyunvemuzikae.utils.setForegroundDrawable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class OyunHafizaFragment : BaseFragment<FragmentOyunHafizaBinding>(FragmentOyunHafizaBinding::inflate) {

    private lateinit var enstrumanList: ArrayList<SesModel>
    private var lastClickedImage:Int = 0
    private var lastClickedView: ImageView? = null
    private var lastClickedCardView: CardView? = null
    private lateinit var imgPairs: MutableList<Pair<ImageView, CardView>>
    private lateinit var shuffledImages: List<Int>
    private var correctSoundId: Int = R.raw.dogrucingil
    private var wrongSoundId: Int = R.raw.sound_yanlis_cevap
    private var difficulty: Int = 0
    private var lvl: Int = 0
    private var mediaPlayer: MediaPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        imgPairs = initializeImagePairs()
        enstrumanList = OyunHafizaFragmentArgs.fromBundle(requireArguments()).enstrumanList.toCollection(ArrayList())
        difficulty = OyunHafizaFragmentArgs.fromBundle(requireArguments()).difficulty
        shuffledImages = getShuffledImages(enstrumanList, difficulty)
        lvl = OyunHafizaFragmentArgs.fromBundle(requireArguments()).lvl


        binding.imageViewOyunHafizaHint.setOnClickListener {handleHintClick()}

        initializeDifficulty(difficulty)
        updateLevelAndDifficulty()
        addClickListenerToCards()

    }

    private fun updateLevelAndDifficulty() {
        binding.txtOyunHafizaLvl.text = lvl.toString()
        if (lvl % 5 == 0 ) {
            difficulty++
        }
        lvl++
    }
    private fun initializeDifficulty(difficulty: Int) {
        // Arka planı yükle
        setLayoutBackgroundForLevel(difficulty)
        // Seviye bazında gizlenecek öğeleri belirle
        val hiddenIndices = getHiddenIndicesForLevel(difficulty)
        // Gizlenmesi gereken öğeleri `View.GONE` yap
        hiddenIndices.forEach { index ->
            imgPairs.getOrNull(index)?.second?.visibility = View.GONE
        }
        // Gizlenen öğeleri imgPairs listesinden kaldır
        imgPairs.removeAll { it.second.visibility == View.GONE }
    }

    private fun playSoundWithMediaPlayer(soundResId: Int, onCompletion: () -> Unit) {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundResId).apply {
            setOnCompletionListener {
                // Ses tamamlandığında yapılacak işlem
                onCompletion()
                // MediaPlayer'ı serbest bırak
                release()
            }
            start() // Sesi çalmaya başla
        }
    }

    private fun initializeImagePairs(): MutableList<Pair<ImageView, CardView>> {
        return mutableListOf(
            binding.imageView1 to binding.cardView1,
            binding.imageView2 to binding.cardView2,
            binding.imageView3 to binding.cardView3,
            binding.imageView4 to binding.cardView4,
            binding.imageView5 to binding.cardView5,
            binding.imageView6 to binding.cardView6,
            binding.imageView7 to binding.cardView7,
            binding.imageView8 to binding.cardView8,
            binding.imageView9 to binding.cardView9,
            binding.imageView10 to binding.cardView10
        )
    }



    private fun getHiddenIndicesForLevel(level: Int): List<Int> {
        return when (level) {
            1 -> listOf(2, 3, 4, 5, 6, 7, 8, 9)
            2 -> listOf(2, 3, 4, 7, 8, 9)
            3 -> listOf(3, 4, 8, 9)
            4 -> listOf(4, 9)
            else -> emptyList() // Varsayılan olarak tüm imgPairs gösterilir
        }
    }

    private fun setLayoutBackgroundForLevel(level: Int) {
        val backgroundResId = when (level) {
            1 -> R.drawable.bg_oyun_hafiza_lvl1
            2 -> R.drawable.bg_oyun_hafiza_lvl2
            3 -> R.drawable.bg_oyun_hafiza_lvl3
            4 -> R.drawable.bg_oyun_hafiza_lvl4
            else -> R.drawable.bg_oyun_hafiza_lvl5
        }
        binding.layoutFragmentOyunHafiza.loadLayoutBackgroundWithGlide(requireContext(), backgroundResId)
    }

    private fun handleFirstClick(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        updateLastClickedData(shuffledImage, imageView)
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(null, cardView, R.drawable.border_card_blue)
        lastClickedView?.isClickable = false
        binding.imageViewOyunHafizaHint.isClickable = false
        lastClickedCardView = cardView
    }

    private fun handleCorrectMatch(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(lastClickedCardView, cardView, R.drawable.border_card_green)
        imageView.isEnabled = false
        lastClickedView?.isEnabled = false
        updateLastClickedData(0, null)
        binding.imageViewOyunHafizaHint.isClickable = true
        playSoundWithMediaPlayer(correctSoundId){ navigateIfAllCardsDisabled() }
    }
    // imgPairs kontrolünü yapacak ve işlem sonucunda yönlendirme yapacak fonksiyon
    private fun navigateIfAllCardsDisabled() {
        // Eğer imgPairs'teki tüm öğeler pasif ise
        if (imgPairs.all { !it.first.isEnabled }) {
            // Navigasyonu gerçekleştirecek yönlendirme işlemi
            OyunHafizaFragmentDirections.actionOyunHafizaFragmentSelf(
                enstrumanList.toTypedArray(),
                difficulty,
                lvl
            )
                .also { findNavController().navigate(it) }
        }
    }

    private fun handleIncorrectMatch(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        setImageViewsClickable(false)
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(lastClickedCardView, cardView, R.drawable.border_card_red)
        playSoundWithMediaPlayer(wrongSoundId){}
        lifecycleScope.launch {
            delay(1000)
            setCardsBorder(lastClickedCardView, cardView, R.drawable.cardview_hafiza)
            updateImageView(lastClickedView, R.drawable.ic_oyun_hafiza_card, 0)
            updateImageView(imageView, R.drawable.ic_oyun_hafiza_card, 0)
            updateLastClickedData(0, null)
            binding.imageViewOyunHafizaHint.isClickable = true
            setImageViewsClickable(true)
        }
    }
    // Ana tıklama fonksiyonu
    private fun handleImageClick(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        when (lastClickedImage) {
            0 -> handleFirstClick(imageView, shuffledImage, cardView)
            shuffledImage -> handleCorrectMatch(imageView, shuffledImage, cardView)
            else -> handleIncorrectMatch(imageView, shuffledImage, cardView)
        }
    }

    private fun addClickListenerToCards() {
        imgPairs.forEachIndexed { index, pair ->
            val (imageView, cardView) = pair
            imageView.setOnClickListener {
                handleImageClick(imageView, shuffledImages[index], cardView)
            }
        }
    }

    private fun handleHintClick() {
        // İpucu butonunu devre dışı bırak ve tüm imageView'ları tıklanamaz yap
        binding.imageViewOyunHafizaHint.isClickable = false
        setImageViewsClickable(false)
        // Tüm imageView'ları gerçek görselleriyle güncelle
        showAllImageViews()
        // 1.5 saniye bekleyip ardından tüm imageView'ları kapat
        lifecycleScope.launch {
            delay(1500)
            closeAllImageViews()  // Görselleri tekrar gizle
            setImageViewsClickable(true)  // imageView'ları tekrar tıklanabilir yap
            binding.imageViewOyunHafizaHint.isClickable = true  // İpucu butonunu tekrar etkinleştir
        }
    }
    // Tüm imageView'ları ipucu görselleriyle gösterir
    private fun showAllImageViews() {
        updateAllImageViews { index, imageView ->
            updateImageView(imageView, shuffledImages[index], 0)
        }
    }
    // Tüm imageView'ları kapatma görseliyle günceller
    private fun closeAllImageViews() {
        updateAllImageViews { _, imageView ->
            updateImageView(imageView, R.drawable.ic_oyun_hafiza_card, 0)
        }
    }
    // Tüm imgPairs öğelerine belirli bir işlem uygular
    private fun updateAllImageViews(action: (index: Int, imageView: ImageView) -> Unit) {
        imgPairs.forEachIndexed { index, pair ->
            val imageView = pair.first
            if (imageView.isEnabled) {
                action(index, imageView)
            }
        }
    }
    // Kartların kenarlıklarını parametre olarak verilen renkle ayarlamak için fonksiyon
    private fun setCardsBorder(lastClickedCardView: CardView?,currentCardView: CardView,borderDrawable: Int) {
        lastClickedCardView?.setForegroundDrawable(borderDrawable)
        currentCardView.setForegroundDrawable(borderDrawable)
    }

    private fun updateLastClickedData(imageResID: Int, imageView: ImageView?) {
        lastClickedImage = imageResID
        lastClickedView = imageView
    }

    private fun getShuffledImages(enstrumanList: ArrayList<SesModel>, numberOfItems: Int): List<Int> {
        return enstrumanList
            .shuffled() // Enstrüman listesini karıştırıyoruz
            .take(numberOfItems) // 'numberOfItems' parametresine göre belirli sayıda enstrüman seçiyoruz
            .flatMap {listOf(it.imageResourceId, it.imageResourceId)} // Her enstrümanı iki kez ekliyoruz
            .shuffled() // Oluşan listeyi tekrar karıştırıyoruz
    }

    private fun updateImageView(imageView: ImageView?, imageResID: Int, padding: Int) {
        imageView?.let {
            it.loadResourceImageWithGlide(imageResID)
            it.setPadding(padding, padding, padding, padding)
        }
    }

    private fun setImageViewsClickable(isClickable: Boolean) {
        imgPairs.forEach { (imageView, _) -> imageView.isClickable = isClickable }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release()
    }
}