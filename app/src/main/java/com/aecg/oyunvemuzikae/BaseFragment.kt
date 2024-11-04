package com.aecg.oyunvemuzikae

import android.content.pm.ActivityInfo
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    override fun onResume() {
        super.onResume()
        // Sadece landscape modda çalışmasını sağla
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }

    override fun onPause() {
        super.onPause()
        // Fragment kapandığında eski ayara dön
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }
}
