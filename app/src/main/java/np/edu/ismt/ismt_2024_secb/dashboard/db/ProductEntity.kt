package np.edu.ismt.ismt_2024_secb.dashboard.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import np.edu.ismt.ismt_2024_secb.dashboard.PregnancyState

@Entity(tableName = "product_table")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String? = "",
    val price: String? = "",
    val description: String? = "",
    val category: String? = "",
    @ColumnInfo(name = "item_required_time")
    val itemRequiredTime: PregnancyState,
    @ColumnInfo("mark_as_purchased")
    val markAsPurchased: Boolean = false,
    @ColumnInfo(name = "location_lat")
    val locationLat: String? = "",
    @ColumnInfo(name = "location_lng")
    val locationLng: String? = "",
    val image: String = ""
)
