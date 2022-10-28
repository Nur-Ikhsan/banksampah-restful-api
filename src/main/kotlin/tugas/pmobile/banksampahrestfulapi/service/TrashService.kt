package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.CreateTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.ListTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateTrashRequest

interface TrashService {

    fun create(createTrashRequest: CreateTrashRequest): TrashResponse

    fun get(id: Int): TrashResponse

    fun update(id: Int, updateTrashRequest: UpdateTrashRequest): TrashResponse

    fun delete(id: Int)

    fun list(listTrashRequest: ListTrashRequest): List<TrashResponse>
}