package com.app.instaimage.adapaters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.instaimage.databinding.ImageItemBinding
import com.app.instaimage.modal.ImagePresentation
import com.app.instaimage.utils.IMAGE_VIEW_TYPE
import com.app.instaimage.utils.NETWORK_VIEW_TYPE
import com.app.instaimage.utils.imageDiffCallback

class ImagesAdapter(private val clicked: (ImagePresentation, ImageView) -> Unit) :
    PagingDataAdapter<ImagePresentation, ImagesAdapter.ImageViewHolder>(imageDiffCallback) {

    inner class ImageViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(imagePassed: ImagePresentation) {
            binding.apply {
                image = imagePassed
                tags.isSelected = true
                root.setOnClickListener {
                    clicked.invoke(imagePassed, imageView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val data = getItem(position)!!

        holder.bind(data)
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount) {
            NETWORK_VIEW_TYPE
        } else {
            IMAGE_VIEW_TYPE
        }
    }

}
