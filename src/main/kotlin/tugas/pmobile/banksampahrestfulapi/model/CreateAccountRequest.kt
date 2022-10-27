package tugas.pmobile.banksampahrestfulapi.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank


data class CreateAccountRequest(

    val id : Int?,

    @field:NotBlank
    var name : String?,

    @field:NotBlank
    @field:Email
    var email : String?,

    @field:NotBlank
    var address : String?,

    @field:NotBlank
    var phoneNumber : String?,

    @field:NotBlank
    var password : String?
)
