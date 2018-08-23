package daggerdemo.com.robottestdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener(View.OnClickListener {
            val email = tilEmail.text.toString()
            val password = tilPassword.text.toString()
//            gotoHomeScreen(isValidEmail(email) && isCorrectPassword(password))
            tvLoginResult.text = if (isValidEmail(email) && isCorrectPassword(password))
                "Success" else "Failure"
        })
    }

    private fun gotoHomeScreen(isLoginSuccess: Boolean) {
        val intent = Intent(this, HomeActivity::class.java)
        intent.putExtra("isLoginSuccess", isLoginSuccess)
        startActivity(intent)
    }

    private fun isCorrectPassword(password: String) = password.equals("12345")

    private fun isValidEmail(email: String) =
            email.isNotEmpty() && email.contains("@") && email.contains(".")
}
