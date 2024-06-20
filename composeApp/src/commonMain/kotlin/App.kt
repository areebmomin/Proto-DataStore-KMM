import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import preference.Preference
import preference.PreferenceImpl

@Composable
@Preview
fun App() {
    MaterialTheme {
        val composableScope = rememberCoroutineScope()
        val preference: Preference = remember { PreferenceImpl() }
        val counter by preference.getCounter().collectAsState(initial = 0)

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Button(
                onClick = {
                    composableScope.launch {
                        preference.updateCounter()
                    }
                },
            ) {
                Text("Click me! Counter: $counter")
            }
        }
    }
}
