package com.dg.lesson3.presentation.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.dg.lesson3.databinding.FragmentFirstScreenBinding


class FirstScreenFragment : Fragment() {
    private var _binding: FragmentFirstScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstScreenBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
    }
    private fun setupUi(){
       binding.task1.setOnClickListener{
           findNavController().navigate(FirstScreenFragmentDirections.actionFirstScreenFragmentToSignUpFragment())
       }
        binding.task2.setOnClickListener{
            findNavController().navigate(FirstScreenFragmentDirections.actionFirstScreenFragmentToGameFragment())
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}