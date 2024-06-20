package preference

import kotlinx.serialization.Serializable

@Serializable
data class PreferenceData(
    val counter: Int = 0,
)
