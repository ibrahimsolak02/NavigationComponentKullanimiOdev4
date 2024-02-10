package com.ibrahimsolak.navigationcomponentkullanimiodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentAnasayfaBinding
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentSatinAlBinding

class SatinAlFragment : Fragment() {
    private lateinit var binding: FragmentSatinAlBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentSatinAlBinding.inflate(inflater,container, false)

        val bundle: SatinAlFragmentArgs by navArgs()

        val gelenFiyatSatinAl = bundle.fiyatSatinAl
        val motor = bundle.motor
        val gelenMarka = bundle.motor.marka
        val gelenModel = bundle.motor.model
        val gelenYil = bundle.motor.yil

        binding.textSatinAlFiyat.text = "$gelenMarka $gelenModel $gelenYil $gelenFiyatSatinAl$"

        binding.buttonSepeteEkle.setOnClickListener(){
            Snackbar.make(it,"Sepete eklendi.",Snackbar.LENGTH_SHORT).show()
            val gecisIndirim = SatinAlFragmentDirections.gecisIndirim(motor = motor,gelenFiyatSatinAl)
            Navigation.findNavController(it).navigate(gecisIndirim)
        }
        return binding.root
    }

}