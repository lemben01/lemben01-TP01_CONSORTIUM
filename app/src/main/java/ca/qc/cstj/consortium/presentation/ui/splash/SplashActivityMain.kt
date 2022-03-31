package ca.qc.cstj.consortium.presentation.ui.splash

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ca.qc.cstj.consortium.R
import ca.qc.cstj.consortium.databinding.ActivityMainBinding
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.presentation.adapters.AsyncDeliveryRecyclerViewAdapter
import ca.qc.cstj.consortium.presentation.ui.dialogs.DeliveryDialogFragment

@SuppressLint("CustomSplashScreen")
class SplashActivityMain : AppCompatActivity() {
    private lateinit var  binding : ActivityMainBinding
    private val viewModel: SplashMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        deliveryRecyclerViewAdapter = AsyncDeliveryRecyclerViewAdapter(this::onDeliveryItemClick)

        viewModel.deliveries.observe(this) {
            contactRecyclerViewAdapter.differ.submitList(it)
            //contactRecyclerViewAdapter.notifyAllItemChanged()
        }
        private fun onDliveryItemClick(delivery: Delivery) {
            //Toast.makeText(this, contact.fullName, Toast.LENGTH_SHORT).show()
            val args = Bundle()
            args.putString(DeliveryDialogFragment./*TODO*/, delivery.fullName)
            DeliveryDialogFragment().apply {
                arguments = args
            }.show(supportFragmentManager, DeliveryDialogFragment.TAG)
        }
    }
}