package com.fozimat.catafozmovie

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.fozimat.catafozmovie.ui.MainActivity
import com.fozimat.catafozmovie.utils.DataDummy
import com.fozimat.catafozmovie.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTv = DataDummy.generateTvShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.navigation_movies)).perform(click())
        onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.navigation_movies)).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tv_item_year))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_detail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loadTv() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_movies))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTv.size
            )
        )
    }

    @Test
    fun loadDetailTv() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_title))
            .check(ViewAssertions.matches(withText(dummyTv[0].title)))
        onView(withId(R.id.tv_item_year))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_genre))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_detail))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.tv_item_duration))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun loadFavMovies() {
        onView(withId(R.id.navigation_movies)).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.button_fav)).perform(click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText("MOVIES")).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.button_fav)).perform(click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }

    @Test
    fun loadFavTv() {
        onView(withId(R.id.navigation_tvShow)).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.button_fav)).perform(click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_favorite)).perform(click())
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.button_fav)).perform(click())
        onView(ViewMatchers.isRoot()).perform(ViewActions.pressBack())
    }
}