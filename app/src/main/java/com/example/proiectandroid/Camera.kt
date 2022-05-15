package com.example.proiectandroid

import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.core.view.drawToBitmap
import androidx.databinding.DataBindingUtil
import com.example.proiectandroid.databinding.ActivityMainBinding
import com.example.proiectandroid.databinding.FragmentCameraBinding
import java.io.File
import java.io.OutputStream
import java.util.*

class Camera : Fragment() {

    @Suppress("DEPRECATION")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentCameraBinding>(inflater,
            R.layout.fragment_camera, container, false)
        binding.buttonPg2.setOnClickListener {
            val i= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 101)
        }

        binding.button2Pg2.setOnClickListener (View.OnClickListener {
            val imageView: ImageView = requireView().findViewById(R.id.imagine_camera)
            val bitmap=imageView.drawToBitmap()
            saveImageToGalalery(bitmap)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    // Creating our Share Intent

    @Suppress("DEPRECATION")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==101){
            val pic = data?.getParcelableExtra<Bitmap>("data")
            val imageView: ImageView = requireView().findViewById(R.id.imagine_camera)
            imageView.setImageBitmap(pic)
        }

    }

    private fun saveImageToGalalery(bitmap: Bitmap){
        val fos: OutputStream
        try{
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q){
                //ContentResolver resolver= context.getContentResolver()
                //val resolver = ContentResolver(activity)
                val resolver = activity?.contentResolver
                val contentV= contentValuesOf()
                contentV.put(MediaStore.MediaColumns.DISPLAY_NAME, "Image_"+".jpg")
                contentV.put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
                contentV.put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES+ File.separator+"TestFolder")
                val imageUri=
                    resolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentV)
                fos= resolver!!.openOutputStream(Objects.requireNonNull(imageUri)!!)!!
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                Objects.requireNonNull<OutputStream?>(fos)
                Toast.makeText(activity,"Imagine salvata", Toast.LENGTH_SHORT).show()

                val shareIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_STREAM, imageUri)
                    type = "image/jpeg"
                }
                startActivity(Intent.createChooser(shareIntent, null))
            }
        }
        catch (e: Exception){
            Toast.makeText(activity, "Imagine nesalvata", Toast.LENGTH_SHORT).show()
        }
    }
}

