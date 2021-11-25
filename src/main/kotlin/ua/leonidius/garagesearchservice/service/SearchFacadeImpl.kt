package ua.leonidius.garagesearchservice.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.leonidius.garagesearchservice.data.CarDetailRepository
import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.presentation.SearchReturnResult
import ua.leonidius.garagesearchservice.service.request_handlers.IllegalCharsValidator
import ua.leonidius.garagesearchservice.service.request_handlers.MinLengthValidator
import ua.leonidius.garagesearchservice.service.request_handlers.NotEmptyValidator
import ua.leonidius.garagesearchservice.service.request_handlers.SearchHandler
import ua.leonidius.garagesearchservice.service.specifications.Specification

@Service
class SearchFacadeImpl: SearchFacade {

    @Autowired
    private lateinit var repository: CarDetailRepository

    override fun findDetailsByNameWithFilter(
        name: String, filter: Specification<CarDetailReturnResult>): SearchReturnResult {

        val notEmptyValidator = NotEmptyValidator()
        val minLengthValidator = MinLengthValidator(3)
        val illegalCharsValidator = IllegalCharsValidator()
        val searchHandler = SearchHandler(repository)

        notEmptyValidator.setNext(minLengthValidator)
        minLengthValidator.setNext(illegalCharsValidator)
        illegalCharsValidator.setNext(searchHandler)

        val results = notEmptyValidator.handleSearchQuery(name)

        results.results.retainAll { filter.isSatisfiedBy(it) }
        return results
    }

}