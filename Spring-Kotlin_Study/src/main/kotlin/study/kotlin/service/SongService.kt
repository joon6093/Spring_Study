package study.kotlin.service

import org.springframework.stereotype.Service
import study.kotlin.repository.SongRepository
import kotlin.random.Random

@Service
class SongService(val repository: SongRepository) {
    fun getRandomSong() = repository.getSong(Random.nextInt(repository.songsSize))
    fun getAllSongs() = repository.fetchSong()
}
