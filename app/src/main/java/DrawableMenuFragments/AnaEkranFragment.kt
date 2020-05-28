package DrawableMenuFragments

import Adapter.YakinimdakiOtoparklarAdapter
import android.Manifest
import android.content.Context
import android.content.IntentSender
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.otopark.BaseActivity
import com.example.otopark.R
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.fragment_ana_ekran.*

class AnaEkranFragment : Fragment() {
    var fragment: Fragment? = null
    private var yakinimdakiOtoparklarAdapter: YakinimdakiOtoparklarAdapter? = null
    private val yakinimdakiotoparklarList : List<String> =
    listOf(" Büyük Beşiktaş Otoparkı", "Beşiktaş Kapalı Otopark", "Beltaş Otoparkı", "Ulus Otoparkı")
    private lateinit var map: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationCallback: LocationCallback
    private var locationRequest: LocationRequest? = null
    private var isLocationOpenAsked = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ana_ekran, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as BaseActivity).changeToolbarIconAndTitle("Anasayfa", R.drawable.toolbar_back_icon)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        yakinimdakiOtoparklarAdapter= YakinimdakiOtoparklarAdapter(yakinimdakiotoparklarList)
        autoparkListRecyclerView.adapter=yakinimdakiOtoparklarAdapter
        initializeMap(savedInstanceState)
        initializeLocationApiClientAndCallback()

    }

    private fun initializeMap(savedInstanceState: Bundle?){
        val mapView = view?.findViewById(R.id.mapView) as MapView
        mapView.onCreate(savedInstanceState)
        mapView.onResume() // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(activity?.applicationContext)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mapView.getMapAsync { _map ->
            map = _map
            // For showing a move to my location button
            map.isMyLocationEnabled = true

            map.setOnMapClickListener { marker ->
                val markerOptions = MarkerOptions()
                markerOptions.position(marker)
                map.clear()
                showLocationOnTheMap(marker.latitude, marker.longitude)
            }
        }
    }

    private fun showLocationOnTheMap(latitude: Double, longitude: Double) {
        val locationInLangAndLong = LatLng(latitude, longitude)
        map.addMarker(
            MarkerOptions().position(locationInLangAndLong).title("Marker Title")
                .snippet("Marker Description")
        )

        // For zooming automatically to the location of the marker
        val cameraPosition =
            CameraPosition.Builder().target(locationInLangAndLong).zoom(10f).build()
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
    }

    override fun onResume() {
        super.onResume()
        checkLocationPermission()
    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }
    private fun checkLocationPermission(){
        if (ContextCompat.checkSelfPermission(
                (activity as BaseActivity).applicationContext,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                activity as BaseActivity,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_CODE
            )
        } else {
            checkLocationSetting()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == LOCATION_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(
                        activity as Context,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    checkLocationSetting()
                }
            } else {
                // todo close map and give feedback
            }
            return
        }
    }

    private fun createLocationRequest() {
        locationRequest = LocationRequest.create()?.apply {
            interval = 10000
            fastestInterval = 5000
            priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        }
    }

    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    private fun initializeLocationApiClientAndCallback() {
        fusedLocationClient =
            LocationServices.getFusedLocationProviderClient(activity as BaseActivity)

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                for (location in locationResult.locations) {
                    showLocationOnTheMap(location.latitude, location.longitude)
                    stopLocationUpdates()
                }
            }
        }
    }

    private fun checkLocationSetting(){
        createLocationRequest()
        val builder = locationRequest?.let {
            LocationSettingsRequest.Builder()
                .addLocationRequest(it)
        }

        val client: SettingsClient = LocationServices.getSettingsClient(activity as BaseActivity)
        val task: Task<LocationSettingsResponse> = client.checkLocationSettings(builder?.build())

        task.addOnSuccessListener { _ ->
            // All location settings are satisfied. The client can initialize
            // location requests here.
            // ...
            startLocationUpdates()
        }

        task.addOnFailureListener { exception ->
            if (exception is ResolvableApiException) {
                // Location settings are not satisfied, but this can be fixed
                // by showing the user a dialog.
                if (!isLocationOpenAsked) {
                    try {
                        // Show the dialog by calling startResolutionForResult(),
                        // and check the result in onActivityResult().
                        exception.startResolutionForResult(
                            activity,
                            REQUEST_CHECK_SETTINGS
                        )
                    } catch (sendEx: IntentSender.SendIntentException) {
                        // Ignore the error.
                    }
                    isLocationOpenAsked = true
                } else {
                    Toast.makeText(context, "Location izni vermelisiniz", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun startLocationUpdates(){
        fusedLocationClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = AnaEkranFragment()
        const val LOCATION_PERMISSION_CODE = 100
        const val REQUEST_CHECK_SETTINGS = 99
    }
}
