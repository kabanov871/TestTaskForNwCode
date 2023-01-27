package com.example.testtaskfornwcode.presentation.listImage

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testtaskfornwcode.R
import com.example.testtaskfornwcode.databinding.FragmentListImagesBinding
import com.example.testtaskfornwcode.databinding.FragmentStartBinding
import com.example.testtaskfornwcode.presentation.MyApp
import com.example.testtaskfornwcode.presentation.ViewModelFactory
import com.example.testtaskfornwcode.presentation.start.StartViewModel
import javax.inject.Inject

class ListImagesFragment : Fragment() {

    lateinit var binding: FragmentListImagesBinding
    private lateinit var viewModel: ListImageViewModel
    lateinit var adapter: ListImagesAdapter

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
        binding = FragmentListImagesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this, viewModelFactory)[ListImageViewModel::class.java]

        binding.rv.layoutManager = GridLayoutManager(context, 3)
        adapter = ListImagesAdapter {largeImage: String -> getImage(largeImage)}
        binding.rv.adapter = adapter

        displayStartImages()

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun displayStartImages(){

        viewModel.getImages.observe(viewLifecycleOwner

        ) {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        }

    }

    private fun getImage(largeImage: String) {

        val bundle = Bundle()
        bundle.putSerializable("image", largeImage)
        findNavController().navigate(R.id.action_listImagesFragment_to_fullScreenFragment, bundle)

    }

}