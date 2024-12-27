package com.han.swm.feature.dashboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.domain.model.statisticMock
import com.han.swm.domain.model.userMock
import com.han.swm.domain.model.weekStatisticMock
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashBoardScreenViewModel: ViewModel() {
    private val authRepository = RepositorySingleton.authRepository
    private val statisticsRepository = RepositorySingleton.statisticsRepository

    private val _uiState = MutableStateFlow<DashBoardScreenUiState>(DashBoardScreenUiState(user = userMock, weekStatistic = weekStatisticMock, statistic = statisticMock))
    val uiState: StateFlow<DashBoardScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                val userGet = async { authRepository.getProfile() }
                val weekStatisticGet = async { statisticsRepository.getWeekStatistic() }
                val statisticGet = async { statisticsRepository.getStatistic() }

                val user = userGet.await()
                val weekStatistic = weekStatisticGet.await()
                val statistic = statisticGet.await()

                _uiState.update {
                    _uiState.value.copy(
                        user = user,
                        weekStatistic = weekStatistic,
                        statistic = statistic
                    )
                }
            } catch (e: Exception) {
                Log.d("HanDebug", "bug: ${e.message}")
            }
        }
    }

    fun onChangeDashBoardType(type: DashBoardType) {
        _uiState.update {
            _uiState.value.copy(
                dashBoardType = type
            )
        }
    }
}