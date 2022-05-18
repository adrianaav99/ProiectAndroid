package com.example.proiectandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.proiectandroid.databinding.FragmentRecyclerViewBinding

class Recycler : Fragment() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: MutableList<News>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    private lateinit var adapterRV : MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //val view: View = inflater!!.inflate(R.layout.fragment_recycler_view, container, false)
        val binding = DataBindingUtil.inflate<FragmentRecyclerViewBinding>(inflater,
            R.layout.fragment_recycler_view, container, false)

        imageId = arrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i
        )

        heading = arrayOf(
            "Top cele mai importante obiceiuri de care sa tii cont zilnic pentru sanatatea ta",
            "Concertele s-au mutat pe strada in timpul pandemiei",
            "Coada interminabila la noaptea muzeelor",
            "Update razboiul din Ucraina",
            "Evenimente culturale: lectii gratuite de dans pentru copiii de scoala generala",
            "Ce a anuntat Joe Biden la ultima conferinta de presa",
            "Rochii inovatoare la prezentarea de moda de la Paris",
            "Inteligenta artificiala: Unde vom ajunge?",
            "Cum sa te asiguri la casa de sanatate privata"
        )

        newRecyclerView = binding.recyclerView
        newRecyclerView.layoutManager = LinearLayoutManager(context)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = mutableListOf<News>()

        for(i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newArrayList.add(news)
        }
        adapterRV = MyAdapter(newArrayList, newArrayList)
        newRecyclerView.adapter = adapterRV
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                if(query.isEmpty()){
                    adapterRV.resetFilters()
                }
                adapterRV.filterItems(query)
                return false
            }
        })

        return binding.root
    }


    //private fun getUserData() {
    //   for(i in imageId.indices){
    //       val news = News(imageId[i], heading[i])
    //       newArrayList.add(news)

    //   }
    //    //tempArrayList.addAll(newArrayList)
    //    newRecyclerView.adapter = MyAdapter(newArrayList, newArrayList)
    //}
}
