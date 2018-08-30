package com.happenslol.petshop.petshopapi

import java.util.*

fun <T> Optional<T>.orNull(): T? = this.orElse(null)
