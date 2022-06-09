package com.example.stockMarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ComposeCheatSheet.SampleData
import com.example.ComposeCheatSheet.ui.theme.ElevateTheme

class SampleComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElevateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Column(modifier = Modifier.padding(all = 18.dp)) {
//                    Greeting("Android")
                        Row(Modifier.padding(10.dp)) {
                            Greeting("Vanakkam Makale")
                            Greeting("All")
                        }
                        Text(text = "Welcome Karthick", Modifier.padding(10.dp))
                        MessageCard(Message("Karthick", "Hello All"))
                    }
                }
            }
        }
    }
}

@Composable
fun MessageCard(msg: Message) {

    Row(modifier = Modifier.padding(all = 18.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                Text(
                    text = msg.body,
                    modifier= Modifier.padding(2.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


data class Message(val author: String, val body: String)

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(Message("Karthick", "Hello All"))
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    ElevateTheme {
        Conversation(SampleData.conversationSample)
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", Modifier.padding(5.dp, 5.dp, 10.dp, 0.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ElevateTheme {
        Greeting("Android")
    }
}