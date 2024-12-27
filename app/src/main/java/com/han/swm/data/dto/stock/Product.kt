package com.han.swm.data.dto.stock

import com.han.swm.common.DateHelper
import com.han.swm.domain.model.ProductCategory
import com.han.swm.domain.model.Stock
import kotlin.math.min

data class Product(
    val category: Category,
    val company: Company,
    val description: String,
    val id: Int,
    val image: String?,
    val marketPrice: Double,
    val maxQuantity: Int,
    val minQuantity: Int,
    val name: String,
    val productionCost: Double,
    val quantity: Int,
    val sku: String,
    val tags: List<Tag>
)

fun Product.asStockModel() = Stock(
    product = com.han.swm.domain.model.Product(
        id = id,
        name = name,
        sku = sku,
        marketPrice = marketPrice.toFloat(),
        productionCost = productionCost.toFloat(),
        image = image ?: "",
        minQuantity = minQuantity,
        maxQuantity = maxQuantity,
        category = ProductCategory(
            id = category.id,
            name = category.name
        ),
        company = com.han.swm.domain.model.Company(
            id = company.id,
            name = company.name,
            phone = company.phone,
            address = company.address,
            email = company.email,
        ),
        tags = tags.map {
            com.han.swm.domain.model.Tag(
                id = it.id,
                name = it.name,
                description = it.description,
                createdDate = DateHelper.isoStringTimeStamp(it.createdDate)
            )
        }
    ),
    id = id,
    quantity = quantity,
    outboundQuantity = 0, // CHANGE
    expiredQuantity = 0, // CHANGE
    createdDate = 0 // CHANGE
)

fun Product.asDomainModel() = com.han.swm.domain.model.Product(
    id = id,
    name = name,
    sku = sku,
    marketPrice = marketPrice.toFloat(),
    productionCost = productionCost.toFloat(),
    image = image ?: "",
    minQuantity = minQuantity,
    maxQuantity = maxQuantity,
    category = ProductCategory(
        id = category.id,
        name = category.name
    ),
    company = com.han.swm.domain.model.Company(
        id = company.id,
        name = company.name,
        phone = company.phone,
        address = company.address,
        email = company.email,
    ),
    tags = tags.map {
        com.han.swm.domain.model.Tag(
            id = it.id,
            name = it.name,
            description = it.description,
            createdDate = DateHelper.isoStringTimeStamp(it.createdDate)
        )
    }
)