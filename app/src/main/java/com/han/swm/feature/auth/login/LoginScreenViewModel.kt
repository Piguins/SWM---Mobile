package com.han.swm.feature.auth.login

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.han.swm.data.datastore.TokenStorage
import com.han.swm.domain.model.Auth
import com.han.swm.singleton.RepositorySingleton
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginScreenViewModel: ViewModel() {
    val authRepository = RepositorySingleton.authRepository

    private val _auth = MutableStateFlow<Auth?>(null)
    val auth: StateFlow<Auth?> = _auth.asStateFlow()

    private val _event = MutableSharedFlow<LoginEvent>()
    val event: SharedFlow<LoginEvent> = _event.asSharedFlow()

    fun onLogin(email: String, password: String) {
        viewModelScope.launch {
            try {
                val auth = authRepository.signIn(
                    email, password
                )
                _auth.update { auth }
                TokenStorage.dataStore.saveAccessToken(auth.accessToken)
                _event.emit(LoginEvent.SUCCESS)
            } catch (e: Exception) {
                _event.emit(LoginEvent.FAILED)
                val t = e.message
            }

        }
    }
}

enum class LoginEvent {
    SUCCESS,
    FAILED
}