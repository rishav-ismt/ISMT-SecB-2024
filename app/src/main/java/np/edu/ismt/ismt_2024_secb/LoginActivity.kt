package np.edu.ismt.ismt_2024_secb

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import np.edu.ismt.ismt_2024_secb.dashboard.DashboardActivity
import np.edu.ismt.ismt_2024_secb.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private val TAG = "LoginActivity"
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Log.i(TAG, "onCreate: ")

        binding.tvMessage.text = "Login Page"
        binding.btnLogin.setOnClickListener {
            val email = binding.tieEmail.text?.toString()?.trim()
            val password = binding.tiePassword.text?.toString()?.trim()

            if (email.isNullOrEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter an email",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter an valid email",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (password.isNullOrEmpty()) {
                Toast.makeText(
                    this@LoginActivity,
                    "Please enter an password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // TODO Proceed for server/local-db validation
                val sharedPreferences = this@LoginActivity.getSharedPreferences(
                    "app",
                    Context.MODE_PRIVATE
                )
                val sharedPrefEditor = sharedPreferences.edit()
                sharedPrefEditor.putBoolean(
                    "isLoggedIn",
                    true
                )
                sharedPrefEditor.apply()

                val test = Test(
                    variable1 = "This is test",
                    variable2 = 29
                )

                val intent = Intent(
                    this@LoginActivity,
                    DashboardActivity::class.java
                )
                intent.putExtra(Constants.ENTERED_EMAIL, email)
                intent.putExtra(Constants.KEY_TEST_OBJECT, test)
                startActivity(intent)
                finish()

            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }
}