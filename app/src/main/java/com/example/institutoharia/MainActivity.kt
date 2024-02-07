package com.example.institutoharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.institutoharia.ui.theme.InstitutoHariaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstitutoHariaTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    MiInicio()
}

/******************* GENERAL **********************/
@Composable
fun MisCursos() {
    Row {
        Image(
            painter = painterResource(id = R.drawable.fpb),
            contentDescription = "fpb.png",
            modifier = Modifier
                .size(125.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.fpm),
            contentDescription = "fpm.png",
            modifier = Modifier
                .size(125.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.fps),
            contentDescription = "fps.png",
            modifier = Modifier
                .size(125.dp)
        )
    }
}
/******************* GENERAL **********************/


/******************* PRIMERA PÁGINA **********************/
@Composable
fun MiInicio() {

    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MiTopBar()
        Image(
            painter = painterResource(id = R.drawable.centro_menu_1),
            contentDescription = "centro_menu_1.png"
        )

        Text(
            text = "Información del centro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle( fontSize = 16.sp)){
                    append("Dirección: C. Santiago Noda, 4, 35520 Haría, Las Palmas.\n" +
                            "Contactos: 928 30 30 14\n" +
                            "Correo electrónico: 35009206@gobiernodecanarias.org.\n" +
                            "Dispone de la ESO, Bachillerato y FP Básica, Grado Medio y Superior de Informática y Comunicaciones.\n" +
                            "Cuenta con transporte escolar gratuito, turno de mañana y cafetería.")
                }
            },
            modifier = Modifier.padding(top = 16.dp),
        )

        MisCursos()
    }
}

@Composable
fun MiTopBar() {
    Row(modifier = Modifier
        .background(Color.Black)
        .fillMaxWidth()
        .height(75.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_ies_haria),
            contentDescription = "logoPlaneate.png")
        Spacer(modifier = Modifier.padding(6.dp))
        Text(
            text = "I.E.S Haría",
            color = Color.Green
        )
    }
}


/******************* PRIMERA PÁGINA **********************/


/******************* FP BASICO **********************/

/******************* FP BASICO **********************/


/******************* FP MEDIO **********************/

/******************* FP MEDIO **********************/


/******************* FP SUPERIOR **********************/

/******************* FP SUPERIOR **********************/
