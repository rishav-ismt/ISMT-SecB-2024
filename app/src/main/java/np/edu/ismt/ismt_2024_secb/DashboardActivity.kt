package np.edu.ismt.ismt_2024_secb

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.ismt_2024_secb.databinding.ActivityDashboardBinding

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val receivedEmail = intent
            .getStringExtra(Constants.ENTERED_EMAIL)

        val receivedTest = intent
            .getParcelableExtra<Test>(Constants.KEY_TEST_OBJECT)
        Toast.makeText(
            this@DashboardActivity,
            "Received Test Variable1: ".plus(receivedTest?.variable1),
            Toast.LENGTH_SHORT
        ).show()
    }
}