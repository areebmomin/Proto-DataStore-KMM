package preference

import androidx.datastore.core.DataStore
import com.areeb.proto_datastore_kmm.PreferenceData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class PreferenceImplIosTest {

    private lateinit var preference: Preference
    private var dataStore: DataStore<PreferenceData> = getDataStore()

    @BeforeTest
    fun setup() {
        preference = PreferenceImpl(dataStore)
    }

    @AfterTest
    fun tearDown() {
        runBlocking {
            dataStore.updateData {
                it.copy(counter = 0)
            }
        }
    }

    @Test
    fun testUpdateAndGetLastSelectedLocality() = runBlocking {
        preference.updateCounter()

        val counterValue = preference.getCounter().first()

        assertEquals(1, counterValue)
    }
}
