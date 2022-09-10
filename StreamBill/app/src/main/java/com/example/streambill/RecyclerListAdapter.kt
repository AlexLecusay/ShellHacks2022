package com.example.streambill

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecyclerListAdapter : ListAdapter<StreamingServiceInfo, RecyclerListAdapter.ServiceProviderViewHolder>(UserDiffUtil()) {

    class ServiceProviderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private val mServiceDescription : TextView = itemView.findViewById(R.id.serviceDescription)
        private val mServiceCost : TextView = itemView.findViewById(R.id.serviceCost)

        fun bindData(streamServiceInfo : StreamingServiceInfo){
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
    val streamingServiceCompany : String,
    val serviceCompanyCost : String
)