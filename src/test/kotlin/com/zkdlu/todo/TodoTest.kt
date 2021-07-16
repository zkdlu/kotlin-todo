package com.zkdlu.todo

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TodoTest {
    @Test
    internal fun todo_isDone() {
        val todo:Todo = Todo(content = "할 일1")

        assertThat(todo.done).isFalse()
        todo.end()
        assertThat(todo.done).isTrue()
    }
}