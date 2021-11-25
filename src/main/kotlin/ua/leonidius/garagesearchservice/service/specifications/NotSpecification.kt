package ua.leonidius.garagesearchservice.service.specifications

class NotSpecification<T>(
    private val wrapped: Specification<T>): CompositeSpecification<T>() {

    override fun isSatisfiedBy(entity: T): Boolean {
        return !wrapped.isSatisfiedBy(entity)
    }

}