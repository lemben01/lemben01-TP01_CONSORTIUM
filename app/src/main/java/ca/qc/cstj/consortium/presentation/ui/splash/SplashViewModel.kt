package ca.qc.cstj.consortium.presentation.ui.splash

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ca.qc.cstj.consortium.data.AppDatabase
import ca.qc.cstj.consortium.data.repositories.TraderRepository
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    private val _trader = MutableLiveData<Trader>()
    val trader : LiveData<Trader> get() = _trader

    private val deliveryRepository = AppDatabase.getDatabase(application).deliveryRepository()

    private val traderRepository = TraderRepository(application)

    init {
        //Démarré dans un autre thread
        viewModelScope.launch {
            traderRepository.trader.collect {
                _trader.value = it
            }
        }
    }

    //fonction qui permet de charger la cargaison
    fun chargerCargaison(eplil : Float, awhil : Float, vethyx : Float, laspyx : Float, smiathil : Float) {
        viewModelScope.launch {
            var elementEplil = _trader.value!!.eplil + eplil
            var elementAwhil = _trader.value!!.awhil + awhil
            var elementVethyx = _trader.value!!.vethyx + vethyx
            var elementLaspyx = _trader.value!!.laspyx + laspyx
            var elementSmiathil = _trader.value!!.smiathil + smiathil

            traderRepository.chargerCargaison(elementEplil, elementAwhil, elementVethyx, elementLaspyx, elementSmiathil)
        }
    }
    //fonction qui permet de save le nom du marchand
    fun save(nomMarchand : String){
       viewModelScope.launch {
           traderRepository.save(nomMarchand)
       }
    }
    //fonction qui permet de delete tout les deliveries
    fun deleteDeliveries() {
        viewModelScope.launch {
            deliveryRepository.deleteAll()
        }
    }


}