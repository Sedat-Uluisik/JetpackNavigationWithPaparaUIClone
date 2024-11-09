package com.sedat.jetpacknavigationwithpaparauiclone

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sedat.jetpacknavigationwithpaparauiclone.adapter.ExperienceAdapter
import com.sedat.jetpacknavigationwithpaparauiclone.adapter.StoryAdapter
import com.sedat.jetpacknavigationwithpaparauiclone.databinding.FragmentHomeBinding
import com.sedat.jetpacknavigationwithpaparauiclone.model.StoryModel


class HomeFragment : Fragment() {

    private var adapterStory: StoryAdapter ?= null
    private var adapterExperience: ExperienceAdapter ?= null
    private var _binding: FragmentHomeBinding ?= null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init(){
        val storyList = getStories()
        adapterStory = StoryAdapter(storyList)
        binding.recyclerStory.adapter = adapterStory

        val experiences = getExperiences()
        adapterExperience = ExperienceAdapter(experiences)
        binding.recyclerExperience.adapter = adapterExperience


    }

    private fun getStories(): List<StoryModel>{
        return listOf(
            StoryModel(R.drawable.img_announcement, "Duyurular"),
            StoryModel(R.drawable.img_gift, "Davet Et, Kazan"),
            StoryModel(R.drawable.img_earth, "Yurt Dışı Para Transferi"),
            StoryModel(R.drawable.img_chat, "Sohbetler"),
            StoryModel(R.drawable.img_cash, "Cash")
        )
    }

    private fun getExperiences(): List<StoryModel>{
        return listOf(
            StoryModel(R.drawable.ic_black_credit_card_20, "Papara Card Ekle"),
            StoryModel(R.drawable.ic_black_home_20, "Adres Ekle"),
            StoryModel(R.drawable.ic_black_person_20, "Profil Fotoğrafı Ekle"),
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}