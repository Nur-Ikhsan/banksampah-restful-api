package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Location
import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.LocationResponse
import tugas.pmobile.banksampahrestfulapi.repository.LocationRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil

@Service
class LocationServiceImpl(
    val locationRepository: LocationRepository,
    val validationUtil: ValidationUtil
    ): LocationService {
    override fun create(createLocationRequest: CreateLocationRequest): LocationResponse {
        validationUtil.validate(createLocationRequest)

        val location = Location(
            id = createLocationRequest.id,
            name = createLocationRequest.name!!,
            address = createLocationRequest.address!!,
            open_time = createLocationRequest.open_time!!,
            close_time = createLocationRequest.close_time!!,
            contacts = createLocationRequest.contacts!!
        )

        locationRepository.save(location)

        return LocationResponse(
            id = location.id,
            name = location.name,
            address = location.address,
            open_time = location.open_time,
            close_time = location.close_time,
            contacts = location.contacts
        )
    }
}