package ua.leonidius.garagesearchservice.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ua.leonidius.garagesearchservice.service.*
import kotlin.math.max

@RestController
class SearchPresenter(private val searchHandler: SearchHandler) {

    @GetMapping("/details/search")
    fun findDetail(@RequestParam query: String,
                   @RequestParam(required = false) maxPrice: Double?): ReturnResult {
        try {
            val notEmptyValidator = NotEmptyValidator()
            val minLengthValidator = MinLengthValidator(3)
            val illegalCharsValidator = IllegalCharsValidator()

            notEmptyValidator.setNext(minLengthValidator)
            minLengthValidator.setNext(illegalCharsValidator)
            illegalCharsValidator.setNext(searchHandler)

            if (maxPrice != null) {
                val priceFilter = PriceFilter(maxPrice)
                searchHandler.setNext(priceFilter)
            }

            return notEmptyValidator.handleSearchQuery(query,
                emptyList<CarDetailReturnResult>().toMutableList())
        } catch (e: Exception) {
            e.printStackTrace()
            return ErrorReturnResult(e.message!!)
        }
    }

}