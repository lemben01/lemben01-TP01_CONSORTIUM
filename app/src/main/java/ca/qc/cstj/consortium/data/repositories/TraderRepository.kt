package ca.qc.cstj.consortium.data.repositories

import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("CONSORTIUM")

class TraderRepository(private val context: Context) {

    object PreferencesKeys {
        val TRADER_NAME = stringPreferencesKey("trader_name")
        val EPLIL = floatPreferencesKey("eplil")
        val AWHIL = floatPreferencesKey("awhil")
        val VETHYX = floatPreferencesKey("vethyx")
        val LASPYX = floatPreferencesKey("laspyx")
        val SMIATHIL = floatPreferencesKey("smiathil")
    }

    val trader: Flow<Trader> = context.dataStore.data.map { preferences ->
        val traderName = preferences[PreferencesKeys.TRADER_NAME] ?: ""
        val eplil = preferences[PreferencesKeys.EPLIL] ?: 200F
        val awhil = preferences[PreferencesKeys.AWHIL] ?: 200F
        val vethyx = preferences[PreferencesKeys.VETHYX] ?: 200F
        val laspyx = preferences[PreferencesKeys.LASPYX] ?: 200F
        val smiathil = preferences[PreferencesKeys.SMIATHIL] ?: 200F

        Trader(traderName, eplil, awhil, vethyx, laspyx, smiathil)
    }

    //fonction qui permet de charger la cargaison
    suspend fun chargerCargaison(eplil : Float, awhil : Float, vethyx : Float, laspyx : Float, smiathil : Float){

        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.EPLIL] = eplil
            preferences[PreferencesKeys.AWHIL] = awhil
            preferences[PreferencesKeys.VETHYX] = vethyx
            preferences[PreferencesKeys.LASPYX] = laspyx
            preferences[PreferencesKeys.SMIATHIL] = smiathil
        }
    }

    //fonction qui permet de save le nom du marchand
    suspend fun save(traderName:String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.TRADER_NAME] = traderName

        }
    }
}