package com.example.proiectandroid

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.VideoView
import androidx.databinding.DataBindingUtil
import com.example.proiectandroid.databinding.FragmentCameraBinding
import com.example.proiectandroid.databinding.FragmentTitleBinding

class VideoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater!!.inflate(R.layout.fragment_video, container, true)
        //val mediaController = MediaController(context)
        //val viewVideo: VideoView = requireView().findViewById(R.id.videoView)
        //mediaController.setAnchorView(viewVideo)
        //val offlineUri: Uri = Uri.parse("android.resource://com.example.proiectandroid/res/raw/dancevideo.mp4")
        //viewVideo.setMediaController(mediaController)
        //viewVideo.setVideoURI(offlineUri)
        //viewVideo.requestFocus()
        //viewVideo.start()
        return view
    }
}