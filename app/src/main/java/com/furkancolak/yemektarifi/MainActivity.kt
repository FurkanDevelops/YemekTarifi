package com.furkancolak.yemektarifi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkancolak.yemektarifi.ui.theme.YemekTarifiTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemekTarifiTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(){
    Scaffold(
        topBar = {
            // üst kısım alanı
            TopAppBar(title = { Yazi(icerik = "Yemek Tarifi")},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk),// arka plan rengi
                    titleContentColor = colorResource(id = R.color.black) // yazı rengi
                ))
        },
        content = {
            // tasarım alanı
            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(1f)) {
                Image(painter = painterResource(id = R.drawable.yemekresim), contentDescription = "")

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { Log.e("Button","Begenildi") }
                        , colors = ButtonDefaults.buttonColors(colorResource(id = R.color.anaRenk))
                        , modifier = Modifier.weight(0.5f)) {
                        ButtonYazi("Beğen")
                    }
                    Button(onClick = {Log.e("Button","Yorum Yapildi")}
                        ,colors = ButtonDefaults.buttonColors(colorResource(id = R.color.alternatifRenk))
                        , modifier = Modifier.weight(0.5f) ) {
                        ButtonYazi("Yorum Yap")
                    }
                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 5.dp)) {
                    Text(text = "Köfte",
                        color = colorResource(id = R.color.alternatifRenk),
                        fontSize = 18.sp)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Yazi(icerik = "Izgaraya Uygun")
                        Yazi(icerik = "7 haziran")
                    }
                }
                Text(text = "Köfte harcını hazırlamak için soğanları rendeleyin ve maydonozları ince ince kıyın. İsterseniz, bir diş sarımsak da ekleyebilirsiniz",
                    modifier = Modifier
                    .padding(all = 20.dp)
                    , textAlign = TextAlign.Center
                )
            }
        }
    )
}

@Composable
fun Yazi(icerik : String){
    Text(text = icerik)
}
@Composable
fun ButtonYazi(icerik : String){
    Text(text = icerik, color = Color.Black)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YemekTarifiTheme {
       MainScreen()
    }
}