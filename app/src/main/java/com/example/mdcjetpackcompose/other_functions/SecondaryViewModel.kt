package com.example.mdcjetpackcompose.other_functions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondaryViewModel: ViewModel() {

    val textFieldState = MutableLiveData("")

    fun onTextFieldChange(newText: String) {

        textFieldState.value = newText
    }
}