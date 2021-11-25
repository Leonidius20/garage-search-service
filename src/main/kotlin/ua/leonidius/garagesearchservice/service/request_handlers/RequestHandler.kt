package ua.leonidius.garagesearchservice.service.request_handlers

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

interface RequestHandler {

    fun handleSearchQuery(query: String): SearchReturnResult

    fun getNext(): RequestHandler?

    fun setNext(handler: RequestHandler)

}