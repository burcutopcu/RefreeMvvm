package com.burcutopcu.refree

import android.view.View
import android.widget.Button
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ActivityUITest {

    @get:Rule
    var mActivityTestRule: ActivityTestRule<SecondScoreActivity> = ActivityTestRule(SecondScoreActivity::class.java)

    @Test
    fun testFinishGameButton_shouldBeDisplayed() {
        onView(withId(R.id.finish_game_button_ss))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testFinishGameButton_shouldHaveText() {
        val textButton = "FINISH THE GAME"

        onView(withId(R.id.finish_game_button_ss))
            .check(matches(withText(textButton)))
    }

    @Test
    fun testFinisGameButton_shouldCompletelyDisplayOnScroll() {
        onView(withId(R.id.finish_game_button_ss))
            .perform(scrollTo())
            .check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun testResetButton_shouldOpenAnotherActivity() {
        onView(withId(R.id.reset_button_ss))
            .perform(click())

        var mainActivity = MainActivity::class.java.name

        intended(IntentMatchers.hasComponent(mainActivity))

    }

    private fun hasButtonText(textButton:String): Matcher<View> {

        return object : BoundedMatcher<View,Button>(Button::class.java) {

            override fun describeTo(description: Description) {
                description.appendText("Successfully button has a text : $textButton")
            }

            override fun matchesSafely(item: Button?): Boolean {

                if (item == null) {
                    return false
                }

                if (item.text == null) {
                    return false
                }

                return withChild(withText(textButton)).matches(item.text)

            }

        }
    }
}
