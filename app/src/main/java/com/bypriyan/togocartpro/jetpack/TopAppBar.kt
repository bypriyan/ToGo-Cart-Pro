package com.bypriyan.togocartpro.jetpack

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bypriyan.togocartpro.R
import com.bypriyan.togocartpro.register.otpLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun topAppBar(title: String, onBackpressedListner: () -> Unit) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.white),
                    titleContentColor = colorResource(id = R.color.black),
                ),
                title = {
                    Text(
                        title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(
                            Font(R.font.bold),
                        )
                    )
                },
                navigationIcon = {
                    IconButton(onClick =
                       onBackpressedListner
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        },
    ) { innerPadding ->null
    }
}