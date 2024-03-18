package com.example.football


import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun OtherScreen(navController: NavController) {
    val mapView = rememberMapViewWithLifecycle()
    AndroidView({ mapView }) { mapView ->
        mapView.getMapAsync { googleMap ->
            val location = LatLng(61.49996618566453, 23.786640452917606) // San Francisco coordinates
            googleMap.addMarker(MarkerOptions().position(location).title("Marker in Tammela Stadium"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 12f))
        }
    }
    Button(onClick = { navController.popBackStack() }) {
        Text("Go Back")
    }

}

@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = MapView(context).apply {
        onCreate(Bundle())
        onResume() // Simplified lifecycle handling for demonstration; adjust as needed
    }
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle) {
        val lifecycleObserver = getMapLifecycleObserver(mapView)
        lifecycle.addObserver(lifecycleObserver)
        onDispose {
            lifecycle.removeObserver(lifecycleObserver)
        }
    }
    return mapView
}

fun getMapLifecycleObserver(mapView: MapView) = LifecycleEventObserver { _, event ->
    when (event) {
        Lifecycle.Event.ON_CREATE -> mapView.onCreate(Bundle())
        Lifecycle.Event.ON_START -> mapView.onStart()
        Lifecycle.Event.ON_RESUME -> mapView.onResume()
        Lifecycle.Event.ON_PAUSE -> mapView.onPause()
        Lifecycle.Event.ON_STOP -> mapView.onStop()
        Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
        else -> {}
    }
}
