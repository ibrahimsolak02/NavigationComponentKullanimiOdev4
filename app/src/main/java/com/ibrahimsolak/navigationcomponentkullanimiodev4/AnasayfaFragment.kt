package com.ibrahimsolak.navigationcomponentkullanimiodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentAnasayfaBinding.inflate(inflater,container, false)

        binding.buttonSatinAlma.setOnClickListener(){
            val motor = Motor("Ducati","Panigale V2",2016)
            val gecisSatınAlma = AnasayfaFragmentDirections.gecisSatınAlma(motor = motor,20000)
            Navigation.findNavController(it).navigate(gecisSatınAlma)
        }

        binding.buttonKirala.setOnClickListener(){
            val motor = Motor("Ducati","Panigale V2",2016)
            val gecisKirala = AnasayfaFragmentDirections.gecisKirala(motor = motor,200)
            Navigation.findNavController(it).navigate(gecisKirala)
        }

        return binding.root
    }


}