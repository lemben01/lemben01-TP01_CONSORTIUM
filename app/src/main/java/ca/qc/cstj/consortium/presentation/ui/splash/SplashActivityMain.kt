package ca.qc.cstj.consortium.presentation.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ActivityMainBinding
import ca.qc.cstj.consortium.databinding.SplashActivityMainBinding

@SuppressLint("CustomSplashScreen")
class SplashActivityMain : AppCompatActivity() {
    private lateinit var  binding : SplashActivityMainBinding
    private val viewModel: SplashMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel.trader.observe(this) {
            binding.txtEplil.text = it.eplil.toString()
            binding.txtAwhil.text = it.Awhil.toString()
            binding.txtVethyx.text = it.vethyx.toString()
            binding.textLaspyx.text = it.laspyx.toString()
            binding.txtSmiathil.text = it.smiathil.toString()
        }

    }
}