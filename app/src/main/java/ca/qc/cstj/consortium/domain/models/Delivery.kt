package ca.qc.cstj.consortium.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class Delivery (
    @ColumnInfo(name="eplil") var eplil: Float,
    @ColumnInfo(name="Awhil") var Awhil: Float,
    @ColumnInfo(name="vethyx") var vethyx: Float,
    @ColumnInfo(name="laspyx") var laspyx: Float,
    @ColumnInfo(name="smiathil") var smiathil: Float,

    ) {
    @PrimaryKey(autoGenerate = true) var idDelivery : Int = 0
}
