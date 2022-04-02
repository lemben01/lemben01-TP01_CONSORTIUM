package ca.qc.cstj.consortium.data.repositories

import androidx.room.*
import ca.qc.cstj.consortium.domain.models.Delivery
import kotlinx.coroutines.flow.Flow

@Dao
interface DeliveryRepository {
    @Query("SELECT * FROM deliveries")
    fun retrieveAll() : Flow<List<Delivery>>

    @Insert
    suspend fun create(deliveries: List<Delivery>)

    @Insert
    suspend fun create(delivery: Delivery)

    @Delete
    suspend fun delete(delivery: Delivery)

    @Update
    suspend fun update(delivery: Delivery)

    @Query("DELETE FROM deliveries")
    suspend fun deleteAll()

}
