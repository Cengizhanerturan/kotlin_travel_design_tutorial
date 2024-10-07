package com.gcyazilim.traveldesigntutorial.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.gcyazilim.traveldesigntutorial.R
import com.gcyazilim.traveldesigntutorial.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private var _binding: FragmentIntroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getToHome()
    }

    private fun getToHome() = binding.getStartedButton.setOnClickListener {
        val action = IntroFragmentDirections.actionIntroFragmentToHomeFragment()
        Navigation.findNavController(it).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}