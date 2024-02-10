package com.ibrahimsolak.navigationcomponentkullanimiodev4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.ibrahimsolak.navigationcomponentkullanimiodev4.databinding.FragmentOdemeBinding


class OdemeFragment : Fragment() {
    private lateinit var binding : FragmentOdemeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {

        binding = FragmentOdemeBinding.inflate(inflater,container, false )

        val bundle: OdemeFragmentArgs by navArgs()

        val odemeFiyat = bundle.fiyatOdeme

        val gelenMarka = bundle.motor.marka
        val gelenModel = bundle.motor.model
        val gelenYil = bundle.motor.yil

        binding.textOdeme.text = "$gelenMarka $gelenModel $gelenYil $odemeFiyat$"

        binding.buttonOnayla.setOnClickListener() {
            if (odemeFiyat == 20000 || odemeFiyat == 18000 ) {
                Snackbar.make(it, "Satın alma işleminiz onaylandı $odemeFiyat$", Snackbar.LENGTH_SHORT).show()
            } else if (odemeFiyat == 200 ) {
                Snackbar.make(it, "Kiralama işleminiz onaylandı $odemeFiyat$", Snackbar.LENGTH_SHORT).show()
            }
        }

        val backPress = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                Snackbar.make(binding.textOdeme,"Geri dönmek istiyor musunuz?",Snackbar.LENGTH_SHORT)
                    .setAction("EVET"){
                        isEnabled = false // Geri dönüş aktif
                        requireActivity().onBackPressedDispatcher.onBackPressed()

                    }.show()

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,backPress)

        return binding.root
    }

}