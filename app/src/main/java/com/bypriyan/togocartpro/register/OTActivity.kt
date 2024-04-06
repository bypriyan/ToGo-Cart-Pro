package com.bypriyan.togocartpro.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bypriyan.togocartpro.R
import com.bypriyan.togocartpro.register.ui.theme.ToGoCartProTheme

class OTActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToGoCartProTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ViewNewDesign(onBackPressedListener = { finish() })
                }
            }
        }
    }
}

@Composable
fun ViewNewDesign(onBackPressedListener: () -> Unit){


    Column(modifier= Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(color = Color.White)

    ) {
        Card( colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest),modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .background(color = Color.White),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.back_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .width(70.dp)
                        .fillMaxHeight()
                        .size(40.dp)
                        .padding(1.dp, 10.dp, 1.dp)
                        .clickable { onBackPressedListener() } // Call onBackPressedListener when the image is clicked
                )

                Text(text ="OTP Verification",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(7.dp, 15.dp, 10.dp, 5.dp))
            }

        }

        Text(
            text = "We've sent  a verification code to ",
            color = Color.Black,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(15.dp, 70.dp, 0.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "+91-9179593730",
            color = Color.Black,
            fontFamily = FontFamily.Serif,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(0.dp, 5.dp, 0.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        )

        Box() {
            Row (){


            }


        }


    }
}


