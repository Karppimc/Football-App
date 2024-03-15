package com.example.football
import MatchViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel


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












