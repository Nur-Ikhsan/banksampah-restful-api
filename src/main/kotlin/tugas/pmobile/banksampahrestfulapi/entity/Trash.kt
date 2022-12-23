package tugas.pmobile.banksampahrestfulapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
@Table(name = "trash")
data class Trash(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "price", nullable = false)
    var price: Long,

    @Column(name = "description", nullable = false)
    var description: String,

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true)
    var trashImage: TrashImage?

)
