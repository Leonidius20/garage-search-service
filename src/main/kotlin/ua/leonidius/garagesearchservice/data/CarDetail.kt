package ua.leonidius.garagesearchservice.data

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "car_details")
class CarDetail(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    var carTypeId: Int,

    var detailTypeId: Int?,

    var detailTypeCustomName: String?,

    var manufacturer: String,

    var description: String?,

    var price: Double,

    var name: String,

)