/*
package ca.qc.cstj.consortium.presentation.ui.deliveries

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.presentation.adapters.DeliveryRecyclerViewAdapter


class DeliveriesActivity : AppCompatActivity() {

    private lateinit var binding : 
    private val viewModel: DeliveriesActivity by viewModels()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewDeliveryActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.deliveries.observe(this) {
                
        }


    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, DeliveriesActivity::class.java)
        }
    }
}*/