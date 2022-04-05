
package ca.qc.cstj.consortium.presentation.ui.deliveries

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.databinding.ActivityDeliveriesBinding
import ca.qc.cstj.consortium.presentation.ui.new_delivery.NewDeliveryActivity


class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDeliveriesBinding
    private val viewModel: DeliveriesViewModel by viewModels()

    //private lateinit var deliveryRecyclerViewAdapter: DeliveryRecyclerViewAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeliveriesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*viewModel.deliveries.observe(this) {
            deliveryRecyclerViewAdapter.differ.su
        }*/


        //TODO: afficher l'ecran pour passer des commandes
        binding.btnAjouter.setOnClickListener {
            startActivity(NewDeliveryActivity.newIntent(this))
        }

    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DeliveriesActivity::class.java)
        }
    }
}