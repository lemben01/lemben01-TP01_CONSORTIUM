package ca.qc.cstj.consortium.data.repositories

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import ca.qc.cstj.consortium.domain.models.Trader
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore("CONSORTIUM")

class TraderRepository(private val context: Context) {

    object PreferencesKeys {
        val TRADER_NAME = stringPreferencesKey("trader_name")
        val EPLIL = floatPreferencesKey("eplil")
        val AWHIL = floatPreferencesKey("Awhil")
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
}