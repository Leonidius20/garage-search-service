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

    // maybe get 1 detial by ID From cache

    @GetMapping("/details")
    fun get5000Details(@RequestParam page: Int): SearchReturnResult {
        return searchFacade.getDetailsPaged(page)
    }

    @GetMapping("/num-pages")
    fun getNumberOfPages(): Long {
        return searchFacade.getNumberOfPages()
    }

}