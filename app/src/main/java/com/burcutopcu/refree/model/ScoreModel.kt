package com.burcutopcu.refree.model

import java.util.*

class ScoreModel: Observable(){

    var scoreA:Int=0
    set(value) {
        field=value
        setChangedAndNotify("scoreA")
    }

    var scoreB:Int=0
        set(value) {
            field=value
            setChangedAndNotify("scoreB")
        }

    private fun setChangedAndNotify(field:Any) {
        setChanged()
        notifyObservers(field)
    }
}