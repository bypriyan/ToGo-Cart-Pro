package com.bypriyan.togocartpro.register

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import coil.compose.AsyncImage
import com.bypriyan.togocartpro.register.ui.theme.ToGoCartProTheme
import com.bypriyan.togocartpro.ui.theme.background
import com.bypriyan.togocartpro.ui.theme.blue
import com.bypriyan.togocartpro.ui.theme.darkGrey

class OnboardingScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    IntroScreen()
                }
        }
    }

}

data class ModelOnboardingScreen(
    var imgUrl : String="hello",
    var title : String="hello",
    var description : String="hello"
)

fun getList() : List<ModelOnboardingScreen>{
    return listOf(
        ModelOnboardingScreen("https://firebasestorage.googleapis.com/v0/b/togo-cart-pro.appspot.com/o/onbording_img%2Fone.jpg?alt=media&token=9c9739c8-abf6-4903-b6fb-ac2d99f1032b",
            "Convenience at your Fingertips",
            "Enjoy the ease of ordering groceries from the comfort of your home. Say goodbye to crowded aisles and long queues. With our app, grocery shopping is just a tap away."),

        ModelOnboardingScreen("https://firebasestorage.googleapis.com/v0/b/togo-cart-pro.appspot.com/o/onbording_img%2Ftwo.jpg?alt=media&token=0cd6bf41-6204-4bd4-be63-1c278633f598",
            "Wide Range of Products",
            "Explore a vast selection of fresh produce, pantry essentials, household items, and more. Whether it's organic fruits and vegetables or specialty ingredients, we've got you covered."),

        ModelOnboardingScreen("https://firebasestorage.googleapis.com/v0/b/togo-cart-pro.appspot.com/o/onbording_img%2Fthree.jpg?alt=media&token=06713f7d-3346-44a8-803f-859fc3015e81",
            "Customized Shopping Experience",
            "Tailor your orders to fit your needs with personalized preferences and favorite items. Save time by creating shopping lists for quick and hassle-free reordering."),

        ModelOnboardingScreen("https://firebasestorage.googleapis.com/v0/b/togo-cart-pro.appspot.com/o/onbording_img%2Ffour.jpg?alt=media&token=c16e3772-07e2-4c50-b81a-64653bbcb549",
            "Reliable Delivery Service",
            "Rest assured knowing your groceries will be delivered promptly to your doorstep. Our dedicated team ensures safe handling and timely delivery, so you can focus on what matters most."),

        )
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroScreen() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    val list = getList()

    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Box(modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()){

            HorizontalPager(state = pagerState ) { page ->

                Column (verticalArrangement = Arrangement.Center){
                    //img
                    AsyncImage(model = list.get(page).imgUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(500.dp))

                    //title
                    Text(text = list.get(page).title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        color = background,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp,
                        textAlign = TextAlign.Center,
                    )
                    //desc
                    Text(text = list.get(page).description,
                        textAlign = TextAlign.Justify,
                        color = darkGrey,
                        fontWeight = FontWeight.Medium,
                        fontSize =15.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp,10.dp,10.dp,10.dp)
                    )
                }
                // Our page content

            }
        }

    }

}
