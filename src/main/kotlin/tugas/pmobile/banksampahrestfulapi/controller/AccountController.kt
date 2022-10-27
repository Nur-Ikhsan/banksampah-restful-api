package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tugas.pmobile.banksampahrestfulapi.model.AccountResponse
import tugas.pmobile.banksampahrestfulapi.model.CreateAccountRequest
import tugas.pmobile.banksampahrestfulapi.model.WebResponse
import tugas.pmobile.banksampahrestfulapi.service.AccountService

@RestController
class AccountController(val accountService: AccountService) {

    @PostMapping(
        value = ["/api/accounts"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createAccount(@RequestBody body: CreateAccountRequest): WebResponse<AccountResponse> {
        val accountResponse = accountService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = accountResponse
        )
    }
}