import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject

class MatchViewModel : ViewModel() {
    val matchDetails = liveData(Dispatchers.IO) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api-football-v1.p.rapidapi.com/v2/fixtures/team/1163/5993?timezone=Europe%2FLondon")
            .get()
            .addHeader("X-RapidAPI-Key", "76ee0be15fmsh80b08c273cf81eap1713cfjsn01ad4da05175")
            .addHeader("X-RapidAPI-Host", "api-football-v1.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
        val responseBody = response.body?.string()

        val matchDetailsList = mutableListOf<MatchDetail>()

        if (response.isSuccessful && !responseBody.isNullOrEmpty()) {
            val json = JSONObject(responseBody)
            val fixtures = json.getJSONObject("api").getJSONArray("fixtures")

            for (i in 0 until fixtures.length()) {
                val fixture = fixtures.getJSONObject(i)
                val eventDateWithTime = fixture.getString("event_date")
                val eventDate = eventDateWithTime.substring(8, 10) + "." + eventDateWithTime.substring(5, 7)
                val homeTeamName = fixture.getJSONObject("homeTeam").getString("team_name")
                val awayTeamName = fixture.getJSONObject("awayTeam").getString("team_name")
                val goalsHomeTeam = fixture.optInt("goalsHomeTeam", -1) // Use optInt to handle null and provide a default value
                val goalsAwayTeam = fixture.optInt("goalsAwayTeam", -1)

                if (homeTeamName == "Ilves Tampere") {
                    matchDetailsList.add(MatchDetail(eventDate, homeTeamName, awayTeamName, goalsHomeTeam.takeIf { it >= 0 }, goalsAwayTeam.takeIf { it >= 0 }))
                }
            }
        }

        emit(matchDetailsList)
    }
}


data class MatchDetail(
    val eventDate: String,
    val homeTeamName: String,
    val awayTeamName: String,
    val goalsHomeTeam: Int?,
    val goalsAwayTeam: Int?
)

