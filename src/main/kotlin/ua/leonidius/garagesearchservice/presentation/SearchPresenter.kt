package ua.leonidius.garagesearchservice.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ua.leonidius.garagesearchservice.data.CarDetailRepository
import ua.leonidius.garagesearchservice.service.SearchFacade
import ua.leonidius.garagesearchservice.service.specifications.Specification
import ua.leonidius.garagesearchservice.service.specifications.TrueSpecification
import ua.leonidius.garagesearchservice.service.specifications.сoncrete.ManufacturerSpecification
import ua.leonidius.garagesearchservice.service.specifications.сoncrete.MaxPriceSpecification
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

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

    @GetMapping("/delete/{id}")
    fun deleteDetail(@PathVariable id: Int): Boolean {
        return searchFacade.deleteDetail(id)
    }

    @GetMapping("/modify/{id}")
    fun modifyDetail(
        @PathVariable id: Int,
        @RequestParam(required = false) name: String?,
        @RequestParam(required = false) manufacturer: String?,
        @RequestParam(required = false) description: String?,
        @RequestParam(required = false) type: String?,
        @RequestParam(required = false) price: Float?
    ): CarDetailReturnResult? {

        return searchFacade.modifyDetail(id,
            if (name != null) URLDecoder.decode(name, StandardCharsets.UTF_8.toString()) else null,
            if (manufacturer != null) URLDecoder.decode(manufacturer, StandardCharsets.UTF_8.toString()) else null,
            if (description != null) URLDecoder.decode(description, StandardCharsets.UTF_8.toString()) else null,
            if (type != null) URLDecoder.decode(type, StandardCharsets.UTF_8.toString()) else null,
            price)
    }

}