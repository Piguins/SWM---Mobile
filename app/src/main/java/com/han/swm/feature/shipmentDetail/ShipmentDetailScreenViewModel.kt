package com.han.swm.feature.shipmentDetail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.han.swm.domain.model.Shipment
import com.han.swm.domain.model.shipmentMock
import com.han.swm.feature.shipmentDetail.navigation.ShipmentDetailRoute
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ShipmentDetailScreenViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val swmRepository = RepositorySingleton.swmRepository

    private val initId = savedStateHandle.toRoute<ShipmentDetailRoute>().shipmentId

    private val _shipment = MutableStateFlow<Shipment>(shipmentMock)
    val shipment: StateFlow<Shipment> = _shipment.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _shipment.update { swmRepository.getInboundDetail(initId) }
            } catch (e: Exception) {
                Log.d("HanDebug", "bug: ${e.message}")
            }
        }
    }
}