package com.bypriyan.togocartpro.register

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bypriyan.togocartpro.R
import com.bypriyan.togocartpro.jetpack.topAppBar
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.mukeshsolanki.OTP_VIEW_TYPE_BORDER
import com.mukeshsolanki.OtpView
import java.util.concurrent.TimeUnit

class OTPActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.white)
                ) {
                    var data= intent.getStringExtra("phoneNumber")
                    if (data != null) {
                        otpLayout({ finish() },data)
                        data = "+91"+data
                        loginWithPhoneNumber(data)
                    }
                }
        }

    }

     fun loginWithPhoneNumber(phoneNumber:String){

        val auth: FirebaseAuth = FirebaseAuth.getInstance()

         var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

         mCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
             override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                 Toast.makeText(applicationContext,"onVerificationCompleted : {${p0.smsCode}}", Toast.LENGTH_LONG).show()
             }

             override fun onVerificationFailed(p0: FirebaseException) {
                 Toast.makeText(applicationContext,"onVerificationFailed : {${p0.message}}", Toast.LENGTH_LONG).show()
             }

             override fun onCodeSent(p0: String, p1: PhoneAuthProvider.ForceResendingToken) {
                 super.onCodeSent(p0, p1)
                 Toast.makeText(applicationContext,"onCodeSent", Toast.LENGTH_LONG).show()

             }
         }


        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(mCallbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }
}

@Composable
fun otpLayout(onBackPressedListener:()->Unit, data:String){

    topAppBar(title = "OTP Verification", onBackPressedListener)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 63.dp)
            .background(color = colorResource(id = R.color.white))
    ) {

        Spacer(modifier = Modifier.height(80.dp))

       var l =  Text(
            text = "We've sent verification code to",
            fontSize = 16.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = FontFamily(Font(R.font.medium))
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "+91 " + data,
            fontSize = 17.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = FontFamily(Font(R.font.bold)),
        )

        Spacer(modifier = Modifier.height(30.dp))

        var otpValue by remember { mutableStateOf("") }
        OtpView(
            otpText = otpValue,
            onOtpTextChange = {
                otpValue = it
            },
            type = OTP_VIEW_TYPE_BORDER,
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            containerSize = 48.dp,
            otpCount = 6,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            charColor = colorResource(id = R.color.black)
        )
        
    }

}