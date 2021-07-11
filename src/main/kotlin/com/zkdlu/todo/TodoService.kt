package com.zkdlu.todo

interface TodoService {
    fun getTodos(): List<TodoResponse>
    fun saveTodo(todoRequest: TodoRequest): TodoResponse
    fun deleteTodo(id: Long)
}
