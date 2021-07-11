package com.zkdlu.todo

import org.springframework.stereotype.Service

@Service
class TodoServiceImpl : TodoService {
    override fun getTodos(): List<TodoResponse> {
        TODO("Not yet implemented")
    }

    override fun saveTodo(todoRequest: TodoRequest): TodoResponse {
        TODO("Not yet implemented")
    }

    override fun deleteTodo(id: Long) {
        TODO("Not yet implemented")
    }
}
