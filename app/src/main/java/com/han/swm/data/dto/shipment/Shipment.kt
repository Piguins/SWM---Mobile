package com.han.swm.data.dto.shipment

import com.han.swm.common.DateHelper
import com.han.swm.data.dto.UserDto
import com.han.swm.data.dto.asDomainModel
import com.han.swm.domain.model.ShipmentStatus
import com.han.swm.domain.model.ShipmentType

data class Shipment(
    val carrier: String,
    val completedDate: String?,
    val date: String,
    val fromPosition: String,
    val id: Int,
    val pic: UserDto,
    val status: String,
    val toPosition: String,
    val type: String
)

fun Shipment.asDomainModel() = com.han.swm.domain.model.Shipment(
    id = id,
    type = ShipmentType.valueOf(type),
    date = DateHelper.isoStringTimeStamp(date),
    senderAddress = fromPosition,
    receiverAddress = toPosition,
    carrier = carrier,
    status = if (status == "PENDING") {
        ShipmentStatus.InProgress
    } else ShipmentStatus.Success,
    personInCharge = listOf(pic.asDomainModel()),
    products = listOf()
)