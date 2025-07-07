package com.example.pertemuan2.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan2.navigation.Screen

/**
 * Composable `ResultScreen` menampilkan halaman hasil setelah pengguna mengisi data di HomeScreen.
 * Halaman ini menerima nama sebagai parameter dan menampilkan ucapan sapaan,
 * serta tombol untuk kembali ke halaman Home.
 *
 * @param name nama pengguna yang diterima dari halaman sebelumnya.
 * @param navController controller navigasi untuk kembali ke halaman Home.
 */
@Composable
fun ResultScreen(name: String, navController: NavController) {
    // Box digunakan untuk menempatkan isi di tengah layar
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Kolom vertikal berisi teks dan tombol
        Column(modifier = Modifier.padding(16.dp)) {
            // Menampilkan sapaan kepada pengguna
            Text(
                text = "Halo, $name!",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Tombol untuk kembali ke halaman Home
            Button(
                onClick = {
                    navController.navigate(route = Screen.Home.route)
                }
            ) {
                Text("Kembali")
            }
        }
    }
}

/**
 * Preview `ResultScreen` untuk tampilan di Android Studio Preview.
 * Menggunakan `rememberNavController` sebagai dummy NavController.
 */
@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    ResultScreen(
        name = "Preview User",
        navController = rememberNavController()
    )
}