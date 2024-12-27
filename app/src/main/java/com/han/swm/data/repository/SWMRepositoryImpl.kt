package com.han.swm.data.repository

import com.han.swm.data.dto.inbound.InboundDto
import com.han.swm.data.dto.inbound.asShipmentModel
import com.han.swm.data.dto.shipment.asDomainModel
import com.han.swm.data.dto.stock.asDomainModel
import com.han.swm.data.dto.stock.asStockModel
import com.han.swm.data.remote.SWMApi
import com.han.swm.domain.model.Product
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.Stock
import com.han.swm.domain.repository.SWMRepository

class SWMRepositoryImpl(
    private val swmApi: SWMApi
): SWMRepository {
    override suspend fun getStocks(): List<Stock> {
        return swmApi.getStockList().productList.map { it.asStockModel() }
    }

    override suspend fun getProductDetail(id: Int): Product {
        return swmApi.getProductDetail(id).asDomainModel()
    }

    override suspend fun getShipments(): List<Shipment> {
        return swmApi.getShipmentList().shipmentList.map { it.asDomainModel() }
    }

    override suspend fun getInboundDetail(id: Int): Shipment {
        return swmApi.getInBoundDetail(id).asShipmentModel()
    }
}