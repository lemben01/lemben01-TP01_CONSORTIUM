package ca.qc.cstj.consortium.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.consortium.domain.models.Delivery
import java.text.FieldPosition

class AsyncDeliveryRecyclerViewAdapter(private val onDeliveryItemClick: (Delivery) -> unit)
    : RecyclerView.Adapter<AsyncDeliveryRecyclerViewAdapter.ViewHolder>(){

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsyncDeliveryRecyclerViewAdapter.ViewHolder{
        return ViewHolder(
            ItemDeliveryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: AsyncDeliveryRecyclerViewAdapter.ViewHolder, position: Int) {
        val delivery = differ.currentList[position]
        holder.bind(delivery)

        holder.itemView.setOnClickListener {
            onDeliveryItemClick(delivery)
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    private val differCallBack = object : DiffUtil.ItemCallback<Delivery>() {
        override fun areItemsTheSame(oldItem: Delivery, newItem: Delivery): Boolean {
            return oldItem.idDelivery == newItem.idDelivery
        }

        override fun areContentsTheSame(oldItem: Delivery, newItem: Delivery): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    inner class ViewHolder(private val binding: ItemDeliveryBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(delivery: Delivery){

            //TODO: binding sur le nombre de ressource (element)

        }
    }
}