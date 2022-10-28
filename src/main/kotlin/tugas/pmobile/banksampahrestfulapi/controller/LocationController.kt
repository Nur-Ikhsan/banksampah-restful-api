package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.*
import tugas.pmobile.banksampahrestfulapi.model.*
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

    @GetMapping(
        value = ["/api/locations/{id_location}"],
        produces = ["application/json"],
    )
    fun getLocation(@PathVariable("id_location") id: Int): WebResponse<LocationResponse> {
        val locationResponse = locationService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = locationResponse
        )
    }

    @PutMapping(
        value = ["/api/locations/{id_location}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateLocation(@PathVariable("id_location") id: Int, @RequestBody body: UpdateLocationRequest): WebResponse<LocationResponse>{
        val locationResponse = locationService.update(id, body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = locationResponse
        )
    }

    @DeleteMapping(
        value = ["/api/locations/{id_location}"],
        produces = ["application/json"]
    )
    fun deleteLocation(@PathVariable("id_location") id: Int): WebResponse<Int> {
        locationService.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/locations"],
        produces = ["application/json"],
    )
    fun listLocation(@RequestParam(value = "size", defaultValue = "100") size: Int,
                     @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<LocationResponse>> {
        val request = ListLocationRequest(size, page)
        val response = locationService.list(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }

}