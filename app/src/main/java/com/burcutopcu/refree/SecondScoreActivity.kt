package com.burcutopcu.refree

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.burcutopcu.refree.vm.SecondScoreViewModel
import kotlinx.android.synthetic.main.activity_score.*
import androidx.lifecycle.Observer


class SecondScoreActivity : AppCompatActivity() {

    lateinit var liveDataViewModel: SecondScoreViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        liveDataViewModel = ViewModelProviders.of(this).get(SecondScoreViewModel::class.java)

        liveDataViewModel.getScoredDataA().observe(this, Observer<Int> {
            first_score_number_ss.text = it.toString()
        })

        liveDataViewModel.getScoredDataB().observe(this, Observer<Int> {
            second_score_number_ss.text = it.toString()
        })

        liveDataViewModel.isFinishProcess().observeForever {
            if (it)
                Toast.makeText(this, "Oyun bitti", Toast.LENGTH_SHORT).show()
        }

        three_point_button_first_ss.setOnClickListener {
            liveDataViewModel.increaseScoreA(3)
        }

        two_point_button_first_ss.setOnClickListener {
            liveDataViewModel.increaseScoreA(2)
        }

        one_point_button_firs_ss.setOnClickListener {
            liveDataViewModel.increaseScoreA(1)
        }

        three_point_button_second_ss.setOnClickListener {
            liveDataViewModel.increaseScoreB(3)
        }

        two_point_button_second_ss.setOnClickListener {
            liveDataViewModel.increaseScoreB(2)
        }

        one_point_button_second_ss.setOnClickListener {
            liveDataViewModel.increaseScoreB(1)
        }

        reset_button_ss.setOnClickListener {
            liveDataViewModel.reset()
        }

        finish_game_button_ss.setOnClickListener {
            liveDataViewModel.finishProcess()
        }

        intent_button_ss.setOnClickListener {
            liveDataViewModel.openDetailActivity(it)
        }

    }
}