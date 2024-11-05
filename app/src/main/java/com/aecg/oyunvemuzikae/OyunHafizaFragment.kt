package com.aecg.oyunvemuzikae

import android.os.Bundle
import android.view.View
import com.aecg.oyunvemuzikae.Sesler.SesModel
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHafizaBinding


class OyunHafizaFragment : BaseFragment<FragmentOyunHafizaBinding>(FragmentOyunHafizaBinding::inflate) {
    private lateinit var enstrumanList: ArrayList<SesModel>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enstrumanList = OyunHafizaFragmentArgs.fromBundle(requireArguments()).enstrumanList.toCollection(ArrayList())
        val selectedInstruments = enstrumanList.shuffled().take(5)
        val allImages = selectedInstruments + selectedInstruments
        val shuffledImages = allImages.shuffled()

        val imageViews = listOf(
            binding.imageView1,
            binding.imageView2,
            binding.imageView3,
            binding.imageView4,
            binding.imageView5,
            binding.imageView6,
            binding.imageView7,
            binding.imageView8,
            binding.imageView9,
            binding.imageView10,
        )
        val cardViews = listOf(
            binding.cardView1,
            binding.cardView2,
            binding.cardView3,
            binding.cardView4,
            binding.cardView5,
            binding.cardView6,
            binding.cardView7,
            binding.cardView8,
            binding.cardView9,
            binding.cardView10,
        )

        for (i in imageViews.indices) {
            imageViews[i].setImageResource(shuffledImages[i].imageResourceId) // Rastgele sıradaki görseli ata
            imageViews[i].setOnClickListener {
            }
        }
    }

}