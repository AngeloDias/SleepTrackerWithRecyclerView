package com.example.android.trackmysleepquality


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class BuildOnEspressoTestRecorderTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
                allOf(withText("Track My Sleep Quality"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()))
        textView.check(matches(withText("Track My Sleep Quality")))

        val button = onView(
                allOf(withId(R.id.clear_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                3),
                        isDisplayed()))
        button.check(matches(isDisplayed()))

        val button2 = onView(
                allOf(withId(R.id.stop_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                1),
                        isDisplayed()))
        button2.check(matches(isDisplayed()))

        val button3 = onView(
                allOf(withId(R.id.start_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                0),
                        isDisplayed()))
        button3.check(matches(isDisplayed()))

        val button4 = onView(
                allOf(withId(R.id.start_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                0),
                        isDisplayed()))
        button4.check(matches(isDisplayed()))

        val appCompatButton = onView(
                allOf(withId(R.id.start_button), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                1),
                        isDisplayed()))
        appCompatButton.perform(click())

        val appCompatButton2 = onView(
                allOf(withId(R.id.stop_button), withText("Stop"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                2),
                        isDisplayed()))
        appCompatButton2.perform(click())

        val imageView = onView(
                allOf(withId(R.id.quality_zero_image), withContentDescription("Sleep Quality 0"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                1),
                        isDisplayed()))
        imageView.check(matches(isDisplayed()))

        val imageView2 = onView(
                allOf(withId(R.id.quality_one_image), withContentDescription("Sleep Quality 1"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                2),
                        isDisplayed()))
        imageView2.check(matches(isDisplayed()))

        val imageView3 = onView(
                allOf(withId(R.id.quality_two_image), withContentDescription("Sleep Quality 2"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                3),
                        isDisplayed()))
        imageView3.check(matches(isDisplayed()))

        val imageView4 = onView(
                allOf(withId(R.id.quality_three_image), withContentDescription("Sleep Quality 3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                4),
                        isDisplayed()))
        imageView4.check(matches(isDisplayed()))

        val imageView5 = onView(
                allOf(withId(R.id.quality_four_image), withContentDescription("Sleep Quality 4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                5),
                        isDisplayed()))
        imageView5.check(matches(isDisplayed()))

        val imageView6 = onView(
                allOf(withId(R.id.quality_five_image), withContentDescription("Sleep Quality 5"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                6),
                        isDisplayed()))
        imageView6.check(matches(isDisplayed()))

        val textView2 = onView(
                allOf(withId(R.id.title_text), withText("How was your sleep?"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                0),
                        isDisplayed()))
        textView2.check(matches(isDisplayed()))

        val textView3 = onView(
                allOf(withId(R.id.title_text), withText("How was your sleep?"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                0),
                        isDisplayed()))
        textView3.check(matches(withText("How was your sleep?")))

        val appCompatImageView = onView(
                allOf(withId(R.id.quality_four_image), withContentDescription("Sleep Quality 4"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                5),
                        isDisplayed()))
        appCompatImageView.perform(click())

        val appCompatButton3 = onView(
                allOf(withId(R.id.start_button), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                1),
                        isDisplayed()))
        appCompatButton3.perform(click())

        val appCompatButton4 = onView(
                allOf(withId(R.id.stop_button), withText("Stop"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                2),
                        isDisplayed()))
        appCompatButton4.perform(click())

        val appCompatImageView2 = onView(
                allOf(withId(R.id.quality_three_image), withContentDescription("Sleep Quality 3"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                4),
                        isDisplayed()))
        appCompatImageView2.perform(click())

        val appCompatButton5 = onView(
                allOf(withId(R.id.clear_button), withText("Clear"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment),
                                        0),
                                3),
                        isDisplayed()))
        appCompatButton5.perform(click())

        pressBack()
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

}
