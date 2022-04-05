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


        viewModel.trader.observe(this) {
            with(binding)
            {
                txtQuantityEplil.text = it.eplil.toString()
                txtQuantityAwhil.text = it.awhil.toString()
                txtQuantityVethyx.text = it.vethyx.toString()
                txtQuantityLaspyx.text = it.laspyx.toString()
                txtQuantitySmiathil.text = it.smiathil.toString()
            }

            //TODO: vider les slider avant de rentrer dans le binding

            with(binding) {
                sldEplil.addOnChangeListener {_, valSlider,_ ->
                    var elementEplil = valSlider }
                sldAwhil.addOnChangeListener {_, valSlider,_ ->
                    var elementAwhil = valSlider }
                sldVethyx.addOnChangeListener {_, valSlider,_ ->
                    var elementVethyx = valSlider }
                sldLaspyx.addOnChangeListener {_, valSlider,_ ->
                    var elementLaspyx = valSlider }
                sldSmiathil.addOnChangeListener {_, valSlider,_ ->
                    var elementSmiathil = valSlider }
            }
        }


    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewDeliveryActivity::class.java)
        }
    }
}