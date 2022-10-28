package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Trash
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.CreateTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.ListTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateTrashRequest
import tugas.pmobile.banksampahrestfulapi.repository.TrashRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil
import java.util.stream.Collectors

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

        return convertTrashToTrashResponse(trash)
    }

    override fun get(id: Int): TrashResponse {
        val trash = findTrashByIdOrThrowNotFound(id)

        return convertTrashToTrashResponse(trash)
    }

    private fun convertTrashToTrashResponse(trash: Trash): TrashResponse {
        return  TrashResponse(
            id = trash.id,
            name = trash.name,
            price = trash.price,
            description = trash.description
        )
    }

    override fun update(id: Int, updateTrashRequest: UpdateTrashRequest): TrashResponse {
        validationUtil.validate(updateTrashRequest)

        val trash = findTrashByIdOrThrowNotFound(id)

        trash.apply {
            name = updateTrashRequest.name!!
            price = updateTrashRequest.price!!
            description = updateTrashRequest.description!!
        }

        trashRepository.save(trash)

        return convertTrashToTrashResponse(trash)
    }

    override fun delete(id: Int) {
        val trash = findTrashByIdOrThrowNotFound(id)
        trashRepository.delete(trash)
    }

    private fun findTrashByIdOrThrowNotFound(id: Int): Trash {
        return trashRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    override fun list(listTrashRequest: ListTrashRequest): List<TrashResponse> {
        val page = trashRepository.findAll(PageRequest.of(listTrashRequest.page, listTrashRequest.size))
        val trash : List<Trash> = page.get().collect(Collectors.toList())

        return trash.map { convertTrashToTrashResponse(it) }
    }
}