package daggerdemo.com.robottestdemo

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun loginSuccessTest() {
        login {
            email("rana.singh@globant.com")
            password("12345")
        } clickLogin  {
            isSuccess()
        }
    }

    @Test
    fun loginSuccessFailure() {
        login {
            email("rana.singhglobant.com")
            password("12345")
        } clickLogin  {
            isFailure()
        }
    }
}