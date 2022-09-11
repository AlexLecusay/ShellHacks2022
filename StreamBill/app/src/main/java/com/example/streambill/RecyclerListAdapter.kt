package com.example.streambill

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class RecyclerListAdapter (selectListener : MainActivity.RecyclerViewClickListener) : ListAdapter<StreamingServiceInfo, RecyclerListAdapter.ServiceProviderViewHolder>(UserDiffUtil()) {

    private val mSelectListener = selectListener

    class ServiceProviderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val mStreamingServiceLogo : ImageView = itemView.findViewById(R.id.serviceImage)
        private val mServiceDescription : TextView = itemView.findViewById(R.id.serviceDescription)
        private val mServiceCost : TextView = itemView.findViewById(R.id.serviceCost)

        fun bindData(streamServiceInfo : StreamingServiceInfo){
            mStreamingServiceLogo.setImageResource(streamServiceInfo.streamingServiceLogo)
            mServiceDescription.text = streamServiceInfo.streamingServiceCompany
            mServiceCost.text = streamServiceInfo.serviceCompanyCost
        }
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : ServiceProviderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_main_recyclerview, parent, false)
        return ServiceProviderViewHolder(view)
    }

    override fun onBindViewHolder(holder : ServiceProviderViewHolder, position : Int) {
        holder.bindData(getItem(position))
        holder.itemView.setOnClickListener {
            mSelectListener.onItemClicked(getItem(position), holder.itemView.context)
        }
    }

    class UserDiffUtil : DiffUtil.ItemCallback<StreamingServiceInfo>() {
        override fun areItemsTheSame(
            oldItem : StreamingServiceInfo,
            newItem : StreamingServiceInfo
        ): Boolean {
            return oldItem.streamingServiceCompany == newItem.streamingServiceCompany
        }

        override fun areContentsTheSame(
            oldItem: StreamingServiceInfo,
            newItem: StreamingServiceInfo
        ): Boolean {
            return oldItem.serviceCompanyCost == newItem.serviceCompanyCost
        }
    }
}

data class StreamingServiceInfo (
    val streamingServiceLogo : Int,
    val streamingServiceCompany : String,
    val serviceCompanyCost : String
)