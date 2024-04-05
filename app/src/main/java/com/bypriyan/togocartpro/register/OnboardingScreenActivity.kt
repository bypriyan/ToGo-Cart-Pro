package com.bypriyan.togocartpro.register

import android.content.Intent
import android.graphics.Paint.Align
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.bypriyan.togocartpro.R




class OnboardingScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    showStartScreen()
                }
        }
    }



}

@Preview()
@Composable
fun showStartScreen(){

    var context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White)
        .verticalScroll(rememberScrollState())) {

        Box (modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)){

            Image(painter = painterResource(id = R.drawable.solid_bottom_circle_bg)
                , contentDescription =null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillBounds)

            Image(painter = painterResource(id = R.drawable.new_login_sc_women_ng)
                , contentDescription =null,
                modifier = Modifier
                    .width(400.dp)
                    .fillMaxHeight()
                    .align(Alignment.BottomCenter),
                alignment = Alignment.BottomCenter)

        }



        val text = buildAnnotatedString {
            pushStyle(SpanStyle(color = Color.Black))
            append("Let's find the ")
            pushStyle(SpanStyle(colorResource(id = R.color.appColor))) // Change the color of "Best" to red
            append("Best")
            pop()
            append(" &\n")
            pushStyle(SpanStyle(colorResource(id = R.color.appColor))) // Change the color of "Healthy Grocery" to blue
            append("Healthy Grocery")
            pop()
        }

        Text(text = text,
            modifier = Modifier
                .padding(0.dp, 12.dp, 0.dp, 10.dp)
                .fillMaxWidth(),
            fontSize = 28.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily(Font(R.font.black))
        )

        Text(text = "Discover a Bounty of Freshness: Your Premier Destination for the Best &" +
                " Healthy Grocery Selections, Delivered Conveniently to Your Doorstep",
            color = colorResource(id = R.color.dark_greay),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp, 5.dp, 15.dp, 10.dp),
            fontSize = 14.sp)

        Button(
            onClick = {val intent = Intent(context, LoginActivity::class.java)
                      context.startActivity(intent)
                      },
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(15.dp, 20.dp, 15.dp, 0.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(15.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.appColor))
        ) {
            Text(text = "Let's Get Started")
        }

    }

}





