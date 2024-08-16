import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.zalo.safaricomtask.data.model.SavingsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavingsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavingsItems(savingsEntities: List<SavingsEntity>)

    @Query("SELECT * FROM savings")
    fun getAllSavingsItems(): Flow<List<SavingsEntity>>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSavingsItem(savingsEntity: SavingsEntity)

    @Query("DELETE FROM savings")
    suspend fun deleteSavingsEntries()

}