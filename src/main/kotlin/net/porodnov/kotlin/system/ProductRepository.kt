package net.porodnov.kotlin.system

import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long> { // Дает нашему слою работы с данными весь набор CRUD операций
}