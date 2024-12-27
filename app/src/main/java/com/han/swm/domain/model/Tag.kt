package com.han.swm.domain.model

data class Tag(
    val id: Int,
    val name: String,
    val description: String,
    val createdDate: Long
)

val tagMock = Tag(
    id = 0,
    name = "Tag 1",
    description = "Test tag",
    createdDate = System.currentTimeMillis()
)