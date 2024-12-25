package com.han.swm.feature.forgotpassword

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.han.swm.feature.forgotpassword.navigation.ForgotPasswordRoute
import com.han.swm.feature.forgotpassword.navigation.emailArg

class ForgotPasswordViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {
    val initEmail = savedStateHandle.toRoute<ForgotPasswordRoute>().email

    fun onForgotPassword(email: String) {

    }
}