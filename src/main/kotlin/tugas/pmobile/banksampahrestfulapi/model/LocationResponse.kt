package tugas.pmobile.banksampahrestfulapi.model

import java.sql.Time

data class LocationResponse(

    val id: Int?,

    var name: String,

    var address: String,

    var open_time: Time,

    var close_time: Time,

    var contacts: String,

    var latitude: Float,

    var longitude: Float
)
