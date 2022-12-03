package net.porodnov.kotlin.system

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.Getter
import lombok.Setter
import javax.persistence.*

@Entity
@Table(name = "bankaccount")
data class BankAccount(
    @JsonProperty("bankcode")
    @Column(name = "bankcode")
    var bankCode: String,

    @JsonProperty("accountnumber")
    @Column(name = "accountnumber")
    var accountNumber: String,

    @JsonProperty("accountholdername")
    @Column(name = "accountholdername")
    var accountHolderName: String,

    @Id @GeneratedValue
    var id: Long? = null
)
