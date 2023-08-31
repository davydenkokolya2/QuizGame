package com.example.quizgame.ui.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuViewModel : ViewModel() {
    private val _stateMenu = MutableStateFlow<Int>(0)
    val stateMenu: StateFlow<Int> = _stateMenu
    fun loadState(test: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateMenu.emit(test)
        }
    }
}