package net.porodnov.kotlin.system

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity // Указывает на то что этот класс описывает модель данных
@Table(name = "product") // Говорим как назвать таблицу в БД
data class Product( // Дата класс нам сгенерирует методы equals и hashCode и даст метод copy
    @JsonProperty("productName") // Говорим как будет называться свойство в JSON объекте
    @Column(name = "productname", length = 200) // Говорим как будет называться поле в БД и задаем его длину
    val productName: String = "", // Объявляем неизменяемое свойство (геттер, а также поле для него будут сгенерированы автоматически) name, с пустой строкой в качестве значения по умолчанию

    @JsonProperty("description")
    @Column(name = "description", length = 100)
    val description: String = "",

    @Id // Сообщяем ORM что это поле - Primary Key
    @JsonProperty("id")
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) // Также говорим ему что оно - Autoincrement
    val id: Long = 0L
)
