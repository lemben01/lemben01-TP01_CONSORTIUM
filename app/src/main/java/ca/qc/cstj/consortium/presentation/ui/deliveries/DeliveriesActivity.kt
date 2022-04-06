
package ca.qc.cstj.consortium.presentation.ui.deliveries

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.core.notifyAllItemChanged
import ca.qc.cstj.consortium.databinding.ActivityDeliveriesBinding
import ca.qc.cstj.consortium.presentation.adapters.DeliveryRecyclerViewAdapter
import ca.qc.cstj.consortium.presentation.ui.new_delivery.NewDeliveryActivity


class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDeliveriesBinding
    private val viewModel: DeliveriesViewModel by viewModels()

    private lateinit var deliveryRecyclerViewAdapter: DeliveryRecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveriesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        deliveryRecyclerViewAdapter = DeliveryRecyclerViewAdapter(listOf())
        binding.rcvDelivery.adapter = deliveryRecyclerViewAdapter
        binding.rcvDelivery.layoutManager = LinearLayoutManager(this)

        viewModel.deliveries.observe(this){
            deliveryRecyclerViewAdapter.deliveries = it
            deliveryRecyclerViewAdapter.notifyAllItemChanged()
        }

        binding.btnAjouter.setOnClickListener {
            startActivity(NewDeliveryActivity.newIntent(this))
        }

        binding.txtTraderName.text = getString(R.string.bonRetour, intent.getStringExtra("TRADER_NAME"))


    }

    companion object {
        fun newIntent(context: Context, traderName: String): Intent {
            val traderName = traderName
            val intent = Intent(context, DeliveriesActivity::class.java)
            intent.putExtra("TRADER_NAME", traderName)
            return intent
        }
    }
}