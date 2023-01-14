package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.CreateStoringTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.StoringTrashResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateStoringTrashRequest

interface StoringTrashService {
    fun getStoringTrashById(id: Int): StoringTrashResponse
    fun getStoringTrashByAccountId(id: Int): List<StoringTrashResponse>
    fun createStoringTrash(createStoringTrashRequest: CreateStoringTrashRequest): StoringTrashResponse
    fun updateStoringTrash(id: Int, updateStoringTrashRequest: UpdateStoringTrashRequest): StoringTrashResponse
    fun deleteStoringTrash(id: Int)
}