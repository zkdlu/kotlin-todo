package com.zkdlu.todo

import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(private val todoRepository: TodoRepository
) : TodoService {
    override fun getTodos(): List<TodoResponse> {
        val todo = Todo(content = "test")

        val todos = todoRepository.findAll()
        return todos.map { t -> TodoResponse(
                id = t.id,
                content = t.content
        ) }
    }

    override fun saveTodo(todoRequest: TodoRequest): TodoResponse {
        val todo: Todo = Todo(content = todoRequest.content)
        todoRepository.save(todo)
        return TodoResponse(id = todo.id, content = todo.content)
    }

    override fun deleteTodo(id: Long) {
        todoRepository.deleteById(id)
    }
}
