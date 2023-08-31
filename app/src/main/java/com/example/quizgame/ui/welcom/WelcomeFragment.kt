package com.example.quizgame.ui.welcom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizgame.databinding.FragmentWelcomBinding
import com.example.quizgame.ui.NavViewModel
import com.example.quizgame.util.Nav

class WelcomeFragment : Fragment() {


    private lateinit var binding: FragmentWelcomBinding
    private val navViewModel: NavViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomBinding.inflate(inflater, container, false)
        binding.btnStart.setOnClickListener {
            navViewModel.loadState(Nav.MENU)
        }
        return binding.root
    }

}