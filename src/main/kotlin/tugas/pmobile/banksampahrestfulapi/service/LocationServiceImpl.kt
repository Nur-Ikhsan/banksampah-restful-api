package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Location
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.ListLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.LocationResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateLocationRequest
import tugas.pmobile.banksampahrestfulapi.repository.LocationRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil
import java.util.stream.Collectors

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
            contacts = createLocationRequest.contacts!!,
            latitude = createLocationRequest.latitude!!,
            longitude = createLocationRequest.longitude!!

        )

        locationRepository.save(location)

        return convertLocationToLocationResponse(location)
    }

    override fun get(id: Int): LocationResponse {
        val location = findLocationByIdOrThrowNotFound(id)

        return convertLocationToLocationResponse(location)
    }

    private fun convertLocationToLocationResponse(location: Location): LocationResponse {
        return  LocationResponse(
            id = location.id,
            name = location.name,
            address = location.address,
            open_time = location.open_time,
            close_time = location.close_time,
            contacts = location.contacts,
            latitude = location.latitude,
            longitude = location.longitude
        )
    }

    override fun update(id: Int, updateLocationRequest: UpdateLocationRequest): LocationResponse {
        validationUtil.validate(updateLocationRequest)

        val location = findLocationByIdOrThrowNotFound(id)

        location.apply {
            name = updateLocationRequest.name!!
            address = updateLocationRequest.address!!
            open_time = updateLocationRequest.open_time!!
            close_time = updateLocationRequest.close_time!!
            contacts = updateLocationRequest.contacts!!
        }

        locationRepository.save(location)

        return convertLocationToLocationResponse(location)
    }

    override fun delete(id: Int) {
        val location = findLocationByIdOrThrowNotFound(id)
        locationRepository.delete(location)
    }

    private fun findLocationByIdOrThrowNotFound(id: Int): Location {
        return locationRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }

    override fun list(listLocationRequest: ListLocationRequest): List<LocationResponse> {
        val page = locationRepository.findAll(PageRequest.of(listLocationRequest.page, listLocationRequest.size))
        val location : List<Location> = page.get().collect(Collectors.toList())

        return location.map { convertLocationToLocationResponse(it) }
    }
}