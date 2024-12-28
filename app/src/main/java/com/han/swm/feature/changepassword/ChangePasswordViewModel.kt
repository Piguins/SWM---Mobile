package com.han.swm.feature.changepassword

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.han.swm.feature.auth.forgotpassword.navigation.ForgotPasswordRoute

class ChangePasswordViewModel(
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    fun onChangePassword(
        currentPw: String,
        newPw: String,
        confirmPw: String,
    ) {

    }
}