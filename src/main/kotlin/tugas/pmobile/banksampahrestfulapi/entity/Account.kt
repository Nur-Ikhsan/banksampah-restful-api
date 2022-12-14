package tugas.pmobile.banksampahrestfulapi.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.persistence.GenerationType


@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "email", nullable = false, unique = true)
    var email: String,

    @Column(name = "address", nullable = true)
    var address: String,

    @Column(name = "phoneNumber", nullable = true)
    var phoneNumber: String,

    @Column(name = "password", nullable = false)
    var password: String
)
