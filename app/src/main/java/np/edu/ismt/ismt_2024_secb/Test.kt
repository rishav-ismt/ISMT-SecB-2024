package np.edu.ismt.ismt_2024_secb

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Test(
    val variable1: String,
    val variable2: Int
): Parcelable