package tugas.pmobile.banksampahrestfulapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType


@Entity
@Table(name = "trash_images")
data class TrashImage(
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "name", nullable = false)
    val name: String,

    @Column(name = "size", nullable = false)
    val size: Long,

    @Column(name = "type", nullable = false)
    val type: String
)
