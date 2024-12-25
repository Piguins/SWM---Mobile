package com.han.swm.domain.model

data class ActivityLog(
    val id: Int,
    val timestamp: Long,
    val description: String
)


val logMock = ActivityLog(
    id = 0,
    timestamp = System.currentTimeMillis(),
    description = "Thêm 10 sản phẩm nước hoa Dior vào hệ thống"
)