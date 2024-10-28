package com.example.tugasmyshop

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tugasmyshop.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding untuk mengakses view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set nama yang akan dipassing
        val nama = "Assifa Khairu Nisa"

        // Simpan nama ke SharedPreferences
        val sharedPreferences = getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("EXTRA_NAMA", nama)
        editor.apply()

        // Menghubungkan BottomNavigationView dengan NavController
        val bottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)

        // Tidak perlu memanggil loadFragment di sini
        // Fragment akan ditangani oleh NavController
    }
}
