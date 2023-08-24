package com.dg.lesson3.presentation.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.dg.lesson3.R
import com.dg.lesson3.databinding.FragmentGameBinding
import com.dg.lesson3.domain.Allversions
import com.dg.lesson3.domain.GameError

class GameFragment : Fragment() {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupUi() {
        var error = GameError.NONE
        var currentVersion = Allversions.CUPCAKE
        var currentNumber : Int = 1

        binding.minButton.setOnClickListener {
            if (currentNumber>1){
            currentNumber --
            binding.androidVersion.text = (currentNumber).toString()
            when(currentNumber) {
                1 -> currentVersion = Allversions.CUPCAKE
                2 -> currentVersion = Allversions.DONUT
                3 -> currentVersion = Allversions.ECLAIR
                4 -> currentVersion = Allversions.FROYO
                5 -> currentVersion = Allversions.GINGERBREAD
                6 -> currentVersion = Allversions.HONEYCOMB
                7 -> currentVersion = Allversions.ICE_CREAM_SANDWICH
                8 -> currentVersion = Allversions.JELLY_BEAN
                9 -> currentVersion = Allversions.KITKAT
                10 -> currentVersion = Allversions.LOLLIPOP
                11 -> currentVersion = Allversions.MARSHMALLOW
                12 -> currentVersion = Allversions.NOUGAT
                13 -> currentVersion = Allversions.OREO
                14 -> currentVersion = Allversions.PIE
                15 -> currentVersion = Allversions.QUEEN_CAKE
                16 -> currentVersion = Allversions.RED_VELVET_CAKE
                17 -> currentVersion = Allversions.SNOW_CONE
                18 -> currentVersion = Allversions.TIRAMISU
            }
            }
            else {Toast.makeText(requireContext(), "U cant do that", Toast.LENGTH_SHORT).show()}
            binding.image.setImageResource(when (currentVersion) {
                Allversions.CUPCAKE -> R.drawable.cupcake
                Allversions.DONUT -> R.drawable.donut
                Allversions.ECLAIR -> R.drawable.eclair
                Allversions.FROYO -> R.drawable.froyo
                Allversions.GINGERBREAD -> R.drawable.gingerbread
                Allversions.HONEYCOMB -> R.drawable.honeycomb
                Allversions.ICE_CREAM_SANDWICH -> R.drawable.ice_cream_sandwich
                Allversions.JELLY_BEAN -> R.drawable.jelly_bean
                Allversions.KITKAT -> R.drawable.kitkat
                Allversions.LOLLIPOP -> R.drawable.lollipop
                Allversions.MARSHMALLOW -> R.drawable.marshmallow
                Allversions.NOUGAT -> R.drawable.nougat
                Allversions.OREO -> R.drawable.oreo
                Allversions.PIE -> R.drawable.pie
                Allversions.QUEEN_CAKE -> R.drawable.queen_cake
                Allversions.RED_VELVET_CAKE -> R.drawable.red_velvet_cake
                Allversions.SNOW_CONE -> R.drawable.snow_cone
                Allversions.TIRAMISU -> R.drawable.tiramisu

            })
        }

        binding.plusButton.setOnClickListener{
            if (currentNumber<18){
                    currentNumber ++
                    binding.androidVersion.text = (currentNumber).toString()
                   when(currentNumber){
                       1 -> currentVersion = Allversions.CUPCAKE
                       2 -> currentVersion = Allversions.DONUT
                       3 -> currentVersion = Allversions.ECLAIR
                       4 -> currentVersion = Allversions.FROYO
                       5 -> currentVersion = Allversions.GINGERBREAD
                       6 -> currentVersion = Allversions.HONEYCOMB
                       7 -> currentVersion = Allversions.ICE_CREAM_SANDWICH
                       8 -> currentVersion = Allversions.JELLY_BEAN
                       9 -> currentVersion = Allversions.KITKAT
                       10 -> currentVersion = Allversions.LOLLIPOP
                       11 -> currentVersion = Allversions.MARSHMALLOW
                       12 -> currentVersion = Allversions.NOUGAT
                       13 -> currentVersion = Allversions.OREO
                       14 -> currentVersion = Allversions.PIE
                       15 -> currentVersion = Allversions.QUEEN_CAKE
                       16 -> currentVersion = Allversions.RED_VELVET_CAKE
                       17 -> currentVersion = Allversions.SNOW_CONE
                       18 -> currentVersion = Allversions.TIRAMISU
                   }}
            else{Toast.makeText(requireContext(), "U cant do that", Toast.LENGTH_SHORT).show()}
            binding.image.setImageResource(when (currentVersion) {
                Allversions.CUPCAKE -> R.drawable.cupcake
                Allversions.DONUT -> R.drawable.donut
                Allversions.ECLAIR -> R.drawable.eclair
                Allversions.FROYO -> R.drawable.froyo
                Allversions.GINGERBREAD -> R.drawable.gingerbread
                Allversions.HONEYCOMB -> R.drawable.honeycomb
                Allversions.ICE_CREAM_SANDWICH -> R.drawable.ice_cream_sandwich
                Allversions.JELLY_BEAN -> R.drawable.jelly_bean
                Allversions.KITKAT -> R.drawable.kitkat
                Allversions.LOLLIPOP -> R.drawable.lollipop
                Allversions.MARSHMALLOW -> R.drawable.marshmallow
                Allversions.NOUGAT -> R.drawable.nougat
                Allversions.OREO -> R.drawable.oreo
                Allversions.PIE -> R.drawable.pie
                Allversions.QUEEN_CAKE -> R.drawable.queen_cake
                Allversions.RED_VELVET_CAKE -> R.drawable.red_velvet_cake
                Allversions.SNOW_CONE -> R.drawable.snow_cone
                Allversions.TIRAMISU -> R.drawable.tiramisu

                            })




                }

        }



        override fun onDestroy() {
            super.onDestroy()
            _binding = null
        }
    }
