package com.gcyazilim.traveldesigntutorial.view

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.gcyazilim.traveldesigntutorial.R
import com.gcyazilim.traveldesigntutorial.base.models.ItemModel
import com.gcyazilim.traveldesigntutorial.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private lateinit var model: ItemModel

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
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backButtonListener()
        getArgument()
        checkWifi()
        checkGuide()
    }

    private fun backButtonListener() =
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

    private fun checkGuide() {
        binding.detailGuideCard.visibility = if (model.guide) View.VISIBLE else View.GONE
    }

    private fun checkWifi() {
        binding.detailWifiCard.visibility = if (model.wifi) View.VISIBLE else View.GONE
    }

    private fun getArgument() {
        arguments?.let { bundle ->
            val tempModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getSerializable("Model", ItemModel::class.java)
            } else {
                bundle.getSerializable("Model")
            }
            tempModel?.let { itemModel ->
                model = itemModel as ItemModel
                binding.model = itemModel
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}