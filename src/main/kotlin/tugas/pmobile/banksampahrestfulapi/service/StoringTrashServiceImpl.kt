package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.StoringTrash
import tugas.pmobile.banksampahrestfulapi.entity.StoringTrashStatus
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.CreateStoringTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.StoringTrashResponse
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateStoringTrashRequest
import tugas.pmobile.banksampahrestfulapi.repository.AccountRepository
import tugas.pmobile.banksampahrestfulapi.repository.LocationRepository
import tugas.pmobile.banksampahrestfulapi.repository.StoringTrashRepository
import tugas.pmobile.banksampahrestfulapi.repository.TrashRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil
import java.sql.Timestamp

@Service
class StoringTrashServiceImpl(
    private val storingTrashRepository: StoringTrashRepository,
    private val validationUtil: ValidationUtil,
    private val trashRepository: TrashRepository,
    private val locationRepository: LocationRepository,
    private val accountRepository: AccountRepository
) : StoringTrashService {
    override fun getStoringTrashById(id: Int): StoringTrashResponse {
        val storingTrash = storingTrashRepository.findByIdOrNull(id) ?: throw NotFoundException()
        return convertStoringTrashtoStoringTrashResponse(storingTrash)
    }

    override fun getStoringTrashByAccountId(id: Int): List<StoringTrashResponse> {
        val accountId = accountRepository.findByIdOrNull(id) ?: throw NotFoundException()
        val storingTrash = storingTrashRepository.findByAccountIdOrderByCreatedAtDesc(accountId)
        return storingTrash.map { convertStoringTrashtoStoringTrashResponse(it) }
    }

    override fun createStoringTrash(createStoringTrashRequest: CreateStoringTrashRequest): StoringTrashResponse {
        validationUtil.validate(createStoringTrashRequest)

        val storingTrash = StoringTrash(
            id = createStoringTrashRequest.id,
            accountId = accountRepository.findByIdOrNull(createStoringTrashRequest.accountId!!)!!,
            trashId = trashRepository.findByIdOrNull(createStoringTrashRequest.trashId!!)!!,
            locationId = locationRepository.findByIdOrNull(createStoringTrashRequest.locationId!!)!!,
            weight = createStoringTrashRequest.weight!!,
            total = createStoringTrashRequest.weight!! * trashRepository.findByIdOrNull(createStoringTrashRequest.trashId!!)!!.price,
            createdAt = Timestamp(System.currentTimeMillis()),
            status = StoringTrashStatus.DalamProses
        )

        storingTrashRepository.save(storingTrash)

        return convertStoringTrashtoStoringTrashResponse(storingTrash)
    }

    override fun updateStoringTrash(id: Int, updateStoringTrashRequest: UpdateStoringTrashRequest): StoringTrashResponse {
        validationUtil.validate(updateStoringTrashRequest)

        val storingTrash = storingTrashRepository.findByIdOrNull(id) ?: throw NotFoundException()

        storingTrash.apply {
            weight = updateStoringTrashRequest.weight!!
            total = updateStoringTrashRequest.weight * this.trashId!!.price
            status = updateStoringTrashRequest.status!!
        }

        storingTrashRepository.save(storingTrash)

        return convertStoringTrashtoStoringTrashResponse(storingTrash)
    }

    override fun deleteStoringTrash(id: Int) {
        val storingTrash = storingTrashRepository.findByIdOrNull(id) ?: throw NotFoundException()
        storingTrashRepository.delete(storingTrash)
    }

    private fun convertStoringTrashtoStoringTrashResponse(storingTrash: StoringTrash): StoringTrashResponse {

        val trashResponse = TrashResponse(
            storingTrash.trashId!!.id,
            storingTrash.trashId!!.name,
            storingTrash.trashId!!.price,
            storingTrash.trashId!!.description,
            storingTrash.trashId!!.trashImage?.id
        )

        return StoringTrashResponse(
            id = storingTrash.id,
            accountId = storingTrash.accountId,
            trashId = trashResponse,
            locationId = storingTrash.locationId,
            weight = storingTrash.weight,
            total = storingTrash.total,
            createdAt = storingTrash.createdAt,
            status = storingTrash.status
        )
    }
}