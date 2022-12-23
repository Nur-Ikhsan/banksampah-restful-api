package tugas.pmobile.banksampahrestfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository
import tugas.pmobile.banksampahrestfulapi.entity.TrashImage

interface TrashImageRepository : JpaRepository<TrashImage, Int> {
}