package com.han.swm.domain.repository

import com.han.swm.data.dto.inbound.InboundDto
import com.han.swm.domain.model.Product
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.Stock

interface SWMRepository {
    suspend fun getStocks(): List<Stock>

    suspend fun getProductDetail(id: Int): Product

    suspend fun getShipments(): List<Shipment>

    suspend fun getInboundDetail(id: Int): Shipment
}