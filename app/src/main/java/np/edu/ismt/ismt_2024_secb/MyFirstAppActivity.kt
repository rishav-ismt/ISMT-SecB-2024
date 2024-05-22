package np.edu.ismt.ismt_2024_secb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MyFirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_my_first_app)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Redirecting to Login page

        Handler().postDelayed(
            {
                //Fetching SharedPreferences
                val sharedPreferences = this@MyFirstAppActivity
                    .getSharedPreferences(
                        "app",
                        Context.MODE_PRIVATE
                    )

                val isLoggedIn = sharedPreferences.getBoolean(
                    "isLoggedIn",
                    false
                )

                val intent: Intent
                if (isLoggedIn) {
                    //navigating to Login Page
                    intent = Intent(this, DashboardActivity::class.java)
                } else {
                    //navigating to Login Page
                    intent = Intent(this, LoginActivity::class.java)
                }
                startActivity(intent)
                finish()
            },
            2000
        )
    }
}