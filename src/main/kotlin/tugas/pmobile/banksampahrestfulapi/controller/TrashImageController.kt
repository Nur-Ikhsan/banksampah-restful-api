package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.core.io.Resource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import tugas.pmobile.banksampahrestfulapi.model.ImageResponse
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
import tugas.pmobile.banksampahrestfulapi.service.TrashImageService

@RestController
class TrashImageController(val trashImageService: TrashImageService) {

    @PostMapping(
        value = ["/api/trash/image"],
        produces = ["application/json"]
    )
    fun upload(@RequestParam("file") multipartFile: MultipartFile): WebResponse<ImageResponse>{
        val imageResponse = trashImageService.upload(multipartFile)

        return WebResponse(
            code = 200,
            status = "OK",
            data = imageResponse
        )
    }

    @GetMapping("/api/trash/image/{id}")
    fun download(@PathVariable("id") id: Int): ResponseEntity<Resource> {
        val (resource, type) = trashImageService.download(id)

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(type)).body(resource)
    }

}