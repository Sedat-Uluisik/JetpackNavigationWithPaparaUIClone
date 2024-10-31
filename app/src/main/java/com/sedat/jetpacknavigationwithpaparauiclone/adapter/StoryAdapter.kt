package com.sedat.jetpacknavigationwithpaparauiclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sedat.jetpacknavigationwithpaparauiclone.databinding.ItemLayoutStoryBinding
import com.sedat.jetpacknavigationwithpaparauiclone.model.StoryModel

class StoryAdapter(private val storyItems: List<StoryModel>): RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        return StoryViewHolder(
            ItemLayoutStoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val storyModel = storyItems[position]
        holder.bind(storyModel)
    }

    override fun getItemCount() = storyItems.size
    
    class StoryViewHolder(private val binding: ItemLayoutStoryBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(storyModel: StoryModel) = with(binding){
            Glide.with(this.root).load(storyModel.img).into(imgStory)
            txtStoryTitle.text = storyModel.title
        }
    }
}