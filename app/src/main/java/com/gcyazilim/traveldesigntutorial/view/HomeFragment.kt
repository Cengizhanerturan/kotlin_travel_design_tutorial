package com.gcyazilim.traveldesigntutorial.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.gcyazilim.traveldesigntutorial.R
import com.gcyazilim.traveldesigntutorial.adapters.CategoryAdapter
import com.gcyazilim.traveldesigntutorial.adapters.PopularAdapter
import com.gcyazilim.traveldesigntutorial.base.models.CategoryModel
import com.gcyazilim.traveldesigntutorial.base.models.ItemModel
import com.gcyazilim.traveldesigntutorial.databinding.FragmentHomeBinding
import com.gcyazilim.traveldesigntutorial.viewmodel.HomeViewModel

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var categoryAdapter: CategoryAdapter

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
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapters()
        setPopularList()
        setCategoryList()
    }

    private fun setCategoryList() {
        categoryAdapter.differ.submitList(viewModel.categoryList.value)
    }

    private fun setPopularList() {
        popularAdapter.differ.submitList(viewModel.popularList.value)
    }


    private fun setupAdapters() {
        if (binding.viewPop.adapter == null) {
            popularAdapter = PopularAdapter()
            binding.viewPop.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = popularAdapter
            }
        }
        if (binding.viewCat.adapter == null) {
            categoryAdapter = CategoryAdapter()
            binding.viewCat.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = categoryAdapter
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}