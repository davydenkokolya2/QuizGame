package com.example.quizgame.ui.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizgame.databinding.FragmentMenuBinding
import com.example.quizgame.ui.NavViewModel
import com.example.quizgame.ui.test.TestViewModel
import com.example.quizgame.util.Nav

class MenuFragment : Fragment() {


    private lateinit var binding: FragmentMenuBinding
    private val menuViewModel: MenuViewModel by activityViewModels()
    private val navViewModel: NavViewModel by activityViewModels()
    private val testViewModel: TestViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        testViewModel.loadStateQuestion(0)
        binding.btnFirstCard.setOnClickListener {
            menuViewModel.loadState(0)
            navViewModel.loadState(Nav.TEST)
        }
        binding.btnSecondCard.setOnClickListener {
            menuViewModel.loadState(1)
            navViewModel.loadState(Nav.TEST)
        }
        binding.btnHome.setOnClickListener {
            navViewModel.loadState(Nav.WELCOME)
        }
        return binding.root
    }
}