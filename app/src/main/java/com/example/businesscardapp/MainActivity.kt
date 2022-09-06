package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NameWithLogoAndJob()
                    ContactInfo()
                }
            }
        }
    }
}

//lets have a composable that contains the picture, name and header
//will be a column of the three elements

@Composable
fun NameWithLogoAndJob() {
    Column(
        //these details should affect everything in column
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment  = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
       //first up, android image
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.height(100.dp),
            )
        //now our name
        Text(
            text = "Taylor Merwin",
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier.padding(bottom = 8.dp)  //not sure if needed
        )
        Text(
            text = "Android Developer Extraordinaire!",
            color = Color.Green,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun ContactInfo(){
    Column(
        horizontalAlignment  = Alignment.End,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier.padding(8.dp)



        ){
       Box( ){
           Text(
               text = "Phone number",
               textAlign = TextAlign.End,
               modifier = Modifier.padding(end = 16.dp),
               //horizontalAlignment = Alignment.End
           )
       }

        Text(
            text = "Twitter Handle",
            textAlign = TextAlign.Right,
            modifier = Modifier.padding(end = 16.dp)
        )
        Text(
            text = "Email Address",
            textAlign = TextAlign.Right,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardAppTheme {
        NameWithLogoAndJob()
    }
}