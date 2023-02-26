package com.example.etstursampleapp.util.extension

fun Double?.ignoreNull(defaultValue: Double = 0.0): Double = this ?: defaultValue
