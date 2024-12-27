package com.han.swm.feature.productdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.han.swm.domain.model.Product
import com.han.swm.domain.model.productMock
import com.han.swm.feature.auth.forgotpassword.navigation.ForgotPasswordRoute
import com.han.swm.feature.productdetail.navigation.ProductDetailRoute
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailScreenViewModel(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val swmRepository = RepositorySingleton.swmRepository

    private val initId = savedStateHandle.toRoute<ProductDetailRoute>().id

    private val _product = MutableStateFlow<Product>(productMock)
    val product: StateFlow<Product> = _product.asStateFlow()

    init {
        viewModelScope.launch {
            _product.update { swmRepository.getProductDetail(initId) }
        }
    }
}