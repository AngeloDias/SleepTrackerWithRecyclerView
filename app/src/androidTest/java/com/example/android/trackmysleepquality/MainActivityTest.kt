package com.example.android.trackmysleepquality

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun recognizeScreenAndClickOnButtonsTest() {
        onView(withId(R.id.start_button)).perform(click())
        onView(withId(R.id.stop_button)).perform(click())

        onView(withId(R.id.title_text))
                .check(ViewAssertions.matches(withText(R.string.how_was_hour_sleep)))

        onView(withId(R.id.quality_three_image)).perform(click())
    }

}
