package net.porodnov.kotlin.system

import org.checkerframework.checker.nullness.qual.AssertNonNullIfNonNull
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
@AutoConfigureMockMvc
class BankControllerTest() {

    @Autowired
    lateinit var controller: BankController

    @Autowired
    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setup(wac: WebApplicationContext) {
        mockMvc = MockMvcBuilders
            .webAppContextSetup(wac)
            .build()
    }

    @Test
    fun fooTest() {
        AssertNonNullIfNonNull(controller.foo())
        mockMvc.perform(get("/api/bankAccount/api/v1"))
            .andDo { println() }
            .andExpect(status().isOk)
            .andExpect(content().string(containsString("Hello World")))
    }
}