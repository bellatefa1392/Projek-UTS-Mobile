package com.example.beritaterbarusekarang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.beritaterbarusekarang.data.DataSource
import com.example.beritaterbarusekarang.model.Tampil
import com.example.beritaterbarusekarang.ui.theme.BeritaTerbaruSekarangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeritaTerbaruSekarangTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(navController)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { BeritaApp(navController) }
        composable("detail/{beritaId}") { backStackEntry ->
            val beritaId = backStackEntry.arguments?.getString("beritaId")
            DetailScreen(beritaId)
        }
    }
}

@Composable
fun BeritaApp(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        // Judul Aplikasi
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(16.dp)
        )

        // Bagian Berita
        Text(
            text = "BERITA",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 17.dp, top = 17.dp)
        )
        BeritaList(beritaList = DataSource().loadBerita(), navController)

        // Bagian Arsip Berita
        Text(
            text = "ARSIP BERITA",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(start = 17.dp, top = 33.dp)
        )
        BeritaList(beritaList = DataSource().loadArsipBerita(), navController, isArsip = true)
    }
}

@Composable
fun BeritaList(beritaList: List<Tampil>, navController: NavHostController, modifier: Modifier = Modifier, isArsip: Boolean = false) {
    LazyColumn(modifier = modifier) {
        items(beritaList) { berita ->
            BeritaCard(berita = berita, navController, isArsip, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun BeritaCard(berita: Tampil, navController: NavHostController, isArsip: Boolean, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.clickable {
            navController.navigate("detail/${berita.stringResourceId}")
        },
        colors = CardDefaults.cardColors(containerColor = Color(0xFF8AD9CB))
    ) {
        Column {
            Image(
                painter = painterResource(berita.imageResourceId),
                contentDescription = stringResource(berita.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = LocalContext.current.getString(berita.stringResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun DetailScreen(beritaId: String?) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Detail Berita: $beritaId", style = MaterialTheme.typography.titleLarge)
        // Tambahkan informasi lebih lanjut di sini
    }
}