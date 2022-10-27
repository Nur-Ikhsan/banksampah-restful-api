package tugas.pmobile.banksampahrestfulapi.repository

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.Location

interface LocationRepository : JpaRepository<Location, Int> {

}