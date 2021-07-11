package com.zkdlu.todo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoApi(private val todoService: TodoService) {
    @GetMapping("/test")
    fun readTodo(): String = "Hello Todo";

    @GetMapping
    fun getTodos(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity.ok(todoService.getTodos())
    }

    @PostMapping
    fun saveTodo(@RequestBody todoRequest: TodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.saveTodo(todoRequest))
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: Long): ResponseEntity<Void> {
        todoService.deleteTodo(id)
        return ResponseEntity.noContent().build()
    }
}