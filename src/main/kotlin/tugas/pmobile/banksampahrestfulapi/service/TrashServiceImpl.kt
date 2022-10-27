package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Trash
import tugas.pmobile.banksampahrestfulapi.model.CreateTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse
import tugas.pmobile.banksampahrestfulapi.repository.TrashRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil

@Service
class TrashServiceImpl(
    val trashRepository: TrashRepository,
    val validationUtil: ValidationUtil
    ): TrashService {
    override fun create(createTrashRequest: CreateTrashRequest): TrashResponse {
        validationUtil.validate(createTrashRequest)

        val trash = Trash(
            id = createTrashRequest.id,
            name = createTrashRequest.name!!,
            price = createTrashRequest.price!!,
            description = createTrashRequest.description!!
        )

        trashRepository.save(trash)

        return TrashResponse(
            id = trash.id,
            name = trash.name,
            price = trash.price,
            description = trash.description
        )
    }
}