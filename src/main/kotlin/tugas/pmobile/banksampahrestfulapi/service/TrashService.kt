package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.CreateTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse

interface TrashService {

    fun create(createTrashRequest: CreateTrashRequest): TrashResponse
}