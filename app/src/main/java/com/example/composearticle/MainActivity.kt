package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ArticleComposeImage(
                        firstComposeText = stringResource(R.string.compose_first_text),
                        secondComposeText = stringResource(R.string.compose_second_text),
                        thirdComposeText = stringResource(R.string.compose_third_text)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticleComposeImage(
    modifier: Modifier = Modifier, firstComposeText: String,
    secondComposeText: String,
    thirdComposeText: String,
) {
    val composeImage = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Image(
            painter = composeImage,
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        ArticleComposeText(
            firstComposeText = firstComposeText,
            secondComposeText = secondComposeText,
            thirdComposeText = thirdComposeText
        )
    }
}

val firstTextStyle = TextStyle(fontSize = 24.sp)

@Composable
fun ArticleComposeText(
    firstComposeText: String,
    secondComposeText: String,
    thirdComposeText: String,
    modifier: Modifier = Modifier
) {

        Text(
            text = firstComposeText,
            style = firstTextStyle,
            modifier = modifier
                .padding(16.dp),
        )
        Text(
            text = secondComposeText,
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = thirdComposeText,
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArticleTheme {
        ArticleComposeImage(
            firstComposeText = "Jetpack Compose tutorial",
            secondComposeText = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            thirdComposeText = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}