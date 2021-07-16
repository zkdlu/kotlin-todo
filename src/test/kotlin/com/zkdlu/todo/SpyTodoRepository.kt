package com.zkdlu.todo

import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import java.util.*

class SpyTodoRepository : TodoRepository {
    var deleteById_wasCalled: Boolean = false
    var save_wasCalled: Boolean = false
    lateinit var findAll_returnValue: MutableList<Todo>

    override fun <S : Todo?> save(entity: S): S {
        save_wasCalled = true
        return entity
    }

    override fun <S : Todo?> saveAll(entities: MutableIterable<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        return findAll_returnValue
    }

    override fun findAll(sort: Sort): MutableList<Todo> {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> findAll(example: Example<S>): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> findAll(example: Example<S>, sort: Sort): MutableList<S> {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<Todo> {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> findAll(example: Example<S>, pageable: Pageable): Page<S> {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableList<Todo> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> count(example: Example<S>): Long {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Todo) {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Todo>) {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> findOne(example: Example<S>): Optional<S> {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> exists(example: Example<S>): Boolean {
        TODO("Not yet implemented")
    }

    override fun flush() {
        TODO("Not yet implemented")
    }

    override fun <S : Todo?> saveAndFlush(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun deleteInBatch(entities: MutableIterable<Todo>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllInBatch() {
        TODO("Not yet implemented")
    }

    override fun getOne(id: Long): Todo {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        deleteById_wasCalled = true
    }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<Todo> {
        TODO("Not yet implemented")
    }

}
