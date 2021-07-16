package com.zkdlu.todo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Todo(content: String) {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null
                private set
        var content: String = content
                private set
        var done: Boolean = false
                private set

        fun end() : Unit {
                done = true
        }
}