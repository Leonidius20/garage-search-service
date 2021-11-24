package ua.leonidius.garagesearchservice.service

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

class MinLengthValidator(private val minLength: Int): BaseHandler() {

    override fun handleSearchQuery(query: String, resultSet: MutableList<CarDetailReturnResult>): SearchReturnResult {
        if (query.length < minLength)
            throw IllegalArgumentException("The search query should be at least $minLength symbols long")
        else return getNext()?.handleSearchQuery(query, resultSet) ?: throw Exception("No handler after validator")
    }

}