package ua.leonidius.garagesearchservice.service

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

class PriceFilter(private val maxPrice: Double): BaseHandler() {

    override fun handleSearchQuery(query: String, resultSet: MutableList<CarDetailReturnResult>): SearchReturnResult {
        val newResultSet = resultSet.filter { it.price <= maxPrice }.toMutableList()
        return getNext()?.handleSearchQuery(query, newResultSet) ?: SearchReturnResult(newResultSet)
    }

}