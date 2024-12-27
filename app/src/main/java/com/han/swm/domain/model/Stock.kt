package com.han.swm.domain.model

data class Stock(
    val product: Product,
    val id: Int,
    val quantity: Int,
    val outboundQuantity: Int,
    val expiredQuantity: Int,
    val createdDate: Long
)

val stockMock = Stock(
    product = productMock,
    id = 0,
    quantity = 20,
    outboundQuantity = 10,
    expiredQuantity = 5,
    createdDate = System.currentTimeMillis()
)
