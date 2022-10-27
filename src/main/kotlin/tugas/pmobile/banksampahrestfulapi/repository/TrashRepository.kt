package tugas.pmobile.banksampahrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.Trash

interface TrashRepository : JpaRepository<Trash, Int>{

}