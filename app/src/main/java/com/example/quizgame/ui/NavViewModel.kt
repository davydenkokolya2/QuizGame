package com.example.quizgame.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizgame.util.Nav
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NavViewModel: ViewModel() {
    private val _stateNav = MutableStateFlow<Nav>(Nav.ONBOARDING)
    val stateNav: StateFlow<Nav> = _stateNav
    fun loadState(nav: Nav) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateNav.emit(nav)
        }
    }
}