package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import tugas.pmobile.banksampahrestfulapi.entity.TrashImage
import tugas.pmobile.banksampahrestfulapi.error.ErrorSavingUploadedFileException
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.ImageResponse
import tugas.pmobile.banksampahrestfulapi.repository.TrashImageRepository
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardCopyOption
import java.util.UUID

@Service
class TrashImageServiceImpl(
    val trashImageRepository: TrashImageRepository
) : TrashImageService {
    val uploadDirectory = Paths.get("File-Upload/TrashImage")
    override fun upload(multipartFile: MultipartFile): ImageResponse {
        if (multipartFile == null || multipartFile.contentType?.split("/")?.get(0).toString() != "image") {
            throw ErrorSavingUploadedFileException()
        }
        val uuidName = UUID.randomUUID().toString() + "." + (multipartFile.contentType?.split("/")?.get(1)
            ?: throw ErrorSavingUploadedFileException())

        try {
            val inputStream = multipartFile.inputStream
            val filePath = uploadDirectory.resolve(uuidName)
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING)
        } catch (e: ErrorSavingUploadedFileException) {
            throw e
        }

        val trashImage = TrashImage(
            id = null,
            name = uuidName,
            size = multipartFile.size,
            type = multipartFile.contentType.toString()
        )

        trashImageRepository.save(trashImage)

        return ImageResponse(
            id = trashImage.id!!,
            name = trashImage.name,
            size = trashImage.size,
            type = trashImage.type
        )
    }

    override fun download(id: Int): Pair<Resource, String> {
        val trashImage = trashImageRepository.findByIdOrNull(id) ?: throw NotFoundException()
        val uuidName = trashImage.name
        println("uuidName : $uuidName")
        val type = trashImage.type
        val filePath = uploadDirectory.resolve(uuidName)
        val resource = UrlResource(filePath.toUri())
        return Pair(resource, type)
    }
}