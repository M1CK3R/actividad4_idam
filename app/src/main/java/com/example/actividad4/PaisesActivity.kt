package com.example.actividad4

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.actividad4.instances.RetrofitInstance
import com.example.actividad4.models.Paises
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PaisesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.paises)

        val countryNameTextView1: TextView = findViewById(R.id.countryNameTextView1)
        val countryFlagTextView1: TextView = findViewById(R.id.countryFlagTextView1)

        val countryNameTextView2: TextView = findViewById(R.id.countryNameTextView2)
        val countryFlagTextView2: TextView = findViewById(R.id.countryFlagTextView2)

        val countryNameTextView3: TextView = findViewById(R.id.countryNameTextView3)
        val countryFlagTextView3: TextView = findViewById(R.id.countryFlagTextView3)

        // Llamada a la API para obtener países específicos
        val specificCountries = listOf("Guatemala", "El Salvador", "Honduras")

        specificCountries.forEachIndexed { index, countryName ->
            RetrofitInstance.api.getCountriesByName(countryName).enqueue(object : Callback<List<Paises>> {
                override fun onResponse(call: Call<List<Paises>>, response: Response<List<Paises>>) {
                    if (response.isSuccessful) {
                        val country = response.body()?.firstOrNull()
                        if (country != null) {
                            when (index) {
                                0 -> {
                                    countryNameTextView1.text = country.nombre.common
                                    countryFlagTextView1.text = country.bandera
                                }
                                1 -> {
                                    countryNameTextView2.text = country.nombre.common
                                    countryFlagTextView2.text = country.bandera
                                }
                                2 -> {
                                    countryNameTextView3.text = country.nombre.common
                                    countryFlagTextView3.text = country.bandera
                                }
                            }
                        }
                    } else {
                        Toast.makeText(this@PaisesActivity, "Error al cargar $countryName", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<List<Paises>>, t: Throwable) {
                    Toast.makeText(this@PaisesActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}