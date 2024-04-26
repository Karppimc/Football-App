package com.example.football

import MatchDetail
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchDetailItem(matchDetail: MatchDetail) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "${matchDetail.eventDate}",
            modifier = Modifier
                .weight(2f) // Adjust weight to distribute space evenly
                .padding(end = 8.dp), // Add padding for spacing between elements
            style = typography.h6
        )
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = "${matchDetail.homeTeamName}",
                style = typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )

            Text(
                text = "${matchDetail.awayTeamName}",
                style = typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )
        }
        Column(
            modifier = Modifier
                .weight(1f) // Adjust weight to distribute space evenly
                .padding(start = 8.dp),

        ) {
            Text(
                text = "${matchDetail.goalsHomeTeam ?: "-"}",
                style = typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )
            Text(
                text = "${matchDetail.goalsAwayTeam ?: "-"}",
                style = typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )
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