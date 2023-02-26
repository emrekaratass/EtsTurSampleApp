package com.example.etstursampleapp.util.mapper

@FunctionalInterface
interface Mapper<in T, out R> {
    suspend fun map(item: T): R
}