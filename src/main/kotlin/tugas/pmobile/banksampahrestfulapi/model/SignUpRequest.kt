package tugas.pmobile.banksampahrestfulapi.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class SignUpRequest(

    @field:NotBlank
    var name : String?,

    @field:NotBlank
    @field:Email
    var email : String?,

    @field:NotBlank
    var password : String?
)
