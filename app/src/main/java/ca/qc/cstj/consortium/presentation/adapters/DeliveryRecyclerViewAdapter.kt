package ca.qc.cstj.consortium.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ItemElementBinding

import ca.qc.cstj.consortium.domain.models.Delivery

class DeliveryRecyclerViewAdapter(var deliveries: List<Delivery>)
    : RecyclerView.Adapter<DeliveryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeliveryRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: DeliveryRecyclerViewAdapter.ViewHolder, position: Int) {
        val delivery = deliveries[position]
        holder.bind(delivery)
    }

    override fun getItemCount(): Int = deliveries.size

    inner class  ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val binding = ItemElementBinding.bind(view)

        fun bind(delivery: Delivery){
            with(binding){
                txtNbEplil.text = delivery.eplil.toString()
                txtNbAwhil.text = delivery.awhil.toString()
                txtNbVethyx.text = delivery.vethyx.toString()
                txtNbLaspyx.text = delivery.laspyx.toString()
                txtNbSmiathil.text = delivery.smiathil.toString()
            }
        }
    }
}