package com.ibrahimsolak.navigationcomponentkullanimiodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentIndirimBinding


class IndirimFragment : Fragment() {
    private lateinit var binding: FragmentIndirimBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = FragmentIndirimBinding.inflate(inflater,container, false)

        val bundle: IndirimFragmentArgs by navArgs()
        var fiyatIndirim = bundle.fiyatSatinAlma

        val motor = bundle.motor
        binding.buttonIndirimUygula.setOnClickListener(){
            fiyatIndirim = (fiyatIndirim*9)/10
            Snackbar.make(it,"Indirim uygulandı",Snackbar.LENGTH_SHORT).show()

            binding.fiyatIndirim.text = "$fiyatIndirim$"
        }

        binding.buttonOdemeGit.setOnClickListener(){
            val gecisOdeme1 = IndirimFragmentDirections.gecisOdeme1(motor = motor,fiyatIndirim)
            Navigation.findNavController(it).navigate(gecisOdeme1)

        }
        return binding.root
    }

}