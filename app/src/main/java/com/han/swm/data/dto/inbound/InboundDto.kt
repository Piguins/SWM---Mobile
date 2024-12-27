package com.han.swm.data.dto.inbound

import com.han.swm.data.dto.shipment.Shipment
import com.han.swm.data.dto.shipment.ShipmentDto
import com.han.swm.data.dto.shipment.asDomainModel
import com.han.swm.data.dto.stock.asDomainModel

data class InboundDto(
    val date: String,
    val id: Int,
    val items: List<Item>,
    val price: Float,
    val quantity: Int,
    val shipment: Shipment
)

fun InboundDto.asShipmentModel(): com.han.swm.domain.model.Shipment {
    val shipment1 = shipment.asDomainModel()
    return shipment1.copy(
        products = items.map { it.product.asDomainModel() }
    )
}