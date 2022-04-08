package ca.qc.cstj.consortium.presentation.ui.new_delivery

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.consortium.data.AppDatabase
import ca.qc.cstj.consortium.data.repositories.TraderRepository
import ca.qc.cstj.consortium.domain.models.Delivery
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class NewDeliveryViewModel(application: Application) : AndroidViewModel(application) {

    private val _trader = MutableLiveData<Trader>()
    val trader : LiveData<Trader> get() = _trader

    var delivery : Delivery = Delivery()


    private val traderRepository = TraderRepository(application)
    private val deliveryRepository = AppDatabase.getDatabase(application).deliveryRepository()


    init {
        viewModelScope.launch {
            traderRepository.trader.collect {
                _trader.value = it
            }
        }
    }

    //fonction qui permet de creer une nouvelle commande
    fun createDelivery(delivery: Delivery) {
        viewModelScope.launch {
            deliveryRepository.create(delivery)
        }
    }
    //fonction qui permet de reajuster la valeur du slider apres avoir passer une commande
    fun deleteQuantity(eplil : Float, awhil : Float, vethyx : Float, laspyx : Float, smiathil : Float,) {
        _trader.value!!.eplil -= eplil
        _trader.value!!.awhil -= awhil
        _trader.value!!.vethyx -= vethyx
        _trader.value!!.laspyx -= laspyx
        _trader.value!!.smiathil -= smiathil
    }
    //fonction qui permet de save une delivery
    fun saveDelivery() {
        viewModelScope.launch {
            var elementEplil = _trader.value!!.eplil
            var elementAwhil = _trader.value!!.awhil
            var elementVethyx = _trader.value!!.vethyx
            var elementLaspyx = _trader.value!!.laspyx
            var elementSmiathil = _trader.value!!.smiathil

            traderRepository.chargerCargaison(elementEplil, elementAwhil, elementVethyx, elementLaspyx, elementSmiathil)
        }
    }

}