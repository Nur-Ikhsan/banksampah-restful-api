package tugas.pmobile.banksampahrestfulapi.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateTrashRequest(

    @field:NotBlank
    var name : String?,

    @field:NotNull
    @field:Min(value = 1)
    var price : Long?,

    @field:NotBlank
    var description : String?
)
