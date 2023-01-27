package com.example.testtaskfornwcode.presentation.listImage

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testtaskfornwcode.databinding.ImageItemBinding
import com.example.testtaskfornwcode.domain.UseCaseModel
import com.squareup.picasso.Picasso

class ListImagesAdapter (private val getImage: (largeImage: String) -> Unit
) : RecyclerView.Adapter<ListImagesAdapter.ListImagesHolder>(){

    private var imageList = ArrayList<UseCaseModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListImagesHolder {

        val binding : ImageItemBinding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return ListImagesHolder(binding)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ListImagesHolder, position: Int) {
        holder.bind(imageList[position], getImage)
    }

    fun setList (list: List<UseCaseModel>){
        imageList.clear()
        imageList.addAll(list)
    }

    class ListImagesHolder(val binding: ImageItemBinding): RecyclerView.ViewHolder(binding.root){


        fun bind(card: UseCaseModel, getImage:(largeImage: String)->Unit) {

            Picasso.get().load(card.previewImage).into(binding.image)
            binding.cardView.setOnClickListener { getImage(card.largeImage) }

        }
    }

}