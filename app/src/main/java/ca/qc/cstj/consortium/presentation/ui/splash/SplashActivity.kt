package ca.qc.cstj.consortium.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import ca.qc.cstj.consortium.databinding.NewDeliveryActivityBinding
import ca.qc.cstj.consortium.databinding.SplashActivityBinding
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {
    private lateinit var  binding : SplashActivityBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.trader.observe(this) {
            binding.txtEplil.text = it.eplil.toString()
            binding.txtAwhil.text = it.awhil.toString()
            binding.txtVethyx.text = it.vethyx.toString()
            binding.textLaspyx.text = it.laspyx.toString()
            binding.txtSmiathil.text = it.smiathil.toString()
        }

        binding.btnChargement.setOnClickListener {

            var elementEplil = Random.nextInt(50, 200).toFloat()
            var elementAwhil = Random.nextInt(50, 200).toFloat()
            var elementVethyx = Random.nextInt(50, 200).toFloat()
            var elementLaspyx = Random.nextInt(50, 200).toFloat()
            var elementSmiathil = Random.nextInt(50, 200).toFloat()

            viewModel.chargerCargaison(elementEplil, elementAwhil, elementVethyx, elementLaspyx, elementSmiathil)
        }

        /*binding.btnOuvrir.setOnClickListener {
            startActivity()
        }*/
    }


}