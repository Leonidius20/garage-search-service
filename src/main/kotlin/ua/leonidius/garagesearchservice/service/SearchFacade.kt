package ua.leonidius.garagesearchservice.service

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult
import ua.leonidius.garagesearchservice.service.specifications.Specification

interface SearchFacade {

    fun findDetailsByNameWithFilter(
        name: String, filter: Specification<CarDetailReturnResult>): SearchReturnResult

}