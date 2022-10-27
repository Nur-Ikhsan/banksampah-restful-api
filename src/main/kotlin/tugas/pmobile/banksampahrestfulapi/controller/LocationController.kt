package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.LocationResponse
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
import tugas.pmobile.banksampahrestfulapi.service.LocationService

@RestController
class LocationController(val locationService: LocationService) {
    @PostMapping(
        value = ["/api/locations"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createLocation(@RequestBody body: CreateLocationRequest): WebResponse<LocationResponse> {
        val locationResponse = locationService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = locationResponse
        )
    }
}