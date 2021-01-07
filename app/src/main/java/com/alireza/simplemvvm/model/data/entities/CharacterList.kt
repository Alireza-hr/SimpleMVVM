package com.alireza.simplemvvm.model.data.entities

data class CharacterList(
    val results: List<Character>,
    val info: Info
)

data class Info(
    val next: String,
    val count: Int,
    val pages: Int,
    val prev: Any
)