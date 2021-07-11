package com.zkdlu.todo

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoApi::class)
class TodoApiTest(@Autowired private val mockMvc: MockMvc
) {
    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var todoService: TodoService

    @Test
    fun getContents() {
        mockMvc.perform(get("/todos/test"))
                .andExpect(MockMvcResultMatchers.status().isOk)
                .andExpect(MockMvcResultMatchers.content().string("Hello Todo"))
    }

    @Test
    fun `할 일 목록`() {
        val expectedResponse: List<TodoResponse> = listOf(
                TodoResponse(1L, "할 일 1")
        )

        whenever(todoService.getTodos()).thenReturn(expectedResponse)

        mockMvc
                .perform(get("/todos").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().json(objectMapper.writeValueAsString(expectedResponse)))
    }

    @Test
    fun `할 일 등록`() {
        val todoRequest: TodoRequest = TodoRequest("할 일")
        val todoResponse: TodoResponse = TodoResponse(1L, todoRequest.content)

        whenever(todoService.saveTodo(todoRequest)).thenReturn(todoResponse)

        mockMvc.perform(post("/todos").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(todoRequest)))
                .andExpect(status().isCreated)
                .andExpect(content().json(objectMapper.writeValueAsString(todoResponse)))
    }

    @Test
    fun `할 일 삭제`() {
        val id = 1L

        mockMvc.perform(delete("/todos/{id}", id).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent)

        verify(todoService).deleteTodo(id)
    }
}

