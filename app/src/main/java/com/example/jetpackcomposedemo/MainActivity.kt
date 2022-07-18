package com.example.jetpackcomposedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }

    data class User(
        val id: Int
    )

    @Composable
    fun MainContent() {
        val user = User(1)
        val users = remember { mutableStateListOf(user) }
        Box(modifier = Modifier.fillMaxSize()) {
            UserList(user = users)
            Button(modifier = Modifier
                .padding(24.dp)
                .align(Alignment.BottomCenter),
                onClick = {
                    users.add(User(1))
                }
            ) {
                Text(text = "Add More")
            }
        }
    }

    @Composable
    fun UserList(user: List<User>) {
        LazyColumn {
            items(user) {
                UserCard()
            }
        }
    }

    @Composable
    fun UserCard() {
        val context = LocalContext.current
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .border(width = 1.dp, color = Color.Gray)
                .padding(12.dp)
        )
        {
           Card(shape = RoundedCornerShape(25.dp,25.dp,25.dp,25.dp), modifier = Modifier.padding(end=10.dp)) {
               Image(
                   painter = painterResource(id = R.drawable.ic_launcher_background),
                   contentDescription = "",
                   modifier = Modifier.size(100.dp)

               )
           }

            Column {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style= SpanStyle(
                                color= Color.Green,
                                fontSize = 40.sp
                            )
                        ){
                            append("D")
                        }
                        append("ipu ")
                        withStyle(
                            style= SpanStyle(
                                color= Color.Green,
                                fontSize = 40.sp
                            )
                        ){
                            append("K")
                        }
                        append("umar")
                    },
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
                Button(
                    onClick = {
                        Toast.makeText(context, "Hey", Toast.LENGTH_SHORT).show()
                    }) {
                    Text(text = "View Profile")
                }

            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        Surface(Modifier.fillMaxSize()) {
            MainContent()
        }
    }
}