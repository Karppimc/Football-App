package com.example.football
import MatchDetail
import MatchDetails
import MatchViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.football.ui.theme.FootballTheme
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(viewModel: MatchViewModel = viewModel()) {
    // Observe the matchDetails LiveData
    val matchDetails by viewModel.matchDetails.observeAsState(initial = emptyList())


    // Use LazyColumn to display the list
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(matchDetails) { matchDetail ->
            MatchDetailItem(matchDetail)
        }
    }
}
val typography = Typography(
    h6 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    subtitle1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        letterSpacing = 0.15.sp
    )

)

@Composable
fun MatchDetailItem(matchDetail: MatchDetail) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Date: ${matchDetail.eventDate}", style = typography.h6)
        Text(text = "Home: ${matchDetail.homeTeamName}", style = typography.subtitle1)
        Text(text = "Away: ${matchDetail.awayTeamName}", style = typography.subtitle1)
    }
}









