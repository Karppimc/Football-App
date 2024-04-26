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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.football.Header
import com.example.football.MatchDetailItem
import com.example.football.R

@Composable
fun MyApp(navController: androidx.navigation.NavController, viewModel: MatchViewModel = viewModel()) {
    // Observe the matchDetails LiveData
    val matchDetails by viewModel.matchDetails.observeAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {

        Box(

        ) {
            Header(text = stringResource(R.string.ilves_tampere_homegames_2024))
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(text = stringResource(R.string.date), modifier = Modifier.weight(2f), style = MaterialTheme.typography.subtitle1)
            Text(text = stringResource(R.string.teams), modifier = Modifier.weight(3f), style = MaterialTheme.typography.subtitle1)
            Text(text = stringResource(R.string.score), modifier = Modifier.weight(1f), style = MaterialTheme.typography.subtitle1)
        }
        LazyColumn(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()) {
            items(matchDetails) { matchDetail ->
                MatchDetailItem(matchDetail)
            }
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("mapScreen") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(stringResource(R.string.where_to_watch))
        }
    }
}
