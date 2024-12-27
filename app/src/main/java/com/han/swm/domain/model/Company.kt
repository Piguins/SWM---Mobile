package com.han.swm.domain.model

data class Company(
    val id: Int,
    val name: String,
    val phone: String,
    val address: String,
    val email: String,
)

val companyMock = Company(
    id = 1,
    name = "Test company",
    phone = "09999999",
    address = "Test address",
    email = "Test email"
)