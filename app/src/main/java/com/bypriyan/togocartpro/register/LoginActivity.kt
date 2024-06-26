package com.bypriyan.togocartpro.register

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.airbnb.lottie.compose.rememberLottieDynamicProperty
import com.bypriyan.togocartpro.R
import com.bypriyan.togocartpro.register.ui.theme.ToGoCartProTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                showLoginScreen()
            }
        }

        CoroutineScope(Dispatchers.IO).launch {

        }
    }
}

@Preview()
@Composable
fun showLoginScreen(){

    var context = LocalContext.current
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.login_sc_grocery_anim) )

    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .verticalScroll(rememberScrollState())) {

        Image(painter = painterResource(id = R.drawable.login_screen_grocery_image),
            contentDescription =null,
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.TopCenter)

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(60.dp))

        Text(text = "Grocery delivery\nin minutes",
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.black)),
                fontSize = 26.sp,
                color = colorResource(id = R.color.black))

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(10.dp))

            Text(text = "Login or Signup",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 16.sp,
                color = colorResource(id = R.color.dark_greay))

            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(30.dp))

        var phoneNumber by remember{ mutableStateOf("") }

        OutlinedTextField(value = phoneNumber, onValueChange = {
                text->if(text.length<=10){
            phoneNumber=text
        }},
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 0.dp, 15.dp, 8.dp),
            singleLine = true,
            placeholder = { Text(text = "Enter phone number",
                color = colorResource(id = R.color.dark_greay),
                fontFamily = FontFamily(Font(R.font.medium))
            )},
            textStyle = TextStyle(fontFamily = FontFamily(Font(R.font.semibold)),
                fontSize = 15.sp),
            prefix = {
                    Text(text = "+91",
                        color = colorResource(id = R.color.black),
                        fontFamily = FontFamily(Font(R.font.bold)),
                        fontSize = 15.sp)
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
            colors =TextFieldDefaults.colors(
                cursorColor = colorResource(id = R.color.black),
                focusedTextColor = colorResource(id = R.color.black),
                unfocusedContainerColor = colorResource(id = R.color.white),
                focusedContainerColor = colorResource(id = R.color.white),
                unfocusedTextColor = colorResource(id = R.color.dark_greay),
                focusedIndicatorColor = colorResource(id = R.color.black),
                unfocusedIndicatorColor = colorResource(id = R.color.black)),
            shape = RoundedCornerShape(12.dp),
            trailingIcon = {
                IconButton(onClick = { phoneNumber="" },
                    enabled = phoneNumber.length>0) {
                    Icon(
                        imageVector = Icons.Filled.Clear,
                        contentDescription = "Localized description"
                    )
                }
            })

        Row (modifier = Modifier.padding(20.dp,0.dp,15.dp,0.dp)){

            Image(painter = painterResource(id = R.drawable.security), contentDescription =null,
                modifier = Modifier
                    .width(13.dp)
                    .height(13.dp),
                colorFilter = ColorFilter.tint(colorResource(id = R.color.appColor)))

            Text(text = "Your number is secured with 128-AES Encryption",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp, 0.dp, 15.dp, 0.dp),
                textAlign = TextAlign.Start,
                fontSize = 12.sp,
                color = colorResource(id = R.color.background)
            )
        }

        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(10.dp))

        Button(
            onClick = {
                if(phoneNumber.length==10){
                    var intent = Intent(context, OTPActivity::class.java)
                    intent.putExtra("phoneNumber",phoneNumber)
                    context.startActivity(intent)
                } },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(15.dp, 20.dp, 15.dp, 0.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(15.dp),
            enabled = phoneNumber.length == 10,
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.appColor))
        ) {
            Text(text = "Send OTP")
        }


        Spacer(modifier = Modifier
            .fillMaxWidth()
            .height(40.dp))

    }

}

