package com.han.swm.data.dto.inbound

import com.han.swm.data.dto.stock.Product

data class Item(
    val expirationDate: String,
    val id: Int,
    val manufactoringDate: String,
    val product: Product,
    val quantity: Int,
    val stockQuantity: Int,
    val totalPrice: Float,
    val unitPrice: Float
)