package com.han.swm.domain.model

data class Notification(
    val id: Int,
    val title: String,
    val body: String,
    val isRead: Boolean,
    val createdDate: Long,
)

val notificationMock = Notification(
    id = 0,
    title = "Sản phẩm nước hoa Dior mã SKU0001 sắp hết",
    body = "Vui lòng chú ý tiếng hành nhập thêm sản phẩm vào kho",
    isRead = true,
    createdDate = System.currentTimeMillis()
)
