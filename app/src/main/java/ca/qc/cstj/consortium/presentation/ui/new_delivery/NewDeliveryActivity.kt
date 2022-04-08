package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.core.Constants
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.domain.models.Delivery


class NewDeliveryActivity : AppCompatActivity() {

    private lateinit var binding : NewDeliveryActivityBinding
    private val viewModel: NewDeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewDeliveryActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO: Initialiser tout les sld a 0
        with(binding){
            sldEplil.value = 0F
            sldAwhil.value = 0F
            sldVethyx.value = 0F
            sldLaspyx.value = 0F
            sldSmiathil.value = 0F
        }


        viewModel.trader.observe(this) {
            with(binding)
            {
                sldEplil.value = 0F
                sldEplil.valueTo = it.eplil

                sldAwhil.value = 0F
                sldAwhil.valueTo = it.awhil

                sldVethyx.value = 0F
                sldVethyx.valueTo = it.vethyx

                sldLaspyx.value = 0F
                sldLaspyx.valueTo = it.laspyx

                sldSmiathil.value = 0F
                sldSmiathil.valueTo = it.smiathil
            }

            with(binding) {
                sldEplil.addOnChangeListener {_, valSlider,_ ->
                    txtQuantityEplil.text = String.format("%.2f", valSlider)
                }
                sldAwhil.addOnChangeListener {_, valSlider,_ ->
                    txtQuantityAwhil.text = String.format("%.2f", valSlider)
                }
                sldVethyx.addOnChangeListener {_, valSlider,_ ->
                    txtQuantityVethyx.text = String.format("%.2f", valSlider)
                }
                sldLaspyx.addOnChangeListener {_, valSlider,_ ->
                    txtQuantityLaspyx.text = String.format("%.2f", valSlider)
                }
                sldSmiathil.addOnChangeListener {_, valSlider,_ ->
                    txtQuantitySmiathil.text = String.format("%.2f", valSlider)
                }

            }

            binding.btnSaveDelivery.setOnClickListener{
                var delivery = Delivery(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                viewModel.createDelivery(delivery)
                viewModel.deleteQuantity(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                viewModel.saveDelivery(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                finish()
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewDeliveryActivity::class.java)
        }
    }
}