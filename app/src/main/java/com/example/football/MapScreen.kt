import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapScreen(navController: NavController) {
    Column {
        AndroidView(factory = { context ->
            MapView(context).apply {
                onCreate(Bundle())
                getMapAsync { googleMap ->
                    val sydney = LatLng(61.49990716797935, 23.786237274818504)
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(sydney)
                            .title("Marker in Tammela Stadium")
                    )
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15f))
                }
            }
        }, update = { mapView ->
            mapView.onResume()
        })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("myApp") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Back to Homegames")
        }
    }
}
