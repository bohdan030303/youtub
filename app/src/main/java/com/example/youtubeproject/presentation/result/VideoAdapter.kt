package com.example.youtubeproject.presentation.result

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.youtubeproject.R
import com.example.youtubeproject.data.model.VideoData

class VideoAdapter(private val videoData: VideoData, private val navController: NavController) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.videoImageView)
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)
        val videoLayout: LinearLayout = itemView.findViewById(R.id.videoLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.video_item, parent, false)
        return VideoViewHolder(view)
    }


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val item = videoData.items[position]

        Glide.with(holder.imageView).load(item.snippet.thumbnails.default.url)
            .into(holder.imageView)
        holder.dateTextView.text = item.snippet.publishedAt
        holder.nameTextView.text = item.snippet.title

        holder.videoLayout.setOnClickListener {
            navController.navigate(ResultFragmentDirections.actionResultFragmentToVideoFragment(item.id.videoId))
        }
    }

    override fun getItemCount(): Int {
        return videoData.items.size
    }
}