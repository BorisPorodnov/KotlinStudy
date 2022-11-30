package net.porodnov.kotlin.service

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import net.porodnov.kotlin.system.BankAccountRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class BankAccountServiceTest {
    val bankAccountRepository: BankAccountRepository = mockk()
    val bankAccountService = BankAccountService(bankAccountRepository)

    @Test
    fun whenGetBankAccount_thenReturnBankAccount() {
        //given
        val bankAccount = null
        every {
            bankAccountRepository.findByIdOrNull(1)
        } returns bankAccount

        //when
        val result = bankAccountService.getBankAccount(1);

        //then
        verify(exactly = 1) { bankAccountRepository.findByIdOrNull(1) };
        assertEquals(bankAccount, result)
    }
}