package com.example.quizgame.ui.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.quizgame.databinding.FragmentTestBinding
import com.example.quizgame.ui.NavViewModel
import com.example.quizgame.ui.menu.MenuViewModel
import com.example.quizgame.util.Constant
import com.example.quizgame.util.Nav
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private val testViewModel: TestViewModel by activityViewModels()
    private val menuViewModel: MenuViewModel by activityViewModels()
    private lateinit var listTest: List<List<String>>
    private lateinit var listTestAnswers: List<Int>
    private val navViewModel: NavViewModel by activityViewModels()
    private var flag = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        binding.progressBar.max = 5
        binding.progressBar2.max = 1200

        lifecycleScope.launch {
            menuViewModel.stateMenu.collect {
                when (it) {
                    0 -> {
                        listTest = Constant.firstTest
                        listTestAnswers = Constant.firstTestAnswers
                    }

                    1 -> {
                        listTest = Constant.secondTest
                        listTestAnswers = Constant.secondTestAnswers
                    }
                }
            }
        }

        lifecycleScope.launch {
            testViewModel.stateTest.collect {
                flag = false
                binding.tvTypeTest.text = listTest[5][0]
                binding.progressBar.progress = it + 1
                binding.tvAnswer1.text = listTest[it][1]
                binding.tvAnswer2.text = listTest[it][2]
                binding.tvAnswer3.text = listTest[it][3]
                binding.tvAnswer4.text = listTest[it][4]
                binding.tvQuestion.text = listTest[it][0]
                binding.tvNumberQuestion.text = "Question - ${it + 1}"
                binding.tvNumberQuestionProgress.text = "${it + 1}/5"
                binding.ivFalseAnswer1.visibility = View.INVISIBLE
                binding.ivFalseAnswer2.visibility = View.INVISIBLE
                binding.ivFalseAnswer3.visibility = View.INVISIBLE
                binding.ivFalseAnswer4.visibility = View.INVISIBLE
                binding.ivTrueAnswer1.visibility = View.INVISIBLE
                binding.ivTrueAnswer2.visibility = View.INVISIBLE
                binding.ivTrueAnswer3.visibility = View.INVISIBLE
                binding.ivTrueAnswer4.visibility = View.INVISIBLE
            }
        }
        lifecycleScope.launch {
            for (i in 1200 downTo 0) {
                binding.progressBar2.progress = i
                if (i / 60 < 10 && i % 60 < 10)
                    binding.tvTime.text = "0${i / 60}:0${i % 60}"
                else if (i / 60 >= 10 && i % 60 < 10)
                    binding.tvTime.text = "${i / 60}:0${i % 60}"
                else if (i / 60 < 10 && i % 60 >= 10)
                    binding.tvTime.text = "0${i / 60}:${i % 60}"
                else binding.tvTime.text = "${i / 60}:${i % 60}"
                delay(1000)
            }
        }
        binding.btnAnswer1.setOnClickListener {
            if (listTestAnswers[testViewModel.stateTest.value] == 1) {
                binding.ivTrueAnswer1.visibility = View.VISIBLE
                flag = true
            } else
                binding.ivFalseAnswer1.visibility = View.VISIBLE
        }

        binding.btnAnswer2.setOnClickListener {
            if (listTestAnswers[testViewModel.stateTest.value] == 2) {
                binding.ivTrueAnswer2.visibility = View.VISIBLE
                flag = true
            } else
                binding.ivFalseAnswer2.visibility = View.VISIBLE
        }

        binding.btnAnswer3.setOnClickListener {
            if (listTestAnswers[testViewModel.stateTest.value] == 3) {
                binding.ivTrueAnswer3.visibility = View.VISIBLE
                flag = true
            } else
                binding.ivFalseAnswer3.visibility = View.VISIBLE
        }

        binding.btnAnswer4.setOnClickListener {
            if (listTestAnswers[testViewModel.stateTest.value] == 4) {
                binding.ivTrueAnswer4.visibility = View.VISIBLE
                flag = true
            } else
                binding.ivFalseAnswer4.visibility = View.VISIBLE
        }

        binding.btnNextQuestion.setOnClickListener {
            if (flag && testViewModel.stateTest.value + 1 < 5)
                testViewModel.loadStateQuestion(testViewModel.stateTest.value + 1)
            else if (flag)
                navViewModel.loadState(Nav.MENU)
        }

        binding.btnHomeTest.setOnClickListener {
            navViewModel.loadState(Nav.MENU)
        }
        return binding.root
    }

}