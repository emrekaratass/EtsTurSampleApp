package com.example.etstursampleapp.util.extension

fun String?.ignoreNull(defaultValue: String = ""): String = this ?: defaultValue
