package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tugas.pmobile.banksampahrestfulapi.model.CreateLocationRequest
import tugas.pmobile.banksampahrestfulapi.model.CreateTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.TrashResponse
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
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
}