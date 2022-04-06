package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.core.Constants
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.presentation.ui.deliveries.DeliveriesActivity


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
                txtQuantityEplil.text = it.eplil.toString()
                txtQuantityAwhil.text = it.awhil.toString()
                txtQuantityVethyx.text = it.vethyx.toString()
                txtQuantityLaspyx.text = it.laspyx.toString()
                txtQuantitySmiathil.text = it.smiathil.toString()
            }

            //TODO: vider les slider avant de rentrer dans le binding

            with(binding) {
                sldEplil.addOnChangeListener {_, valSlider,_ ->
                    var elementEplil = viewModel.setElementQuantity(Constants.Elements.EPLIL, valSlider)
                }
                sldAwhil.addOnChangeListener {_, valSlider,_ ->
                    var elementAwhil = viewModel.setElementQuantity(Constants.Elements.AWHIL, valSlider)
                }
                sldVethyx.addOnChangeListener {_, valSlider,_ ->
                    var elementVethyx = viewModel.setElementQuantity(Constants.Elements.VETHYX, valSlider)
                }
                sldLaspyx.addOnChangeListener {_, valSlider,_ ->
                    var elementLaspyx = viewModel.setElementQuantity(Constants.Elements.LASPYX, valSlider)
                }
                sldSmiathil.addOnChangeListener {_, valSlider,_ ->
                    var elementSmiathil = viewModel.setElementQuantity(Constants.Elements.SMIATHIL, valSlider)
                }

            }
            binding.btnSaveDelivery.setOnClickListener{
                var delivery = Delivery(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                viewModel.saveDelivery(delivery)
                finish()
            }
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


        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewDeliveryActivity::class.java)
        }
    }
}