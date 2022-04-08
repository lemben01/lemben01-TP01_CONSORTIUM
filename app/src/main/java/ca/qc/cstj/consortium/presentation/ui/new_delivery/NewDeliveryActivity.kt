package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.domain.models.Delivery


class NewDeliveryActivity : AppCompatActivity() {

    private lateinit var binding : NewDeliveryActivityBinding
    private val viewModel: NewDeliveryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewDeliveryActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //permet de reinitialiser les valeurs du slider
        with(binding){
            sldEplil.value = 0F
            sldAwhil.value = 0F
            sldVethyx.value = 0F
            sldLaspyx.value = 0F
            sldSmiathil.value = 0F
        }

        //permet de disable les slider si les elements de cette categorie est vide, sinon la valeur du slider s'ajuste avec le reste de la cargaison
        viewModel.trader.observe(this) {
            with(binding) {
                if(it.eplil == 0.0F)
                    sldEplil.isEnabled = false
                else {
                    sldEplil.value = 0F
                    sldEplil.valueTo = it.eplil
                }
                if (it.awhil == 0.0F)
                    sldAwhil.isEnabled = false
                else {
                    sldAwhil.value = 0F
                    sldAwhil.valueTo = it.awhil
                }
                if (it.vethyx == 0.0F)
                    sldVethyx.isEnabled = false
                else {
                    sldVethyx.value = 0F
                    sldVethyx.valueTo = it.vethyx
                }
                if (it.laspyx == 0.0F)
                    sldLaspyx.isEnabled = false
                else {
                    sldLaspyx.value = 0F
                    sldLaspyx.valueTo = it.laspyx
                }
                if (it.smiathil == 0.0F)
                    sldSmiathil.isEnabled = false
                else {
                    sldSmiathil.value = 0F
                    sldSmiathil.valueTo = it.smiathil
                }
            }
            //permet de binder la valeur du textview selon la position du slider
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
            //permet d'enregistrer la nouvelle commande
            binding.btnSaveDelivery.setOnClickListener{
                with(binding){
                    if (sldEplil.value == 0.0F && sldAwhil.value == 0.0F && sldVethyx.value == 0.0F && sldLaspyx.value == 0.0F && sldSmiathil.value == 0.0F){
                        Toast.makeText(this@NewDeliveryActivity,getString(R.string.quantiteVide), Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@NewDeliveryActivity,getString(R.string.commmandeCree), Toast.LENGTH_SHORT).show()
                        var delivery = Delivery(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                        viewModel.createDelivery(delivery)
                        viewModel.deleteQuantity(binding.sldEplil.value, binding.sldAwhil.value, binding.sldVethyx.value, binding.sldLaspyx.value, binding.sldSmiathil.value)
                        viewModel.saveDelivery()
                    }
                    finish()
                }
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, NewDeliveryActivity::class.java)
        }
    }
}