package study.kotlin.repository

import org.springframework.stereotype.Repository
import study.kotlin.model.Item

@Repository
class InMemoryWishlistRepository : WishlistRepository {
    private val items = mutableListOf<Item>()
    private var currentId = 1L

    init {
        items.add(Item(currentId++, "카카오 프렌즈 리틀 어피치 프라모델", 6_000))
        items.add(Item(currentId++, "카카오 프렌즈 라이온 프라모델", 6_000))
        items.add(Item(currentId++, "건프라군 DX 세트", 9_000))
        items.add(Item(currentId++, "퍼스트 건담 EG", 8_400))
        items.add(Item(currentId++, "퍼스트 건담 RG 2.0", 38_500))
    }

    override fun findAll(): List<Item> = items
}
