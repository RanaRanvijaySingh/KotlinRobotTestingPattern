package daggerdemo.com.robottestdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val isLoginSuccess = intent.getBooleanExtra("isLoginSuccess", false)
        tvResult.text = if (isLoginSuccess) "Success" else "Failure"
    }
}
