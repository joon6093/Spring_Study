package study.kotlin.repository

import study.kotlin.model.Item

interface WishlistRepository {
    fun findAll(): List<Item>
}
