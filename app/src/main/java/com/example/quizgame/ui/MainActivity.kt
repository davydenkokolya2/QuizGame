package com.example.quizgame.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.quizgame.R
import com.example.quizgame.ui.menu.MenuFragment
import com.example.quizgame.ui.onboarding.OnboardingFragment
import com.example.quizgame.ui.test.TestFragment
import com.example.quizgame.ui.welcom.WelcomeFragment
import com.example.quizgame.util.Nav
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val navViewModel: NavViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            navViewModel.stateNav.collect {
                when(it) {
                    Nav.ONBOARDING -> replaceFragment(OnboardingFragment())
                    Nav.MENU -> replaceFragment(MenuFragment())
                    Nav.TEST -> replaceFragment(TestFragment())
                    Nav.WELCOME -> replaceFragment(WelcomeFragment())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}