package ua.leonidius.garagesearchservice.service.request_handlers

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

class NotEmptyValidator: BaseHandler() {

    override fun handleSearchQuery(query: String): SearchReturnResult {
       if (query.isEmpty())
           throw IllegalArgumentException("The search query shouldn't be empty")
       else return getNext()?.handleSearchQuery(query) ?: throw Exception("No handler after validator")
    }

}