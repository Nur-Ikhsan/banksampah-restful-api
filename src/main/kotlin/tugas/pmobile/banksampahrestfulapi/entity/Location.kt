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

    @Column(name = "name")
    var name: String,

    @Column(name = "address")
    var address: String,

    @Column(name = "open_time")
    var open_time: Time,

    @Column(name = "close_time")
    var close_time: Time,

    @Column(name = "contacts")
    var contacts: String

)