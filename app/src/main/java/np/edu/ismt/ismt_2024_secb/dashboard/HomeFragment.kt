package np.edu.ismt.ismt_2024_secb.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
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

        //load recycler view
        val adapter = RecommendationHorizontalAdapter(getProductsForRecommendation())

        binding.rvRecommendations.layoutManager = LinearLayoutManager(requireActivity())
        binding.rvRecommendations.adapter = adapter
        return binding.root
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
}