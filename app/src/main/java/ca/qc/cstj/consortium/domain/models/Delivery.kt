package ca.qc.cstj.consortium.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "deliveries")
data class Delivery (
    @ColumnInfo(name="eplil") var eplil:  Float = 0.0F,
    @ColumnInfo(name="Awhil") var awhil: Float = 0.0F,
    @ColumnInfo(name="vethyx") var vethyx: Float = 0.0F,
    @ColumnInfo(name="laspyx") var laspyx: Float = 0.0F,
    @ColumnInfo(name="smiathil") var smiathil: Float = 0.0F,

    ) {
    @PrimaryKey(autoGenerate = true) var idDelivery : Int = 0
}
