package tugas.pmobile.banksampahrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.entity.StoringTrash

interface StoringTrashRepository : JpaRepository<StoringTrash, Int> {
    fun findByAccountIdOrderByCreatedAtDesc(accountId: Account): List<StoringTrash>
}