package ca.qc.cstj.consortium.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ca.qc.cstj.consortium.databinding.SplashActivityBinding
import ca.qc.cstj.consortium.presentation.adapters.DeliveryRecyclerViewAdapter
import ca.qc.cstj.consortium.presentation.ui.deliveries.DeliveriesActivity
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {
    private lateinit var  binding : SplashActivityBinding
    private val viewModel: SplashViewModel by viewModels()

    private lateinit var deliveryRecyclerViewAdapter: DeliveryRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.trader.observe(this) {
            with(binding){
                txtEplil.text = it.eplil.toString()
                txtAwhil.text = it.awhil.toString()
                txtVethyx.text = it.vethyx.toString()
                textLaspyx.text = it.laspyx.toString()
                txtSmiathil.text = it.smiathil.toString()
            }

        }



        binding.btnChargement.setOnClickListener {

            var elementEplil = Random.nextInt(50, 200).toFloat()
            var elementAwhil = Random.nextInt(50, 200).toFloat()
            var elementVethyx = Random.nextInt(50, 200).toFloat()
            var elementLaspyx = Random.nextInt(50, 200).toFloat()
            var elementSmiathil = Random.nextInt(50, 200).toFloat()

            viewModel.chargerCargaison(elementEplil, elementAwhil, elementVethyx, elementLaspyx, elementSmiathil)
        }

        binding.btnOuvrir.setOnClickListener {
            var traderName = binding.nomMarchand.editText!!.text.toString()

            if(traderName == "")
                Toast.makeText(this, "le champ nom ne peut être null", Toast.LENGTH_SHORT).show()
            else {
                viewModel.save(traderName)
                startActivity(DeliveriesActivity.newIntent(this, traderName))
            }


        }

        binding.btnTeleverser.setOnClickListener {
            viewModel.deleteDeliveries()
        }
    }
}