package com.example.quizgame.ui.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TestViewModel : ViewModel() {
    private val _stateTest = MutableStateFlow<Int>(0)
    val stateTest: StateFlow<Int> = _stateTest
    fun loadStateQuestion(question: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _stateTest.emit(question)
        }
    }
}