package com.example.football

import MatchDetail
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MatchDetailItem(matchDetail: MatchDetail) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = " ${matchDetail.eventDate}", style = typography.h6)
        Text(text = " ${matchDetail.homeTeamName}", style = typography.subtitle1)
        Text(text = " ${matchDetail.awayTeamName}", style = typography.subtitle1)
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