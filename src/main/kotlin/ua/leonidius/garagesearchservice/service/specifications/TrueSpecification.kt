package ua.leonidius.garagesearchservice.service.specifications

class TrueSpecification<T>: CompositeSpecification<T>() {

    override fun isSatisfiedBy(entity: T) = true

}