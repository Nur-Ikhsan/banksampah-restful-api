package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.model.*

interface AccountService {

    fun create(createAccountRequest: CreateAccountRequest) : AccountResponse

    fun get(id: Int): AccountResponse

    fun update(id: Int, updateAccountRequest: UpdateAccountRequest): AccountResponse

    fun delete(id: Int)

    fun login(loginRequest: LoginRequest): AccountResponse

    fun signUp(signUpRequest: SignUpRequest)
}