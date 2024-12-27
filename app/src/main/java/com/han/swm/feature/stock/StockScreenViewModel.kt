package com.han.swm.feature.stock

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.domain.model.Stock
import com.han.swm.domain.model.stockMock
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StockScreenViewModel: ViewModel() {
    private val swmRepository = RepositorySingleton.swmRepository

    private val _stocks = MutableStateFlow<List<Stock>>(listOf())
    val stocks: StateFlow<List<Stock>> = _stocks.asStateFlow()

    init {
        viewModelScope.launch {
            _stocks.update { swmRepository.getStocks() }
        }
    }
}