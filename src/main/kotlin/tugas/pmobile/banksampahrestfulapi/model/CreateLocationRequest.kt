package tugas.pmobile.banksampahrestfulapi.model

import java.sql.Time
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreateLocationRequest(

    val id : Int?,

    @field:NotBlank
    var name : String?,

    @field:NotBlank
    var address : String?,

    @field:NotNull
    var open_time : Time?,

    @field:NotNull
    var close_time : Time?,

    @field:NotBlank
    var contacts : String?,

    @field:NotBlank
    var latitude: Float?,

    @field:NotBlank
    var longitude: Float?
)
