package net.porodnov.kotlin.system

import net.porodnov.kotlin.service.BankAccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bankAccount")
class BankController(var bankAccountService: BankAccountService) {
    @GetMapping("/api/v1")
    fun foo(): String {
        return "Hello World"
    }

    @PostMapping
    fun addBankAccount(@RequestBody bankAccount: BankAccount): ResponseEntity<BankAccount> {
        return ResponseEntity.ok(bankAccountService.addBankAccount(bankAccount))
    }

    @GetMapping
    fun getBankAccount(@RequestParam id: Long): ResponseEntity<BankAccount> {
        val bankAccount: BankAccount? = bankAccountService.getBankAccount(id);
        return if (bankAccount != null) {
            ResponseEntity(bankAccount, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.BAD_REQUEST)
        }
    }
}