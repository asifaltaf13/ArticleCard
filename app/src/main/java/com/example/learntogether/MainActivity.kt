package com.example.learntogether

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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.LearnTogetherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnTogetherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        headingString = stringResource(id = R.string.heading_text),
        shortDescString = stringResource(id = R.string.first_paragraph_text),
        longDescString = stringResource(id = R.string.second_paragraph_text),
        bannerPainter = painterResource(id = R.drawable.bg_compose_background)
    )
}

@Composable
fun ArticleCard(headingString: String, shortDescString: String, longDescString: String, bannerPainter: Painter) {
    Column {
        BannerImage(bannerPainter)
        HeadingText(headingString)
        ParagraphText(shortDescString)
        ParagraphText(longDescString)
    }
}

@Composable
fun BannerImage(bannerPainter: Painter) {
    Image(
        painter = bannerPainter,
        contentDescription = null,
        alignment = Alignment.TopCenter,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun HeadingText(content: String) {
    Text(
        text = content,
        fontSize = 24.sp,
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
    )
}

@Composable
fun ParagraphText(paragraphContent: String) {
    Text(
        text = paragraphContent,
        fontSize = 18.sp,
        modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    LearnTogetherTheme {
        ComposeArticleApp()
    }
}