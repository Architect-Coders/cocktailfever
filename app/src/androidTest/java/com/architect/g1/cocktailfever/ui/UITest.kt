package com.architect.g1.cocktailfever.ui

import android.app.Application
import android.content.Intent
import android.os.SystemClock
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.architect.g1.cocktailfever.R
import com.architect.g1.cocktailfever.ui.main.MainActivity
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.net.HttpURLConnection
import kotlin.time.ExperimentalTime


class UITest {
    @ExperimentalTime
    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    private lateinit var mockWebServer: MockWebServer
    private lateinit var resource: OkHttp3IdlingResource

    private val position: Int
        get() = 0


    @ExperimentalTime
    @Before
    fun setUp() {
        val instrumentation = InstrumentationRegistry.getInstrumentation()
        val app = instrumentation.targetContext.applicationContext as Application
        val component = DaggerUITestComponent.factory().create(app)

        mockWebServer = component.mockWebServer

        resource = OkHttp3IdlingResource.create("OkHttp", component.cocktailDb.okHttpClient)
        IdlingRegistry.getInstance().register(resource)

        val intent = Intent(instrumentation.targetContext, MainActivity::class.java)

        activityTestRule.launchActivity(intent)

    }

    @ExperimentalTime
    @Test
    fun clickCocktailNavigatesToDetailCheckTitle() {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(uiDetailCocktails)
        )

        SystemClock.sleep(1000)

        // Click on the item
        onView(withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                position,
                click()
            )
        )

        onView(withId(R.id.tv_titulo_preparacion))
            .check(matches(withText(activityTestRule.activity.resources.getString(R.string.string_preparacion))))

    }

    @ExperimentalTime
    @Test
    fun clickCocktailNavigatesToDetailCheckTitleIngredient() {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(uiDetailCocktails)
        )

        SystemClock.sleep(1000)

        // Click on the item
        onView(withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                position,
                click()
            )
        )
        onView(withId(R.id.tv_titulo_ingredientes))
            .check(matches(withText(activityTestRule.activity.resources.getString(R.string.string_ingredientes))))
    }

    @ExperimentalTime
    @Test
    fun clickCocktailNavigatesToDetailListOfIngredientsDisplayed() {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(uiDetailCocktails)
        )

        SystemClock.sleep(1000)

        // Click on the item
        onView(withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                position,
                click()
            )
        )
        onView(withId(R.id.lista_ingredientes))
            .check(matches(isDisplayed()))
    }

    @ExperimentalTime
    @Test
    fun clickCocktailNavigatesToDetailCheckFirstIngredient() {

        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(HttpURLConnection.HTTP_OK)
                .setBody(uiDetailCocktails)
        )

        SystemClock.sleep(1000)

        // Click on the item
        onView(withId(R.id.recycler)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ViewHolder>(
                position,
                click()
            )
        )
        onView(withId(R.id.lista_ingredientes))
            .check(matches(atPosition(0, R.id.nombre_ingrediente, withText("Tequila"))))
    }

    @After
    fun tearDown() {
        mockWebServer.close()
        mockWebServer.shutdown()
        IdlingRegistry.getInstance().unregister(resource)
    }

    private fun atPosition(
        position: Int,
        targetId: Int,
        dataMatcher: Matcher<View>
    ): Matcher<View> {
        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("with class name: ")
                dataMatcher.describeTo(description)
            }

            override fun matchesSafely(view: View): Boolean {
                if (view !is RecyclerView) {
                    return false
                }

                val itemView: View? = view.findViewHolderForAdapterPosition(position)?.itemView

                val textView = itemView?.findViewById<TextView>(targetId)
                if (textView !is TextView) {
                    return false
                }

                return dataMatcher.matches(textView)
            }

        }
    }
}
