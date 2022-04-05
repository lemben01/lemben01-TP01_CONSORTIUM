package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.consortium.data.AppDatabase
import ca.qc.cstj.consortium.data.repositories.DeliveryRepository
import ca.qc.cstj.consortium.data.repositories.TraderRepository
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewDeliveryViewModel(application: Application) : AndroidViewModel(application) {

    private val _trader = MutableLiveData<Trader>()
    val trader : LiveData<Trader> get() = _trader

    private val traderRepository = TraderRepository(application)

    init {
        viewModelScope.launch {
            traderRepository.trader.collect {
                _trader.value = it
            }
        }
    }


}