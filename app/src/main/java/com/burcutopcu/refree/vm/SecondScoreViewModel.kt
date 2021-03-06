package com.burcutopcu.refree.vm

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.burcutopcu.refree.DetailActivity

class SecondScoreViewModel: ViewModel(){

    private val scoreDataA = MutableLiveData<Int>()
    private val scoreDataB = MutableLiveData<Int>()
    private val isProcessFinish = MutableLiveData<Boolean>()

    fun getScoredDataA(): LiveData<Int>{
        return scoreDataA
    }

    fun getScoredDataB(): LiveData<Int>{
        return scoreDataB
    }

    fun finishProcess(){
        isProcessFinish.value=true
    }

    fun isFinishProcess():LiveData<Boolean> {
        return isProcessFinish
    }

    fun increaseScoreA(buttonNumber:Int): LiveData<Int> {
        if (scoreDataA.value == null){
            scoreDataA.value=0
        }
        scoreDataA.value= buttonNumber+ scoreDataA.value!!
        return scoreDataA
    }

    fun increaseScoreB(buttonNumber:Int): LiveData<Int> {
        if (scoreDataB.value == null){
            scoreDataB.value=0
        }
        scoreDataB.postValue(buttonNumber+ scoreDataB.value!!)
        return scoreDataB
    }

    fun reset(){
        scoreDataA.value=0
        scoreDataB.value=0
    }

    fun openDetailActivity(view:View) {
        val intent = Intent(view.context, DetailActivity::class.java)
        startActivity(view.context,intent,null)
    }
}