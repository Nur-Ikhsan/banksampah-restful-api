package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import tugas.pmobile.banksampahrestfulapi.error.DuplicateEmailException
import tugas.pmobile.banksampahrestfulapi.error.ErrorSavingUploadedFileException
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "NOT FOUND",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [DuplicateEmailException::class])
    fun duplicateEmail(duplicateEmailException: DuplicateEmailException): WebResponse<String>{
        return WebResponse(
            code = 409,
            status = "DUPLICATE EMAIL",
            data = "Duplicate Email"
        )
    }

    @ExceptionHandler(value = [ErrorSavingUploadedFileException::class])
    fun errorSavingUploadedFile(errorSavingUploadedFileException: ErrorSavingUploadedFileException): WebResponse<String>{
        return WebResponse(
            code = 469,
            status = "ERROR SAVING UPLOADED FILE",
            data = "Error Saving Uploaded File"
        )
    }

}