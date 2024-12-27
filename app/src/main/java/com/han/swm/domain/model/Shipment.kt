package com.han.swm.domain.model

enum class ShipmentStatus(val label: String) {
    InProgress("Đang vận chuyển"),
    Success("Vận chuyển thành công"),
    Failure("Vận chuyển thất bại")
}

enum class ShipmentType {
    INBOUND, OUTBOUND
}

data class Shipment(
    val id: Int,
    val type: ShipmentType,
    val date: Long,
    val senderAddress: String,
    val receiverAddress: String,
    val carrier: String,
    val status: ShipmentStatus,
    val personInCharge: List<User>,
    val products: List<Product>
)

val shipmentMock = Shipment(
    id = 0,
    type = ShipmentType.OUTBOUND,
    date = System.currentTimeMillis(),
    carrier = "Test carrier",
    status = ShipmentStatus.InProgress,
    personInCharge = listOf(userMock),
    senderAddress = "Trường đại học Công nghệ Thông tin - ĐHQG Hồ Chí Minh",
    receiverAddress = "Ký túc xã khu B - Ký túc xá ĐHQG Hồ Chí Minh",
    products = listOf(productMock)
)