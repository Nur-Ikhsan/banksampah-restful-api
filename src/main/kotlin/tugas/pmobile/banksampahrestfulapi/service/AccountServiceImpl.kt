package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.model.AccountResponse
import tugas.pmobile.banksampahrestfulapi.model.CreateAccountRequest
import tugas.pmobile.banksampahrestfulapi.repository.AccountRepository
import tugas.pmobile.banksampahrestfulapi.validation.ValidationUtil

@Service
class AccountServiceImpl(
    val accountRepository: AccountRepository,
    val validationUtil: ValidationUtil
    ): AccountService {
    override fun create(createAccountRequest: CreateAccountRequest): AccountResponse {
        validationUtil.validate(createAccountRequest)

        val account = Account(
            id = createAccountRequest.id,
            name = createAccountRequest.name!!,
            email = createAccountRequest.email!!,
            address = createAccountRequest.address!!,
            phoneNumber = createAccountRequest.phoneNumber!!,
            password = createAccountRequest.password!!
        )

        accountRepository.save(account)

        return AccountResponse(
            id = account.id,
            name = account.name,
            email = account.email,
            address = account.address,
            phoneNumber = account.phoneNumber,
            password = account.password
        )
    }
}