package ua.leonidius.garagesearchservice.presentation

data class SearchReturnResult(
    val results: List<CarDetailReturnResult>,
): ReturnResult

data class CarDetailReturnResult(
    val id: Int,
    val price: Double,
    val name: String,
    val description: String,
)