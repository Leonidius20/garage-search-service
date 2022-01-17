package ua.leonidius.garagesearchservice.presentation

data class SearchReturnResult(
    val results: MutableList<CarDetailReturnResult>,
): ReturnResult

data class CarDetailReturnResult(
    val id: Int,
    val price: Double,
    val name: String,
    val description: String?,
    val manufacturer: String,
    val type: String?,
)