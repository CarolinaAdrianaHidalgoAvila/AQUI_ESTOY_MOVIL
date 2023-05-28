package com.example.aqui_estoy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class Create_Pet_Found : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var googleMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_pet_found)
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        // Configurar opciones del mapa (por ejemplo, activar la interacción del usuario)
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isCompassEnabled = true

        // Establecer marcador en una ubicación predeterminada o según los datos del formulario
        val defaultLocation = LatLng(40.7128, -74.0060) // Ejemplo: Nueva York
        googleMap.addMarker(MarkerOptions().position(defaultLocation).title("Ubicación"))

        // Mover la cámara del mapa a la ubicación predeterminada
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(defaultLocation, 12f))
    }
}