package com.zkdlu.todo

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(TodoApi::class)
class TodoApiTest(@Autowired val mockMvc: MockMvc) {
    @Test
    fun getContents() {
        /* when */
        mockMvc.perform(MockMvcRequestBuilders.get("/todo/"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("Hello Todo"))
    }
}

