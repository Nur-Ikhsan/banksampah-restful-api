package tugas.pmobile.banksampahrestfulapi.entity

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "storing_trashes")
data class StoringTrash(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id", nullable = false)
    val accountId: Account?,

    @ManyToOne
    @JoinColumn(name = "trash_id", referencedColumnName = "id", nullable = false)
    val trashId: Trash?,

    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    val locationId: Location?,

    var weight: Int?,

    var total : Long?,

    @Column(name = "created_at", nullable = false)
    val createdAt : Timestamp?,

    @Enumerated(EnumType.STRING)
    var status: StoringTrashStatus? = StoringTrashStatus.DalamProses
)

enum class StoringTrashStatus() {
    DalamProses,
    Selesai,
    Dibatalkan
}
