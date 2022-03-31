package ca.qc.cstj.consortium.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class Delivery (
    @ColumnInfo(name="eplil") var eplil: Double,
    @ColumnInfo(name="Awhil") var Awhil: Double,
    @ColumnInfo(name="vethyx") var vethyx: Double,
    @ColumnInfo(name="laspyx") var laspyx: Double,
    @ColumnInfo(name="smiathil") var smiathil: Double,

    ) {
    @PrimaryKey(autoGenerate = true) var idDelivery : Double = 0.0
}
