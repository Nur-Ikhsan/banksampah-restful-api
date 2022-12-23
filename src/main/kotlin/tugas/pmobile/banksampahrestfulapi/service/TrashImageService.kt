package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.core.io.Resource
import org.springframework.web.multipart.MultipartFile
import tugas.pmobile.banksampahrestfulapi.model.ImageResponse

interface TrashImageService {
    fun upload(multipartFile: MultipartFile): ImageResponse
    fun download(id : Int): Pair<Resource, String>
}
