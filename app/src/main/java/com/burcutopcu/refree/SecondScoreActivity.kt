package com.burcutopcu.refree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.burcutopcu.refree.vm.SecondScoreViewModel
import kotlinx.android.synthetic.main.activity_score.*

class SecondScoreActivity:AppCompatActivity() {

    lateinit var liveDataViewModel : SecondScoreViewModel

    private val scoreObserverA = Observer<Int> {
        liveDataViewModel.increaseScoreA(it)
    }

    private val scoreObserverB = Observer<Int> {
        liveDataViewModel.increaseScoreB(it)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        liveDataViewModel = ViewModelProviders.of(this).get(SecondScoreViewModel::class.java)

        three_point_button_first_ss.setOnClickListener {
            scoreObserverA.onChanged(3)
            first_score_number_ss.text = liveDataViewModel.getScoredDataA().value.toString()
        }

        two_point_button_first_ss.setOnClickListener {
            scoreObserverA.onChanged(2)
            first_score_number_ss.text = liveDataViewModel.getScoredDataA().value.toString()
        }

        one_point_button_firs_ss.setOnClickListener {
            scoreObserverA.onChanged(1)
            first_score_number_ss.text = liveDataViewModel.getScoredDataA().value.toString()
        }

        three_point_button_second_ss.setOnClickListener {
            scoreObserverB.onChanged(3)
            second_score_number_ss.text = liveDataViewModel.getScoredDataB().value.toString()
        }

        two_point_button_second_ss.setOnClickListener {
            scoreObserverB.onChanged(2)
            second_score_number_ss.text = liveDataViewModel.getScoredDataB().value.toString()
        }

        one_point_button_second_ss.setOnClickListener {
            scoreObserverB.onChanged(1)
            second_score_number_ss.text = liveDataViewModel.getScoredDataB().value.toString()
        }

        reset_button_ss.setOnClickListener {
            liveDataViewModel.reset()
            first_score_number_ss.text= liveDataViewModel.getScoredDataA().value.toString()
            second_score_number_ss.text=liveDataViewModel.getScoredDataB().value.toString()
        }

    }
}