package ua.leonidius.garagesearchservice.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarDetailRepository: JpaRepository<CarDetail, Int> {

    fun findByNameContainingIgnoreCase(query: String): List<CarDetail>

}