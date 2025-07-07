package com.example.pertemuan2.navigation

/**
 * Kelas sealed `Screen` berfungsi sebagai representasi dari semua rute (route)
 * yang digunakan dalam sistem navigasi aplikasi menggunakan Jetpack Compose Navigation.
 *
 * Setiap objek di dalam sealed class ini mewakili satu halaman (screen) dalam aplikasi.
 *
 * @property route string yang digunakan sebagai identifikasi unik dalam sistem navigasi.
 */
sealed class Screen(val route: String) {

    /**
     * Objek untuk halaman Home.
     * @see com.app.praktikum_kel1_2.screen.HomeScreen
     */
    object Home : Screen(route = "home")

    /**
     * Objek untuk halaman Result.
     * Route memiliki parameter dinamis berupa `text`.
     * Contoh: "result/HaloDunia"
     */
    object Result : Screen(route = "result/{text}") {

        /**
         * Fungsi untuk menghasilkan route lengkap dengan nilai parameter `text`.
         *
         * @param text nilai teks yang akan dikirim ke halaman Result.
         * @return string route lengkap untuk navigasi, misalnya: "result/HaloDunia"
         */
        fun passText(text: String): String {
            return "result/$text"
        }
    }

    /**
     * Objek untuk halaman Profile.
     * @see com.app.praktikum_kel1_2.screen.ProfileScreen
     */
    object Profile : Screen(route = "profile")

    /**
     * Objek untuk halaman Login.
     * @see com.app.praktikum_kel1_2.screen.LoginScreen
     */
    object Login : Screen(route = "login")

    /**
     * Objek untuk halaman Register.
     * @see com.app.praktikum_kel1_2.screen.RegisterScreen
     */
    object Register : Screen(route = "register")
}