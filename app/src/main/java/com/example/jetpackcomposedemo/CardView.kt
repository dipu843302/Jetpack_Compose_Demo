package com.example.jetpackcomposedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CardView(){
    Card(modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(25.dp,25.dp,25.dp,25.dp),
        elevation = 5.dp
    ) {
    Box(modifier = Modifier.height(200.dp)) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription =""
        , contentScale = ContentScale.Crop)
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
            contentAlignment= Alignment.BottomStart){
            Text(text="Dipu Kumar", style = TextStyle(color= Color.White, fontSize = 16.sp))

        }
    }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Surface(Modifier.fillMaxSize()) {
        CardView()
    }
}
