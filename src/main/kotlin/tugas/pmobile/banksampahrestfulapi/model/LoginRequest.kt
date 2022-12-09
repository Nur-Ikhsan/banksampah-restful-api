package tugas.pmobile.banksampahrestfulapi.model

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class LoginRequest(

    @field:NotBlank
    @field:Email
    var email : String?,

    @field:NotBlank
    var password : String?
)
