package com.han.swm.feature.auth.forgotpassword

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.han.swm.feature.auth.forgotpassword.navigation.ForgotPasswordRoute

class ForgotPasswordViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    val initEmail = savedStateHandle.toRoute<ForgotPasswordRoute>().email

    fun onForgotPassword(email: String) {

    }
}