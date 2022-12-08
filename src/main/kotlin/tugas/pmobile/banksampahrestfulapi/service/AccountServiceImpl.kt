package tugas.pmobile.banksampahrestfulapi.service

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import tugas.pmobile.banksampahrestfulapi.entity.Account
import tugas.pmobile.banksampahrestfulapi.error.NotFoundException
import tugas.pmobile.banksampahrestfulapi.model.AccountResponse
import tugas.pmobile.banksampahrestfulapi.model.CreateAccountRequest
import tugas.pmobile.banksampahrestfulapi.model.UpdateAccountRequest
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

        return convertAccountToAccountResponse(account)
    }

    override fun get(id: Int): AccountResponse {
        val account = findAccountByIdOrThrowNotFound(id)

        return convertAccountToAccountResponse(account)
    }

    private fun convertAccountToAccountResponse(account: Account): AccountResponse {
        return AccountResponse(
            id = account.id,
            name = account.name,
            email = account.email,
            address = account.address,
            phoneNumber = account.phoneNumber,
            password = account.password
        )
    }

    override fun update(id: Int, updateAccountRequest: UpdateAccountRequest): AccountResponse {
        validationUtil.validate(updateAccountRequest)

        val account = findAccountByIdOrThrowNotFound(id)

        account.apply {
            name = updateAccountRequest.name!!
            email = updateAccountRequest.email!!
            address = updateAccountRequest.address!!
            phoneNumber = updateAccountRequest.phoneNumber!!
            password = updateAccountRequest.password!!
        }

        accountRepository.save(account)

        return convertAccountToAccountResponse(account)
    }

    override fun delete(id: Int) {
        val account = accountRepository.findByIdOrNull(id) ?: throw NotFoundException()
        accountRepository.delete(account)
    }

    private fun findAccountByIdOrThrowNotFound(id: Int): Account {
        return accountRepository.findByIdOrNull(id) ?: throw NotFoundException()
    }
}