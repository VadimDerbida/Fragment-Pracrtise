package com.dg.lesson3.presentation.ui.auth

import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.bold
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.dg.lesson3.databinding.FragmentDashboardBinding
import com.dg.lesson3.domain.User
import java.time.LocalDate

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DashboardFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupUi()
        backToMenu()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setupUi() {
        val now = LocalDate.now()
        val birthday = LocalDate.parse(args.user.birthday)
        val age = now.year - birthday.year

        val string = SpannableStringBuilder()
            .append("My name is ")
            .bold { append(args.user.name + " " + args.user.surname + "\n") }
            .append("I'm ")
            .bold { append("$age years old\n") }
            .append("My height is - ")
            .bold { append(args.user.height + " m" + "\n") }
            .append("My weight is - ")
            .bold { append(args.user.weight + " kg" + "\n") }
            .append("I'm playing ")
            .bold { append(if (args.user.game == User.GameStatus.LOL) "League of Legends" else "Apex Legends") }

        binding.contentText.text = string
    }

    private fun backToMenu() {
        binding.backToMenuButton.setOnClickListener {
            findNavController().navigate(DashboardFragmentDirections.actionDashboardFragmentToFirstScreenFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}