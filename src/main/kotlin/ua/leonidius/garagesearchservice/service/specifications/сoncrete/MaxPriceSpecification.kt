package ua.leonidius.garagesearchservice.service.specifications.сoncrete

import ua.leonidius.garagesearchservice.presentation.CarDetailReturnResult
import ua.leonidius.garagesearchservice.service.specifications.CompositeSpecification

class MaxPriceSpecification(private val maxPrice: Double): CompositeSpecification<CarDetailReturnResult>() {

    override fun isSatisfiedBy(entity: CarDetailReturnResult): Boolean {
        return entity.price <= maxPrice
    }

}