package com.aecg.oyunvemuzikae

import android.media.AudioAttributes
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.lifecycle.lifecycleScope
import com.aecg.oyunvemuzikae.Sesler.SesModel
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHafizaBinding
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
    private var soundPool: SoundPool? = null
    private var correctSoundId: Int = 0
    private var wrongSoundId: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeSoundPool()
        enstrumanList = OyunHafizaFragmentArgs.fromBundle(requireArguments()).enstrumanList.toCollection(ArrayList())
        val lvl = OyunHafizaFragmentArgs.fromBundle(requireArguments()).level
        shuffledImages = getShuffledImages(enstrumanList, lvl)
        imgPairs = initializeImagePairs()
        initializeLevel(lvl)
        binding.imageViewOyunHafizaHint.setOnClickListener {handleHintClick()}
        addClickListenerToCards()
    }

    private fun initializeSoundPool() {
        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()

        // SoundPool nesnesini oluştur
        soundPool = SoundPool.Builder()
            .setMaxStreams(1) // Aynı anda sadece bir ses çalacak şekilde ayarla
            .setAudioAttributes(audioAttributes)
            .build()

        // Ses dosyalarını yükle
        correctSoundId = soundPool?.load(requireContext(), R.raw.dogrucingil, 1) ?: 0
        wrongSoundId = soundPool?.load(requireContext(), R.raw.sound_yanlis_cevap, 1) ?: 0
    }

    private fun playSound(soundId: Int) {
        // SoundPool'dan ses çal
        soundPool?.play(soundId, 1f, 1f, 0, 0, 1f)
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

    private fun initializeLevel(lvl: Int) {
        // Arka planı yükle
        setLayoutBackgroundForLevel(lvl)
        // Seviye bazında gizlenecek öğeleri belirle
        val hiddenIndices = getHiddenIndicesForLevel(lvl)
        // Gizlenmesi gereken öğeleri `View.GONE` yap
        hiddenIndices.forEach { index ->
            imgPairs.getOrNull(index)?.second?.visibility = View.GONE
        }
        // Gizlenen öğeleri imgPairs listesinden kaldır
        imgPairs.removeAll { it.second.visibility == View.GONE }
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
            1 -> R.drawable.forestic1
            2 -> R.drawable.desertcity
            3 -> R.drawable.icecity
            4 -> R.drawable.pinkcity2
            else -> R.drawable.firecity2
        }
        binding.layoutFragmentOyunHafiza.loadLayoutBackgroundWithGlide(requireContext(), backgroundResId)
    }

    private fun handleFirstClick(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        updateLastClickedData(shuffledImage, imageView)
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(null, cardView, R.drawable.blue_border)
        lastClickedView?.isClickable = false
        binding.imageViewOyunHafizaHint.isClickable = false
        lastClickedCardView = cardView
    }

    private fun handleCorrectMatch(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(lastClickedCardView, cardView, R.drawable.border)
        imageView.isEnabled = false
        lastClickedView?.isEnabled = false
        updateLastClickedData(0, null)
        binding.imageViewOyunHafizaHint.isClickable = true
        playSound(correctSoundId)
    }

    private fun handleIncorrectMatch(imageView: ImageView, shuffledImage: Int, cardView: CardView) {
        setImageViewsClickable(false)
        updateImageView(imageView, shuffledImage, 16)
        setCardsBorder(lastClickedCardView, cardView, R.drawable.border_red)
        playSound(wrongSoundId)
        lifecycleScope.launch {
            delay(1000)
            setCardsBorder(lastClickedCardView, cardView, R.drawable.cardview_hafiza)
            updateImageView(lastClickedView, R.drawable.questionmark2, 0)
            updateImageView(imageView, R.drawable.questionmark2, 0)
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
            updateImageView(imageView, R.drawable.questionmark2, 0)
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
        soundPool?.release()
    }
}