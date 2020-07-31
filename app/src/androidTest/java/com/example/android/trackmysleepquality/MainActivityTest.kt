package com.example.android.trackmysleepquality

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.not
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun toolbarTitleTest() {
        val title = InstrumentationRegistry.getInstrumentation().context.getString(R.string.title)

        onView(isAssignableFrom(Toolbar::class.java))
                .check(matches(withToolbarTitle(title)))
    }

    private fun withToolbarTitle(expectedTitle: CharSequence): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(Toolbar::class.java) {
            override fun describeTo(description: Description?) {
                description?.appendText("With toolbar title: $expectedTitle")
            }

            override fun matchesSafely(toolbar: Toolbar?): Boolean {
                return expectedTitle == toolbar?.title
            }
        }
    }

    @Test
    fun recognizeScreenAndClickOnButtonsTest() {
        onView(withId(R.id.stop_button))
                .check(matches(not(isEnabled())))

        onView(withId(R.id.clear_button))
                .check(matches(not(isEnabled())))

        onView(withId(R.id.start_button))
                .check(matches(isEnabled()))
                .perform(click())
                .check(matches(not(isEnabled())))

        onView(withId(R.id.stop_button))
                .check(matches(isEnabled()))
                .perform(click())

        onView(withId(R.id.title_text))
                .check(matches(withText(R.string.how_was_hour_sleep)))

        onView(withId(R.id.quality_three_image)).perform(click())

        onView(withId(R.id.stop_button))
                .check(matches(not(isEnabled())))
        onView(withId(R.id.clear_button))
                .check(matches(isEnabled()))
        onView(withId(R.id.start_button))
                .check(matches(isEnabled()))
    }

}
