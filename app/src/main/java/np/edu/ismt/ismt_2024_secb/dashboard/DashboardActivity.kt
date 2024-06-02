package np.edu.ismt.ismt_2024_secb.dashboard

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import np.edu.ismt.ismt_2024_secb.R
import np.edu.ismt.ismt_2024_secb.databinding.ActivityDashboardBinding


class DashboardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashboardBinding
    private val fragmentManager = supportFragmentManager
    private val homeFragment = HomeFragment()
    private val myItemsFragment = MyItemsFragment()
    private val recommendationFragment = RecommendationFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadRespectiveFragment(homeFragment)
        binding.bottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.home -> {
                    loadRespectiveFragment(homeFragment)
                    true
                }

                R.id.my_items -> {
                    loadRespectiveFragment(myItemsFragment)
                    true
                }

                R.id.recommendations -> {
                    loadRespectiveFragment(recommendationFragment)
                    true
                }

                R.id.profile -> {
                    loadRespectiveFragment(profileFragment)
                    true
                }

                else -> false
            }
        }
    }

    private fun loadRespectiveFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
            .replace(
                binding.fragmentContainerView.id,
                fragment,
                null
            )
            .setReorderingAllowed(true)
            .addToBackStack(null)
            .commit()
    }
}