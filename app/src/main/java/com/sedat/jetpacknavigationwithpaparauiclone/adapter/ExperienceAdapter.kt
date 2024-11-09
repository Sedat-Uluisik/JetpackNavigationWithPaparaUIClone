package com.sedat.jetpacknavigationwithpaparauiclone.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sedat.jetpacknavigationwithpaparauiclone.databinding.ItemLayoutExperienceBinding
import com.sedat.jetpacknavigationwithpaparauiclone.databinding.ItemLayoutStoryBinding
import com.sedat.jetpacknavigationwithpaparauiclone.model.StoryModel

class ExperienceAdapter(private val storyItems: List<StoryModel>): RecyclerView.Adapter<ExperienceAdapter.StoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {

        val view = ItemLayoutExperienceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        val displayMetrics = parent.context.resources.displayMetrics
        val screenWidth = displayMetrics.widthPixels

        val layoutParams = view.root.layoutParams
        layoutParams.width = screenWidth / 2
        view.root.layoutParams = layoutParams

        return StoryViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val storyModel = storyItems[position]
        holder.bind(storyModel)
    }

    override fun getItemCount() = storyItems.size
    
    class StoryViewHolder(private val binding: ItemLayoutExperienceBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(storyModel: StoryModel) = with(binding){
            Glide.with(this.root).load(storyModel.img).into(imgStory)
            txtStoryTitle.text = storyModel.title
        }
    }
}