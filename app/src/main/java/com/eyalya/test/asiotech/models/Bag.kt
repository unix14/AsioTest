package com.eyalya.test.asiotech.models

import com.eyalya.test.asiotech.common.formatToString

class Bag(var id: Int, var weight: Float) {
    override fun toString(): String {
        return "Bag #$id (${weight.formatToString()})Kg"
    }
}