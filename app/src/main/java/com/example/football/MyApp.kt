import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.football.MatchDetailItem

@Composable
fun MyApp(navController: androidx.navigation.NavController, viewModel: MatchViewModel = viewModel()) {
    // Observe the matchDetails LiveData
    val matchDetails by viewModel.matchDetails.observeAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {
        // Use LazyColumn to display the list
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = "Ilves Tampere Homegames 2024", style = MaterialTheme.typography.h5)
        }
        LazyColumn(modifier = Modifier.weight(1f).fillMaxWidth()) {
            items(matchDetails) { matchDetail ->
                MatchDetailItem(matchDetail)
            }
        }

        // Space for the button, making sure it's always at the bottom
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("otherScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Where to watch")
        }
    }
}
