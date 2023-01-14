package tugas.pmobile.banksampahrestfulapi.model

import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.entity.Location
import tugas.pmobile.banksampahrestfulapi.entity.StoringTrashStatus

import java.sql.Timestamp

data class StoringTrashResponse(
    val id: Int?,
    val accountId: Account?,
    val trashId: TrashResponse?,
    val locationId: Location?,
    val weight: Int?,
    val total : Long?,
    val createdAt : Timestamp?,
    val status: StoringTrashStatus?
)
