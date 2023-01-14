package tugas.pmobile.banksampahrestfulapi.model

import tugas.pmobile.banksampahrestfulapi.entity.StoringTrashStatus

data class UpdateStoringTrashRequest(
    val weight: Int?,
    val status: StoringTrashStatus?
)
