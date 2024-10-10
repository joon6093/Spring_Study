package study.kotlin.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import study.kotlin.service.SongService

@Controller
class SongController(val service: SongService) {

    @GetMapping("/song/random")
    fun getRandomSong(model: Model): String {
        model.addAttribute("songTitle", service.getRandomSong().title)
        return "random"
    }
}
