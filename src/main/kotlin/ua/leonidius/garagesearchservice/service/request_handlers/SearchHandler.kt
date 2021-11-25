package ua.leonidius.garagesearchservice.service.request_handlers

import ua.leonidius.garagesearchservice.data.CarDetailRepository
import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

class SearchHandler(private val repository: CarDetailRepository): BaseHandler() {

    override fun handleSearchQuery(query: String): SearchReturnResult {
        val resultSet = repository.findByNameContainingIgnoreCase(query).map {
            CarDetailReturnResult(it.id!!, it.price, it.name, it.description, it.manufacturer)
        }.toMutableList()
        return getNext()?.handleSearchQuery(query) ?: SearchReturnResult(resultSet)
    }

}