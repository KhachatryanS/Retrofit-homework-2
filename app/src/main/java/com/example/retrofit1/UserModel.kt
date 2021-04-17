package com.example.retrofit1

data class UserModel(
    val `data`: List<Data>,
    val page: Int,
    val perPage: Int,
    val support: Support,
    val total: Int,
    val totalPages: Int
) {
    data class Data(
        val avatar: String,
        val email: String,
        val first_name: String,
        val id: Int,
        val last_name: String
    )

    data class Support(
        val text: String,
        val url: String
    )
}