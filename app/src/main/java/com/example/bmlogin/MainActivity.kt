package com.example.bmlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmlogin.ui.theme.BMLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMLoginTheme {
                BmLogin()
            }
        }
    }
}

@Composable
fun BmLogin() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, start = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bm_icon),
                    contentDescription = null,
                    modifier = Modifier.padding(start = 30.dp)
                )
            }
            Text(
                text = "EN",                         //////translate//العربية
                fontSize = 20.sp,
                color = Color.Red,
                modifier = Modifier.padding(start = 200.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = userName,
                onValueChange = { userName = it },
                label = { Text(text = "user name") }
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "password") }
            )
            Text(
                fontSize = 15.sp,
                textDecoration = TextDecoration.Underline,
                text = "forgot username/password ?",
                modifier = Modifier
                    .padding(top = 10.dp, end = 150.dp)
                    .alpha(0.9f)
            )
            FilledTonalButton(
                onClick = { },
                shape = RoundedCornerShape(10.dp),
                enabled = userName.isNotEmpty() && password.isNotEmpty(),
                colors = ButtonDefaults.filledTonalButtonColors(
                    containerColor = Color.Red
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minHeight = 50.dp)
                    .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 10.dp, top = 10.dp)
                        .align(alignment = Alignment.CenterVertically)
                )
            }
            Row(modifier = Modifier
                .padding(end = 180.dp, top = 10.dp)) {
                Text(text = "Need help ?")
                Text(
                    text = "Contact Us",
                    color = Color.Red,
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier
                )
            }
            Row(modifier = Modifier
                .padding(all = 20.dp)
                .fillMaxWidth()) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFDB808A))
                    .width(1.dp)
                    .height(1.dp))
            }
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(top = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.our_products),
                    contentDescription = "Our products",
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.exchange_rate),
                    contentDescription = "Exchange\nrate",
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.security_tips),
                    contentDescription = "Security tips",
                    modifier = Modifier
                )
                Image(
                    painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                    contentDescription = "Nearest branch\n or ATM",
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
private fun ImageWithText(modifier: Modifier, text: String, imgIcon: Int) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(top = 24.dp, start = 4.dp, end = 4.dp)
    ) {
        Image(
            painter = painterResource(id = imgIcon),
            contentDescription = "",
            modifier = modifier.size(64.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            fontSize = 12.sp
        )
    }
}