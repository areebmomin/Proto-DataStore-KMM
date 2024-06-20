package preference

import androidx.datastore.core.DataStore
import com.areeb.proto_datastore_kmm.PreferenceData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface Preference {
    suspend fun updateCounter()
    fun getCounter(): Flow<Int>
}

class PreferenceImpl(private val dataStore: DataStore<PreferenceData> = getDataStore()) :
    Preference {

    override suspend fun updateCounter() {
        dataStore.updateData { data ->
            data.copy(counter = data.counter + 1)
        }
    }

    override fun getCounter(): Flow<Int> {
        return dataStore.data.map { data ->
            data.counter
        }
    }
}
