package ua.leonidius.garagesearchservice.service.specifications.сoncrete

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.service.specifications.CompositeSpecification

class ManufacturerSpecification(private val manufacturer: String):
    CompositeSpecification<CarDetailReturnResult>() {

    override fun isSatisfiedBy(entity: CarDetailReturnResult): Boolean {
        return entity.manufacturer.equals(manufacturer, ignoreCase = true)
    }

}