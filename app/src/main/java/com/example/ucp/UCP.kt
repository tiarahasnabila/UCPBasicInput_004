package com.example.ucp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable

fun UCP(modifier : Modifier = Modifier) {
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var memilihTp by remember { mutableStateOf("") }

    var originsv by remember { mutableStateOf("") }
    var departuresv by remember { mutableStateOf("") }
    var arrivalsv by remember { mutableStateOf("") }
    var memilihTpsv by remember { mutableStateOf("") }

    val listTp = listOf("Bus", "Ship", "Train", "Plane")

    HeaderSection()
        Column {
            Spacer(Modifier.padding(50.dp))
            Text(
                "Plan Your Adventures",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                "Let's plan an exquisite adventure",
                fontSize = 25.sp,
                fontWeight = FontWeight.Thin
            )
            Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = origin,
            onValueChange = { origin = it },
            label = { Text("tujuan") },
            placeholder = { Text("Masukkan Tujuan Anda") },
        )
        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = departure,
            onValueChange = { departure = it },
            label = { Text("keberangkatan") },
            placeholder = { Text("Masukkan Tanggal keberangkatan Anda") },
        )
        Spacer(Modifier.padding(16.dp))
        TextField(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            value = arrival,
            onValueChange = { arrival = it },
            label = { Text("sampai") },
            placeholder = { Text("Masukkan Tanggal sampai Anda") },
        )

        Row {
            Text(
             "Choose "
            )
            listTp.forEach { item ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = memilihTp == item,
                        onClick = {
                            memilihTp = item
                        }
                    )
                    Text(item)
                }
            }
        }


        ElevatedButton(onClick = {
            originsv = origin
            departuresv = departure
            arrivalsv = arrivalsv
            memilihTpsv = memilihTp
        }) {
            Text("Submit")
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(contentColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()

        ) {
            DetailAdventure(judul = "Origin", isinya = originsv)
            DetailAdventure(judul = "Departure", isinya = departuresv)
            DetailAdventure(judul = "Arrival", isinya = arrivalsv)
            DetailAdventure(judul = "Transport", isinya = memilihTpsv)
        }
    }
}


@Composable
fun DetailAdventure(judul: String, isinya: String) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        ) {
            Text(
                text = judul,
                modifier = Modifier.weight(0.8f)
            )
            Text(
                text = ":",
                modifier = Modifier.weight(0.2f)
            )
            Text(
                text = isinya,
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Composable
fun HeaderSection(){
    Box(modifier = Modifier.fillMaxWidth().background(color = Color.Blue)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Muhammad Adri",
                    color = Color.White
                )
                Text(
                    text = "Kabupaten Tangerang",
                    color = Color.White
                )
            }
            Box (
                contentAlignment = Alignment.BottomStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.kimso),
                    contentDescription = "", modifier = Modifier.size(50.dp)
                        .clip(CircleShape)
                )
                Icon(imageVector = Icons.Filled.Done,
                    contentDescription = null
                )
            }
        }
    }
}




