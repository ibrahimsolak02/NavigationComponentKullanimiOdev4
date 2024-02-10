package com.ibrahimsolak.navigationcomponentkullanimiodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentKiralaBinding


class KiralaFragment : Fragment() {
    private lateinit var binding : FragmentKiralaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentKiralaBinding.inflate(inflater,container, false)


        val bundle: KiralaFragmentArgs by navArgs()

        val gelenFiyatKirala = bundle.fiyatKirala

        val motor = bundle.motor
        val gelenMarka = bundle.motor.marka
        val gelenModel = bundle.motor.model
        val gelenYil = bundle.motor.yil

        binding.buttonSepeteEkleKiralama.setOnClickListener(){
            Snackbar.make(it,"Sepete eklendi.", Snackbar.LENGTH_SHORT).show()

        }

        binding.textKiralaFiyat.text = "$gelenMarka $gelenModel $gelenYil $gelenFiyatKirala$"

        binding.buttonOdemeGit2.setOnClickListener(){
            val gecisOdeme2 = KiralaFragmentDirections.gecisOdeme2(motor = motor , gelenFiyatKirala)
            Navigation.findNavController(it).navigate(gecisOdeme2)
        }
        return binding.root
    }

}