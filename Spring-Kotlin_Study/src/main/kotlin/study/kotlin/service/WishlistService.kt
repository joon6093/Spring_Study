package study.kotlin.service

import org.springframework.stereotype.Service
import study.kotlin.model.Item
import study.kotlin.repository.WishlistRepository

@Service
class WishlistService(
    private val repository: WishlistRepository
) {
    fun getAllItems(): List<Item> = repository.findAll()
}
