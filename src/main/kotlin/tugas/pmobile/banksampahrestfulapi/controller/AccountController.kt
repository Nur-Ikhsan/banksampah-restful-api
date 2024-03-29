package tugas.pmobile.banksampahrestfulapi.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import tugas.pmobile.banksampahrestfulapi.model.*
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

    @GetMapping(
        value = ["/api/accounts/{id_account}"],
        produces = ["application/json"],
    )
    fun getAccount(@PathVariable("id_account") id: Int): WebResponse<AccountResponse> {
        val accountResponse = accountService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = accountResponse
        )
    }

    @PutMapping(
        value = ["/api/accounts/{id_account}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateAccount(@PathVariable("id_account") id: Int,
                      @RequestBody body: UpdateAccountRequest): WebResponse<AccountResponse> {
        val accountResponse = accountService.update(id, body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = accountResponse
        )
    }

    @DeleteMapping(
        value = ["/api/accounts/{id_account}"],
        produces = ["application/json"]
    )
    fun deleteAccount(@PathVariable("id_account") id: Int): WebResponse<Int> {
        accountService.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @PostMapping(
        value = ["/api/login"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun login(@RequestBody body: LoginRequest): WebResponse<AccountResponse> {
        val accountResponse = accountService.login(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = accountResponse
        )
    }

    @PostMapping(
        value = ["/api/signup"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun signUp(@RequestBody body: SignUpRequest): WebResponse<String> {
        accountService.signUp(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = "Berhasil"
        )
    }
}