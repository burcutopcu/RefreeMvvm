package com.burcutopcu.refree.vm

import org.assertj.core.api.Assertions
import org.junit.After
import org.junit.Before
import org.junit.Test

class SecondScoreViewModelTest {

    private val secondScoreViewModel by lazy {
        SecondScoreViewModel()
    }

    @Before
    fun setUp() {

    }

    @Test
    fun getScoredDataAValueNull() {

        //Given

        //When
        val actual = this.secondScoreViewModel.getScoredDataA().value

        //Then
        Assertions.assertThat(actual)
            .isNull()
    }

    @Test
    fun getScoredDataBReturnsNotNull() {

        //Given

        //When
        val actual = this.secondScoreViewModel.getScoredDataB()

        //Then
        Assertions.assertThat(actual)
            .isNotNull()
    }

    @After
    fun tearDown() {

    }
}