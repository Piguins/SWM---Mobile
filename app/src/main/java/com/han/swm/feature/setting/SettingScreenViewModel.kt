package com.han.swm.feature.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.data.datastore.TokenStorage
import kotlinx.coroutines.launch

class SettingScreenViewModel: ViewModel() {
    fun onLogout() {
        viewModelScope.launch {
            TokenStorage.dataStore.clear()
        }
    }
}