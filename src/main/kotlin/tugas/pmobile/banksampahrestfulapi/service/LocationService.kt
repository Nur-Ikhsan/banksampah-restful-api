package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.LocationResponse

interface LocationService {

    fun create(createLocationRequest: CreateLocationRequest): LocationResponse
}