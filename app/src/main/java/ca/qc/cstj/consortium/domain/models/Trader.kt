package ca.qc.cstj.consortium.domain.models

import androidx.room.Entity


@Entity(tableName = "traders")

data class Trader (var name:String, var eplil:Double = 200.0, var Awhil:Double = 200.0, var vethyx:Double = 200.0,
    var laspyx:Double = 200.0, var smiathil:Double = 200.0) {

}