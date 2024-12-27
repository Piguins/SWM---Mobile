package com.han.swm.domain.model

data class ProductCategory(
    val id: Int,
    val name: String
)

data class Product(
    val id: Int,
    val name: String,
    val sku: String,
    val marketPrice: Float,
    val productionCost: Float,
    val image: String,
    val minQuantity: Int,
    val maxQuantity: Int,
    val category: ProductCategory,
    val company: Company,
    val tags: List<Tag>
)

val productCategoryMock = ProductCategory(
    id = 0,
    name = "Cat 1"
)

val productMock = Product(
    id = 0,
    name = "Product 1",
    sku = "Test SKU",
    marketPrice = 1f,
    productionCost = 1f,
    image = "https://png.pngtree.com/png-clipart/20221013/ourmid/pngtree-simulation-cosmetics-product-sample-skin-care-essential-oil-png-image_6158599.png",
    minQuantity = 1,
    maxQuantity = 10,
    category = productCategoryMock,
    company = companyMock,
    tags = listOf(tagMock)
)