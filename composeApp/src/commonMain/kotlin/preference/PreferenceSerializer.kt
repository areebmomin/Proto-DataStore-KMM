package preference

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.okio.OkioSerializer
import com.areeb.proto_datastore_kmm.PreferenceData
import kotlinx.serialization.SerializationException
import okio.BufferedSink
import okio.BufferedSource

object PreferenceSerializer : OkioSerializer<PreferenceData> {
    override val defaultValue: PreferenceData
        get() = PreferenceData()

    override suspend fun readFrom(source: BufferedSource): PreferenceData {
        try {
            return PreferenceData.ADAPTER.decode(source)
        } catch (serialization: SerializationException) {
            throw CorruptionException("Unable to read UserPrefs", serialization)
        }
    }

    override suspend fun writeTo(t: PreferenceData, sink: BufferedSink) {
        sink.write(t.encode())
    }
}
