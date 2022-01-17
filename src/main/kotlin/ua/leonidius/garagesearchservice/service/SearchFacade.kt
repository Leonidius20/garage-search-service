package ua.leonidius.garagesearchservice.service

import org.springframework.web.bind.annotation.RequestParam
import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult
import ua.leonidius.garagesearchservice.service.specifications.Specification

interface SearchFacade {

    fun findDetailsByNameWithFilter(
        name: String, filter: Specification<CarDetailReturnResult>): SearchReturnResult


    fun getDetailsPaged(page: Int): SearchReturnResult

    fun getNumberOfPages(): Long

    fun deleteDetail(id: Int): Boolean

    fun modifyDetail(id: Int, name: String?,
                      manufacturer: String?,
                      description: String?,
                      type: String?,
                      price: Float?): CarDetailReturnResult?
}