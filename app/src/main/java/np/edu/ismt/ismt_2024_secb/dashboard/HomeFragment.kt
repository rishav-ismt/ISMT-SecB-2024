package np.edu.ismt.ismt_2024_secb.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import np.edu.ismt.ismt_2024_secb.R
import np.edu.ismt.ismt_2024_secb.dashboard.adapters.RecommendationHorizontalAdapter
import np.edu.ismt.ismt_2024_secb.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentHomeBinding.inflate(
           layoutInflater,
           container,
           false
       )
        loadRecommendations()
        loadAddItemPage()
        return binding.root
    }

    private fun loadRecommendations() {
        //load recycler view
        val adapter = RecommendationHorizontalAdapter(getProductsForRecommendation())
        binding.rvRecommendations.layoutManager = LinearLayoutManager(
            requireActivity(),
            RecyclerView.HORIZONTAL,
            false
        )
        binding.rvRecommendations.adapter = adapter
    }


    private fun getProductsForRecommendation(): List<Product> {
        val products = mutableListOf<Product>()

        val product1 = Product(
            name = "Product 1",
            category = "Category 1",
            itemRequiredTime = PregnancyState.PRE_BIRTH
        )
        products.add(product1)

        val product2 = Product(
            name = "Product 2",
            category = "Category 2",
            itemRequiredTime = PregnancyState.PRE_BIRTH
        )
        products.add(product2)

        val product3 = Product(
            name = "Product 3",
            category = "Category 3",
            itemRequiredTime = PregnancyState.PRE_BIRTH
        )
        products.add(product3)

        return products
    }

    private fun loadAddItemPage() {
        binding.fabAddItem.setOnClickListener {
            val intent = Intent(
                requireActivity(),
                AddOrUpdateActivity::class.java
            )
            startActivity(intent)
        }
    }
}