package tugas.pmobile.banksampahrestfulapi.entity

import java.sql.Time
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType

@Entity
@Table(name = "locations")
data class Location(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "address", nullable = false)
    var address: String,

    @Column(name = "open_time", nullable = false)
    var open_time: Time,

    @Column(name = "close_time", nullable = false)
    var close_time: Time,

    @Column(name = "contacts", nullable = false)
    var contacts: String,

    @Column(name = "latitute", nullable = false)
    var latitude: Double,

    @Column(name = "longitute", nullable = false)
    var longitude: Double

)