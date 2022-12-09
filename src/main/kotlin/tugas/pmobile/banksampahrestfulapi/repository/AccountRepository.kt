package tugas.pmobile.banksampahrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.model.AccountResponse

interface AccountRepository : JpaRepository<Account, Int> {
    fun findOneByEmailAndPassword(email: String?, password: String?): AccountResponse?

    fun existsByEmail(email: String?): Boolean?
}