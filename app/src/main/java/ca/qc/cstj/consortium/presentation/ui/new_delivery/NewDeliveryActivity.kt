/*package ca.qc.cstj.consortium.presentation.ui.deliveries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NewDeliveryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_delivery_activity)
    }
}*/

package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.presentation.ui.deliveries.DeliveriesActivity


class NewDeliveryActivity : AppCompatActivity() {

    private lateinit var binding : NewDeliveryActivityBinding
    private val viewModel: NewDeliveryViewModel by viewModels()



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
}