package com.shandorino.domain.model

data class UserModel(
    val id: Int,
    val username: String,
    val photo: String?,
    val lastMessage: String,
    val isReaded: Boolean,
    val newMessageCount: Byte
)
