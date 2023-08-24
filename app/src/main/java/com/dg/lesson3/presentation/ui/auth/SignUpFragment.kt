package com.dg.lesson3.presentation.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dg.lesson3.domain.SignUpError
import com.dg.lesson3.domain.User
import com.dg.lesson3.databinding.FragmentSignUpBinding
import com.google.android.material.datepicker.MaterialDatePicker
import java.text.SimpleDateFormat
import java.util.*

class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    private var birthdayDate: String = ""


    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupDatePicker()
        setupToolbar()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun convertLongToString(time: Long): String {
        val date = Date(time)
        val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return format.format(date)
    }

    private fun setupDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select Date")
            .build()
        binding.agePickerButton.setOnClickListener {
            datePicker.show(parentFragmentManager, "date")
            datePicker.addOnPositiveButtonClickListener {
                birthdayDate = convertLongToString(it)
                updateLabel(it)
            }
        }
    }

    private fun updateLabel(timestamp: Long) {
        val myFormat = "dd.MM.yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        binding.ageText.text = sdf.format(timestamp)
    }


    private fun setupUi() {
        var error = SignUpError.NONE
        binding.confirmButton.setOnClickListener {
            if (binding.nameTextInput.text.isNullOrBlank()) {
                error = SignUpError.EMPTY_FIELDS
            }

            if (binding.surnameTextInput.text.isNullOrBlank()) {
                error = SignUpError.EMPTY_FIELDS
            }

            if (binding.heightTextInput.text.isNullOrBlank()) {
                error = SignUpError.EMPTY_FIELDS
            }
            if (binding.weightTextFieldTextInput.text.isNullOrBlank()) {
                error = SignUpError.EMPTY_FIELDS
            }

            if (birthdayDate.isBlank()) {
                error = SignUpError.EMPTY_FIELDS
            }

            when (error) {
                SignUpError.EMPTY_FIELDS -> {
                    Toast.makeText(requireContext(), "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                    error = SignUpError.NONE
                }
                SignUpError.NONE -> {
                    val user = User(
                        name = binding.nameTextInput.text.toString(),
                        surname = binding.surnameTextInput.text.toString(),
                        height = binding.heightTextInput.text.toString(),
                        weight = binding.weightTextFieldTextInput.text.toString(),
                        birthday = birthdayDate,
                        game = if (binding.leagueStatusButton.isChecked) User.GameStatus.LOL else User.GameStatus.APEX
                    )
                    findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToDashboardFragment(user = user))
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}