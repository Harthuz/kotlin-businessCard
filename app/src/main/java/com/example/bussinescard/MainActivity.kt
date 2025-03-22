package com.example.bussinescard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinescard.ui.theme.BussinesCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BussinesCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ){
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.align(Alignment.Center)
        ){
            Icon(
                painter = painterResource(R.drawable.android_24dp_e3e3e3),
                contentDescription = stringResource(R.string.android_logo),
                modifier = Modifier
                    .size(120.dp),
                )
            Text(
                text = stringResource(R.string.nome_completo),
                modifier = Modifier.padding(bottom = 8.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.funcao),
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )
        }

        Column (
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            CriarRow(R.drawable.call_24dp_e3e3e3, R.string.numero_telefone, R.string.numero_telefone)
            CriarRow(R.drawable.share_24dp_e3e3e3, R.string.username, R.string.nome_de_usuario)
            CriarRow(R.drawable.email_24dp_e3e3e3, R.string.email, R.string.email_do_usuario)
        }
    }

}

@Composable
fun CriarRow(icon: Int, texto: Int, description: Int){
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 8.dp),
    ){
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = description),
            modifier = Modifier
                .padding(end = 8.dp)
                .size(24.dp)
        )
        Text(text = stringResource(id = texto))
    }
}

@Preview(
    showBackground = true,
    device = "spec:width=411dp,height=891dp",
    showSystemUi = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCard()
}