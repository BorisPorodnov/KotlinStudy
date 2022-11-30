package net.porodnov.kotlin.service

import net.porodnov.kotlin.system.BankAccount
import net.porodnov.kotlin.system.BankAccountRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class BankAccountService(var bankAccountRepository: BankAccountRepository) {
    fun addBankAccount(bankAccount: BankAccount): BankAccount {
        return bankAccountRepository.save(bankAccount);
    }
    fun getBankAccount(id: Long): BankAccount? {
        return bankAccountRepository.findByIdOrNull(id)
    }
}