package com.zkdlu.todo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/todo")
class TodoApi {
    @GetMapping("/")
    fun readTodo(): String = "Hello Todo";

}