package com.example.testtaskfornwcode.presentation.start

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.testtaskfornwcode.R
import com.example.testtaskfornwcode.databinding.FragmentStartBinding
import com.example.testtaskfornwcode.presentation.MyApp
import com.example.testtaskfornwcode.presentation.ViewModelFactory
import javax.inject.Inject

class StartFragment : Fragment() {

    lateinit var binding: FragmentStartBinding
    private lateinit var viewModel: StartViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (requireActivity().application as MyApp).component
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)[StartViewModel::class.java]

        binding.apply {

            buttonAnimals.setOnClickListener { searchImages(resources.getString(R.string.animals)) }
            buttonBackgrounds.setOnClickListener { searchImages(resources.getString(R.string.backgrounds)) }
            buttonComputer.setOnClickListener { searchImages(resources.getString(R.string.computer)) }
            buttonFashion.setOnClickListener { searchImages(resources.getString(R.string.fashion)) }
            buttonIndustry.setOnClickListener { searchImages(resources.getString(R.string.industry)) }
            buttonNature.setOnClickListener { searchImages(resources.getString(R.string.nature)) }
            buttonScience.setOnClickListener { searchImages(resources.getString(R.string.science)) }
            buttonTravel.setOnClickListener { searchImages(resources.getString(R.string.travel)) }
        }

        return binding.root
    }

    private fun searchImages(category: String) {

        viewModel.searchImages(category)
        findNavController().navigate(R.id.action_startFragment_to_listImagesFragment)
    }

}