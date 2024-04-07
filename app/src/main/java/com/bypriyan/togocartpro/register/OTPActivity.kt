package com.bypriyan.togocartpro.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bypriyan.togocartpro.jetpack.topAppBar

class OTPActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val data= intent.getStringExtra("phoneNumber")
                    if (data != null) {
                        otpLayout({ finish() },data)
                    }
                }
        }

    }

}
@Composable
fun otpLayout(onBackPressedListener:()->Unit, data:String){

    topAppBar(title = "OTP Verification", onBackPressedListener)

    Column {
        Spacer(modifier = Modifier.height(63.dp))
        Text(
            text = "We've sent verification code to",
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "+91-"+data,
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}
