package com.han.swm.feature.dashboard

import androidx.lifecycle.ViewModel
import com.han.swm.domain.model.userMock
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashBoardScreenViewModel: ViewModel() {
    private val _uiState = MutableStateFlow<DashBoardScreenUiState>(DashBoardScreenUiState(user = userMock))
    val uiState: StateFlow<DashBoardScreenUiState> = _uiState.asStateFlow()

    fun onChangeDashBoardType(type: DashBoardType) {

    }
}