package study.kotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import study.kotlin.service.WishlistService

@Controller
class WishlistController(
    private val service: WishlistService
) {
    @GetMapping("/wishlist")
    fun getWishlist(data: Model): String {
        val itemList = service.getAllItems()
        data.addAttribute("items", itemList)
        return "wishlist"
    }
}
