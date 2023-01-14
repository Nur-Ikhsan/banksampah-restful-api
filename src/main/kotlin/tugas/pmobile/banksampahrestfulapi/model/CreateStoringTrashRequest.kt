package tugas.pmobile.banksampahrestfulapi.model

import javax.validation.constraints.NotNull

class CreateStoringTrashRequest (
    val id: Int?,
    @field:NotNull
    val accountId: Int?,
    @field:NotNull
    var trashId: Int?,
    @field:NotNull
    var locationId: Int?,
    @field:NotNull
    var weight: Int?
)
