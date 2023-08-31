package com.example.quizgame.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.quizgame.databinding.FragmentOnboardingBinding
import com.example.quizgame.ui.NavViewModel
import com.example.quizgame.util.Nav

class OnboardingFragment : Fragment() {


    private lateinit var binding: FragmentOnboardingBinding
    private val navViewModel: NavViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        binding.tvOnboarding.setOnClickListener {
            navViewModel.loadState(Nav.WELCOME)
        }
        return binding.root
    }
}