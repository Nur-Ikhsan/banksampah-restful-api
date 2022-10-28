package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.ListLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.LocationResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateLocationRequest

interface LocationService {

    fun create(createLocationRequest: CreateLocationRequest): LocationResponse

    fun get(id: Int): LocationResponse

    fun update(id: Int, updateLocationRequest: UpdateLocationRequest): LocationResponse

    fun delete(id: Int)

    fun list(listLocationRequest: ListLocationRequest): List<LocationResponse>
}