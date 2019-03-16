package com.burcutopcu.refree.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondScoreViewModel: ViewModel(){

    private val scoreDataA = MutableLiveData<Int>()
    private val scoreDataB = MutableLiveData<Int>()

    fun getScoredDataA(): LiveData<Int>{
        return scoreDataA
    }

    fun getScoredDataB(): LiveData<Int>{
        return scoreDataB
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
        scoreDataB.value= buttonNumber+ scoreDataB.value!!
        return scoreDataB
    }

    fun reset(){
        scoreDataA.value=0
        scoreDataB.value=0
    }
}