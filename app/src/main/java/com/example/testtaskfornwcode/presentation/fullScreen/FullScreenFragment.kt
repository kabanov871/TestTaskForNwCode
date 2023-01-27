package com.example.testtaskfornwcode.presentation.fullScreen

import android.app.WallpaperManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.testtaskfornwcode.R
import com.example.testtaskfornwcode.databinding.FragmentFullScreenBinding
import com.example.testtaskfornwcode.presentation.MyApp
import com.example.testtaskfornwcode.presentation.ViewModelFactory
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import javax.inject.Inject

class FullScreenFragment : Fragment() {

    lateinit var binding: FragmentFullScreenBinding
    lateinit var currentImage: String

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
        binding = FragmentFullScreenBinding.inflate(inflater, container, false)
        currentImage = arguments?.getSerializable("image") as String
        Picasso.get().load(currentImage).into(binding.imageView)

        binding.buttonSet.setOnClickListener {

            binding.progressBar2.visibility = View.VISIBLE

            CoroutineScope(Dispatchers.IO).launch {

                val inputStream = withContext(Dispatchers.IO) {
                    URL(currentImage).openStream()
                }
                WallpaperManager.getInstance(requireContext()).setStream(inputStream)

                withContext(Dispatchers.Main) {
                    Toast.makeText(context, R.string.set_ok, Toast.LENGTH_SHORT).show()
                    binding.progressBar2.visibility = View.INVISIBLE
                }
            }
        }
        return binding.root
    }
}