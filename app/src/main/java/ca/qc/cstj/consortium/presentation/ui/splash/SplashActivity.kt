package ca.qc.cstj.consortium.presentation.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.SplashActivityBinding
import ca.qc.cstj.consortium.presentation.ui.deliveries.DeliveriesActivity
import kotlin.random.Random

class SplashActivity : AppCompatActivity() {
    private lateinit var  binding : SplashActivityBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //fait le binding sur les textviews avec le nombre d'element
        viewModel.trader.observe(this) {
            with(binding){
                txtEplil.text = String.format("%.2f",it.eplil)
                txtAwhil.text = String.format("%.2f",it.awhil)
                txtVethyx.text = String.format("%.2f",it.vethyx)
                textLaspyx.text = String.format("%.2f",it.laspyx)
                txtSmiathil.text = String.format("%.2f",it.smiathil)
            }
        }

        //permet de charger la cargaison de facon random entre 50 et 200
        binding.btnChargement.setOnClickListener {
            var elementEplil = Random.nextInt(50, 200).toFloat()
            var elementAwhil = Random.nextInt(50, 200).toFloat()
            var elementVethyx = Random.nextInt(50, 200).toFloat()
            var elementLaspyx = Random.nextInt(50, 200).toFloat()
            var elementSmiathil = Random.nextInt(50, 200).toFloat()

            viewModel.chargerCargaison(elementEplil, elementAwhil, elementVethyx, elementLaspyx, elementSmiathil)
        }

        //permet d'ouvrir vers la page de deliveries
        binding.btnOuvrir.setOnClickListener {
            var traderName = binding.nomMarchand.editText!!.text.toString()

            if(traderName == "")
                Toast.makeText(this, getString(R.string.champNull), Toast.LENGTH_SHORT).show()
            else {
                viewModel.save(traderName)
                startActivity(DeliveriesActivity.newIntent(this, traderName))
            }
        }

        //bouton qui permet de supprimer les deliveries
        binding.btnTeleverser.setOnClickListener {
            Toast.makeText(this, getString(R.string.commandeSupprime), Toast.LENGTH_SHORT).show()

            viewModel.deleteDeliveries()
        }
    }
}