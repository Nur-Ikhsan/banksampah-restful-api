package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.*
import tugas.pmobile.banksampahrestfulapi.model.CreateStoringTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.StoringTrashResponse
import tugas.pmobile.banksampahrestfulapi.model.UpdateStoringTrashRequest
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
import tugas.pmobile.banksampahrestfulapi.service.StoringTrashService

@RestController
@RequestMapping("/api")
class StoringTrashController(
    val storingTrashService: StoringTrashService
) {
    @GetMapping(
        value = ["/storing-trash/{id}"],
        produces = ["application/json"]
    )
    fun getStoringTrashById(@PathVariable id: Int): WebResponse<StoringTrashResponse> {
        val storingTrashResponse = storingTrashService.getStoringTrashById(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = storingTrashResponse
        )
    }

    @GetMapping(
        value = ["/storing-trash/account/{accountId}"],
        produces = ["application/json"]
    )
    fun getStoringTrashByAccountId(@PathVariable accountId: Int): WebResponse<List<StoringTrashResponse>> {
        val storingTrashResponse = storingTrashService.getStoringTrashByAccountId(accountId)

        return WebResponse(
            code = 200,
            status = "OK",
            data = storingTrashResponse
        )
    }

    @PostMapping(
        value = ["/storing-trash"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createStoringTrash(@RequestBody body: CreateStoringTrashRequest): WebResponse<StoringTrashResponse> {
        val storingTrashResponse = storingTrashService.createStoringTrash(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = storingTrashResponse
        )
    }

    @PutMapping(
        value = ["/storing-trash/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateStoringTrash(@PathVariable id: Int,
                           @RequestBody body: UpdateStoringTrashRequest): WebResponse<StoringTrashResponse> {
        val storingTrashResponse = storingTrashService.updateStoringTrash(id, body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = storingTrashResponse
        )
    }

    @DeleteMapping(
        value = ["/storing-trash/{id}"],
        produces = ["application/json"]
    )
    fun deleteStoringTrash(@PathVariable id: Int): WebResponse<Int> {
        storingTrashService.deleteStoringTrash(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }
}