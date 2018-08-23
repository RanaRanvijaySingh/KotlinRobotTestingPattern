package daggerdemo.com.robottestdemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText

fun login(func: LoginRobot.() -> Unit) = LoginRobot().apply(func)

class LoginRobot {
    fun email(email: String) {
        onView((withId(R.id.tilEmail)))
                .perform(typeText(email))
    }

    fun password(password: String) {
        onView((withId(R.id.tilPassword)))
                .perform(typeText(password))
    }

    infix fun clickLogin(func: ResultRobot.() -> Unit): ResultRobot {
        onView((withId(R.id.btnLogin))).perform(click())
        return ResultRobot().apply(func)
    }
}

class ResultRobot {
    fun isSuccess(): ResultRobot {
        onView(withId(R.id.tvLoginResult)).check(matches(withText("Success")))
        return this
    }

    fun isFailure(): ResultRobot {
        onView(withId(R.id.tvLoginResult)).check(matches(withText("Failure")))
        return this
    }
}