package preference

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.areeb.protodatastorekmm.AndroidPlatformContextProvider
import junit.framework.TestCase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PreferenceImplAndroidTest {

    private lateinit var preference: Preference

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        AndroidPlatformContextProvider.setContext(context)
        preference = PreferenceImpl()
    }

    @Test
    fun testUpdateAndGetLastSelectedLocality() = runBlocking {
        preference.updateCounter()

        val counterValue = preference.getCounter().first()

        TestCase.assertEquals(1, counterValue)
    }
}
