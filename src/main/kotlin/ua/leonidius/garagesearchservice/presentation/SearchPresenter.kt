package ua.leonidius.garagesearchservice.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ua.leonidius.garagesearchservice.service.SearchFacade
import ua.leonidius.garagesearchservice.service.specifications.Specification
import ua.leonidius.garagesearchservice.service.specifications.TrueSpecification
import ua.leonidius.garagesearchservice.service.specifications.сoncrete.ManufacturerSpecification
import ua.leonidius.garagesearchservice.service.specifications.сoncrete.MaxPriceSpecification

@RestController
class SearchPresenter(private val searchFacade: SearchFacade) {

    @GetMapping("/details/search")
    fun findDetail(@RequestParam query: String,
                   @RequestParam(required = false) maxPrice: Double?,
                   @RequestParam(required = false) minPrice: Double?,
                   @RequestParam(required = false) manufacturer: String?): ReturnResult {
        try {
            var filter: Specification<CarDetailReturnResult> = TrueSpecification()

            if (maxPrice != null)
                filter = filter.and(MaxPriceSpecification(maxPrice))

            if (minPrice != null)
                filter = filter.and(MaxPriceSpecification(minPrice).not())

            if (manufacturer != null)
                filter = filter.and(ManufacturerSpecification(manufacturer))

            return searchFacade.findDetailsByNameWithFilter(query, filter)
        } catch (e: Exception) {
            e.printStackTrace()
            return ErrorReturnResult(e.message!!)
        }
    }

}