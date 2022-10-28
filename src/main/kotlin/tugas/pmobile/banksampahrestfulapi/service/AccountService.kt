package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.AccountResponse
import tugas.pmobile.banksampahrestfulapi.model.CreateAccountRequest
import tugas.pmobile.banksampahrestfulapi.model.UpdateAccountRequest

interface AccountService {

    fun create(createAccountRequest: CreateAccountRequest) : AccountResponse

    fun get(id: Int): AccountResponse

    fun update(id: Int, updateAccountRequest: UpdateAccountRequest): AccountResponse

    fun delete(id: Int)
}