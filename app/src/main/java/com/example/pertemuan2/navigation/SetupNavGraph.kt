package com.example.pertemuan2.navigation


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pertemuan2.screen.HomeScreen
import com.example.pertemuan2.screen.ResultScreen
import com.example.pertemuan2.screen.LoginScreen
import com.example.pertemuan2.screen.ProfileScreen
import com.example.pertemuan2.screen.RegisterScreen

/**
 * Fungsi `SetupNavGraph` digunakan untuk mengatur struktur navigasi di aplikasi.
 * Di dalamnya didefinisikan semua halaman yang dapat dinavigasi beserta argumen yang dibutuhkan (jika ada).
 *
 * @param navController controller yang digunakan untuk melakukan navigasi antar halaman.
 * @param modifier modifier opsional untuk styling tambahan pada `NavHost`.
 */

@Composable
fun SetupNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route, // Halaman pertama saat aplikasi dijalankan
        modifier = modifier
    ) {
        // Rute ke halaman Home
        composable(route = Screen.Home.route) {
            HomeScreen(navController)
        }

        // Rute ke halaman Result dengan parameter "text"
        composable(
            route = Screen.Result.route,
            arguments = listOf(navArgument("text") {
                type = NavType.StringType // Parameter bertipe String
            })
        ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("text").orEmpty()
            ResultScreen(name, navController)
        }

        // Rute ke halaman Profile
        composable(route = Screen.Profile.route) {
            ProfileScreen(navController)
        }

        // Rute ke halaman Login
        composable(route = Screen.Login.route) {
            LoginScreen(navController)
        }

        // Rute ke halaman Register
        composable(route = Screen.Register.route) {
            RegisterScreen(navController)
        }
    }
}