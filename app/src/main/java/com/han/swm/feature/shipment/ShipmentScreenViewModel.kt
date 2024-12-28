package com.han.swm.feature.shipment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.ShipmentStatus
import com.han.swm.domain.model.ShipmentType
import com.han.swm.domain.model.shipmentMock
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShipmentScreenViewModel: ViewModel() {

    private val swmRepository = RepositorySingleton.swmRepository
    private val _shipments = MutableStateFlow<List<Shipment>>(listOf())
    val shipments: StateFlow<List<Shipment>> = _shipments.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _shipments.update { swmRepository.getShipments() }
            } catch (e: Exception) {
                Log.d("HanDebug", "bug: ${e.message}")
            }
        }
    }
}