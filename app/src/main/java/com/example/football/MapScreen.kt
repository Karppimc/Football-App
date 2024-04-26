import android.os.Bundle
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.football.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun MapScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AndroidView(
            factory = { context ->
                MapView(context).apply {
                    onCreate(Bundle())

                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
            },
            modifier = Modifier.weight(1f),
            update = { mapView ->
                mapView.getMapAsync { googleMap ->
                    val tammela = LatLng(61.49990716797935, 23.786237274818504)
                    googleMap.addMarker(
                        MarkerOptions()
                            .position(tammela)
                            .title("Tammela Stadium")
                    )
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tammela, 15f))
                }
                mapView.onResume()
            }
        )

        Button(
            onClick = { navController.navigate("myApp") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(48.dp)
        ) {
            Text(stringResource(R.string.back_to_homegames))
        }
    }
}



