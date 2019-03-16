package com.burcutopcu.refree

import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.burcutopcu.refree.model.ScoreModel
import com.burcutopcu.refree.vm.ScoreViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val scoreModel = ScoreModel()

        val scoreViewModel=ScoreViewModel(scoreModel)

        val binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)

        binding.setVariable(BR.scoreViewModel, scoreViewModel)

    }
}
