package tugas.pmobile.banksampahrestfulapi.service

import tugas.pmobile.banksampahrestfulapi.model.AccountResponse
import tugas.pmobile.banksampahrestfulapi.model.CreateAccountRequest

interface AccountService {

    fun create(createAccountRequest: CreateAccountRequest) : AccountResponse
}