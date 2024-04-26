import android.os.Bundle
import android.view.ViewGroup
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
    Column(
        modifier = Modifier.fillMaxSize() // Make sure the Column takes up all available space
    ) {
        AndroidView(
            factory = { context ->
                MapView(context).apply {
                    onCreate(Bundle())
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        1900 // Fix the height of the MapView
                    )
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
            },
            update = { mapView ->
                mapView.onResume()
            }
        )

        Button(
            onClick = { navController.navigate("myApp") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp) // Ensure the button has a specified height
        ) {
            Text("Back to Homegames")
        }
    }
}

// Ensure to include necessary lifecycle methods in your Activity or Fragment
