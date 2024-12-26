package com.han.swm.feature.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.domain.model.User
import com.han.swm.domain.model.userMock
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileDetailScreenViewModel: ViewModel() {
    private val authRepository = RepositorySingleton.authRepository

    private val _user = MutableStateFlow<User>(userMock)
    val user: StateFlow<User> = _user.asStateFlow()

    init {
        viewModelScope.launch {
            val user = authRepository.getProfile()

            _user.update { user }
        }

    }
    fun onReport() {

    }
}