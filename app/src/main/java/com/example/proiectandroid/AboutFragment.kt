package com.example.proiectandroid

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.drawToBitmap
import androidx.databinding.DataBindingUtil
import com.example.proiectandroid.databinding.ActivityMainBinding
import com.example.proiectandroid.databinding.FragmentAboutBinding
import com.example.proiectandroid.databinding.FragmentCameraBinding

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentAboutBinding>(inflater,
            R.layout.fragment_about, container, false)

        binding.button3.setOnClickListener {
            var textView: TextView=requireView().findViewById(R.id.textAbout)
            var s=textView.text.toString()
            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, s)
                type ="text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via:"))
        }
        return binding.root
    }
}