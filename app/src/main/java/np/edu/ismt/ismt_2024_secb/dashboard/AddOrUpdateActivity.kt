package np.edu.ismt.ismt_2024_secb.dashboard

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import np.edu.ismt.ismt_2024_secb.R
import np.edu.ismt.ismt_2024_secb.dashboard.db.SampleDatabase
import np.edu.ismt.ismt_2024_secb.databinding.ActivityAddOrUpdateBinding

class AddOrUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddOrUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddOrUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //TODO-Remove
        val sampleDb = SampleDatabase.getInstance(this.applicationContext)
        val productDao = sampleDb.getProductDao()

        Thread {
            productDao.getAllProducts()
            runOnUiThread {

            }
        }.start()

    }
}