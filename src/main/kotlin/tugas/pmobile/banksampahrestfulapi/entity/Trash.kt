package tugas.pmobile.banksampahrestfulapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType

@Entity
@Table(name = "trash")
data class Trash(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "name")
    var name: String,

    @Column(name = "price")
    var price: Long,

    @Column(name = "description")
    var description: String

)
