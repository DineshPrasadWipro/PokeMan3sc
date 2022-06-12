package com.zm.pokemon.activity

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.zm.pokemon.view.HomeScreenActivity
import org.junit.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class HomeScreenActivityTest {

    @get: Rule
    var activityScenarioRule: ActivityScenarioRule<HomeScreenActivity> =
        ActivityScenarioRule<HomeScreenActivity>(
            HomeScreenActivity::class.java
        )

    @Before
    fun setup() {
        //launchActivity()
    }

    @After
    fun teardown() {
        //finishActivity()
    }

    @Test
    fun should_show_pokemon_list_when_user_launches_homescreen() { // ktlint-disable max-line-length
//    launchActivity()
//          onView(
//              withId(R.id.pokemon_list)
//          ).check(matches(isDisplayed()));

        // launchActivity()

    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        Assert.assertEquals("com.zm.pokemon", appContext.packageName)
    }
}