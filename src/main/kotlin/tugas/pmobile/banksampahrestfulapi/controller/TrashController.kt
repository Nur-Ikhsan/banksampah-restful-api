package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.*
import tugas.pmobile.banksampahrestfulapi.model.*
import tugas.pmobile.banksampahrestfulapi.service.TrashService

@RestController
class TrashController(val trashService: TrashService) {
    @PostMapping(
        value = ["/api/trash"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createTrash(@RequestBody body: CreateTrashRequest): WebResponse<TrashResponse>{
        val trashResponse = trashService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = trashResponse
        )
    }

    @GetMapping(
        value = ["/api/trash/{id_trash}"],
        produces = ["application/json"],
    )
    fun getTrash(@PathVariable("id_trash") id: Int): WebResponse<TrashResponse> {
        val trashResponse = trashService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = trashResponse
        )
    }

    @PutMapping(
        value = ["/api/trash/{id_trash}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateTrash(@PathVariable("id_trash") id: Int,
                    @RequestBody body: UpdateTrashRequest): WebResponse<TrashResponse>{
        val trashResponse = trashService.update(id, body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = trashResponse
        )
    }

    @DeleteMapping(
        value = ["/api/trash/{id_trash}"],
        produces = ["application/json"]
    )
    fun deleteLocation(@PathVariable("id_trash") id: Int): WebResponse<Int> {
        trashService.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/trash"],
        produces = ["application/json"],
    )
    fun listTrash(@RequestParam(value = "size", defaultValue = "100") size: Int,
                  @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<TrashResponse>> {
        val request = ListTrashRequest(size, page)
        val response = trashService.list(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}