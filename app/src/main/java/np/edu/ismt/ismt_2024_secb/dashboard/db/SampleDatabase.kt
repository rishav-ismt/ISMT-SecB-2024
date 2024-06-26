package np.edu.ismt.ismt_2024_secb.dashboard.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [ProductEntity::class],
    version = 1
)
abstract class SampleDatabase: RoomDatabase() {
    companion object {
        fun getInstance(applicationContext: Context): SampleDatabase {
            return Room.databaseBuilder(
                applicationContext,
                SampleDatabase::class.java,
                "sample_db"
            ).build()
        }
    }

    abstract fun getProductDao(): ProductDao
}