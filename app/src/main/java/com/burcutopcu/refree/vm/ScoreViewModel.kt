package com.burcutopcu.refree.vm

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import android.view.View
import androidx.databinding.library.baseAdapters.BR
import com.burcutopcu.refree.model.ScoreModel
import java.util.*


class ScoreViewModel(private val scoreModel:ScoreModel) : Observer, BaseObservable(){

    init {
        scoreModel.addObserver(this)
    }

    override fun update(o: Observable?, arg: Any?) {

        if (arg is String) {
            if (arg=="scoreA")
                notifyPropertyChanged(BR.scoreA)
            else if (arg=="scoreB")
                notifyPropertyChanged(BR.scoreB)
        }
    }

    val scoreA: String
        @Bindable get() {
            return String.format(Locale.ENGLISH, "%d", scoreModel.scoreA)
        }

    val scoreB: String
        @Bindable get() {
            return String.format(Locale.ENGLISH, "%d", scoreModel.scoreB)
        }

    fun onThreeScoreButtonClickA(view: View) {
        this.scoreModel.scoreA=scoreA.toInt()+3
    }

    fun onTwoScoreButtonClickA(view: View) {
        this.scoreModel.scoreA=scoreA.toInt()+2
    }

    fun onOneScoreButtonClickA(view: View) {
        this.scoreModel.scoreA=scoreA.toInt()+1
    }

    fun onThreeScoreButtonClickB(view: View) {
        this.scoreModel.scoreB=scoreB.toInt()+3
    }

    fun onTwoScoreButtonClickB(view: View) {
        this.scoreModel.scoreB=scoreB.toInt()+2
    }

    fun onOneScoreButtonClickB(view: View) {
        this.scoreModel.scoreB=scoreB.toInt()+1
    }

    fun onResetButtonClick(view: View) {
        this.scoreModel.scoreB=0
        this.scoreModel.scoreA=0
    }
}