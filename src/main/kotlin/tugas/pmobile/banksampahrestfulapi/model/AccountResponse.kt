package tugas.pmobile.banksampahrestfulapi.model

data class AccountResponse(

    val id: Int?,

    var name: String,

    var email: String,

    var address: String,

    var phoneNumber: String,

    var password: String
)
