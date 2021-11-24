package ua.leonidius.garagesearchservice.service

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

interface RequestHandler {

    fun handleSearchQuery(query: String, resultSet: MutableList<CarDetailReturnResult>): SearchReturnResult

    fun getNext(): RequestHandler?

    fun setNext(handler: RequestHandler)

}