package com.example.proiectandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.proiectandroid.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        //val cameraButton: Button = requireView().findViewById(R.id.button)
        //cameraButton.setOnClickListener {view : View ->
            //view.findNavController().navigate(R.id.action_titleFragment_to_camera)}
        //return inflater.inflate(R.layout.fragment_title, container, false)
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title, container, false)
        binding.button.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_titleFragment_to_camera)
        }
        binding.button2.setOnClickListener { view: View->
            view.findNavController().navigate(R.id.action_titleFragment_to_recycler)
        }
        return binding.root
    }

}
