package com.zkdlu.todo

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.BeforeEach

internal class TodoServiceImplTest(
) {
    lateinit var todoService: TodoServiceImpl
    lateinit var spyTodoRepository: SpyTodoRepository

    @BeforeEach
    internal fun setUp() {
        spyTodoRepository = SpyTodoRepository()
        todoService = TodoServiceImpl(spyTodoRepository)
    }

    @Test
    fun getTodos() {
        //given
        val givenTodos: MutableList<Todo> = mutableListOf(Todo(1L, "할 일 1"))
        val expectedTodoResponses: List<TodoResponse> = listOf(TodoResponse(1L, "할 일 1"))

        //when
        spyTodoRepository.findAll_returnValue = givenTodos
        val todoResponses = todoService.getTodos();

        //then
        assertThat(todoResponses).isEqualTo(expectedTodoResponses)
    }

    @Test
    fun saveTodo() {
        //given
        val givenTodoRequest = TodoRequest("할 일 1")

        //when
        val todoResponse = todoService.saveTodo(givenTodoRequest)

        //then
        assertThat(spyTodoRepository.save_wasCalled).isTrue()
        assertThat(todoResponse).isEqualTo(TodoResponse(null, "할 일 1"))
    }

    @Test
    fun deleteTodo() {
        //given
        //when
        todoService.deleteTodo(1L)

        //then
        assertThat(spyTodoRepository.deleteById_wasCalled).isTrue()
    }
}