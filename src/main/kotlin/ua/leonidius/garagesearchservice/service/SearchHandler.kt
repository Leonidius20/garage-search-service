package ua.leonidius.garagesearchservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.leonidius.garagesearchservice.data.CarDetailRepository
import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult

@Service
class SearchHandler: BaseHandler(), CarDetailService {

    @Autowired
    private lateinit var repository: CarDetailRepository

    override fun handleSearchQuery(query: String, resultSet: MutableList<CarDetailReturnResult>): SearchReturnResult {
        resultSet.addAll(repository.findByNameContainingIgnoreCase(query).map {
            CarDetailReturnResult(it.id!!, it.price, it.name, it.description)
        })
        return getNext()?.handleSearchQuery(query, resultSet) ?: SearchReturnResult(resultSet)
    }

}