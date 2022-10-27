package tugas.pmobile.banksampahrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.Account

interface AccountRepository : JpaRepository<Account, Int> {

}