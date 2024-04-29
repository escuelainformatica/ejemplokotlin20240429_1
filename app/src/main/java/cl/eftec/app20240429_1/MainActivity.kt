package cl.eftec.app20240429_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cl.eftec.app20240429_1.ui.theme.App20240429_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App20240429_1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Padre()
                }
            }
        }
    }
}

@Composable
fun Padre() {
    var objlogico2 = remember {  mutableStateOf(ClaseLogica()) } // objeto del estilo mutablestateof

    var objlogico by remember {  mutableStateOf(ClaseLogica()) } // claselogica
    //objlogico.contador

    Column {
        Text("Padre")
        ElevatedButton(onClick = { objlogico.contador.value++ }) {
            Text("boton padre ${objlogico.contador.value}")
        }
        Hijo1(objlogico.contador.value, nombreFuncion = {objlogico.contador.value--})
        Hijo1(objlogico.contador.value, nombreFuncion = {objlogico.contador.value=999})
        Hijo2(objlogico.contador)

    }

}
@Composable
fun Hijo1(contador: Int,nombreFuncion:()->Unit) {
    Text("hijo1")
    ElevatedButton(onClick = { nombreFuncion() }) {
        Text("boton hijo1 ${contador}")
    }
}
@Composable
fun Hijo2(contador: MutableState<Int>) {
    Text("hijo2")
    ElevatedButton(onClick = { contador.value -= 1 }) {
        Text("boton hijo2 ${contador.value}")
    }
}