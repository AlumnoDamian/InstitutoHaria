package com.example.institutoharia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
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
    var shouldShowOnboarding = rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding.value) {
        MiInicio(
            fpbClick = { shouldShowOnboarding.value = false },
            fpmClick = { shouldShowOnboarding.value = false },
            fpsClick = { shouldShowOnboarding.value = false }
        )
    } else {
        MiFPB(
            inicioClick = { shouldShowOnboarding.value = true },
            fpmClick = { shouldShowOnboarding.value = false },
            fpsClick = { shouldShowOnboarding.value = false }
        )
    }
}

/******************* GENERAL **********************/
@Composable
fun MiTopBar() {
    Row(
        modifier = Modifier
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

@Composable
fun MisBotonesCursos(){

}

@Composable
fun MisAsiganturasFPB1(
    imagenAsignatura: List<Int> = listOf(
        R.drawable.cienciasaplicadas,
        R.drawable.comunicacionsociedad,
        R.drawable.equiposelectricos,
        R.drawable.mantenimiento,
    ),
    nombre: List<String> = listOf(
        "Ciencias Aplicadas I",
        "Comunicación y sociedad I",
        "Equipos Eléctricos y Electrónicos",
        "Instalación y mantenimiento para transmisión de datos"
    ),
    descripcion: List<String> = listOf(
        "Aplicación del conocimiento científico básico a necesidades humanas y al desarrollo tecnológico.\nHoras Semanales: 6 horas\nHoras Totales: 215 horas.",
        "Se desarrolla las habilidades y destrezas lingüísticas, además de alcanzar el nivel de precisión, claridad y fluidez requeridas, para comunicarse en su entorno.\nHoras Semanales: 6 horas\nHoras Totales: 215 horas\n",
        "Se basa en el montaje y mantenimiento de equipos eléctricos y electrónicos\nHoras Semanales: 11 horas\nHoras Totales: 305 horas",
        "Se administra, gestiona, instala y mantiene las redes.\nHoras Semanales: 7 horas\nHoras Totales: 217 horas"
    )

){

}

@Composable
fun MyForImagesStories(imagenAsignatura: List<Int>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        items(imagenAsignatura) { imagen ->
            MisAsiganturasFPB1(imagen)
        }
    }
}

/******************* GENERAL **********************/


/******************* PRIMERA PÁGINA **********************/
@Composable
fun MiInicio(fpbClick: () -> Unit, fpmClick: () -> Unit, fpsClick: () -> Unit) {

    Column (modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MiTopBar()
        Image(
            painter = painterResource(id = R.drawable.centro_menu_1),
            contentDescription = "centro_menu_1.png"
        )

        Spacer(modifier = Modifier.padding(4.dp))

        Text(
            text = "Información del centro",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle( fontSize = 16.sp)){
                    append(
                        "Dirección: C. Santiago Noda, 4, 35520 Haría, Las Palmas.\n" +
                        "Contactos: 928 30 30 14\n" +
                        "Email: 35009206@gobiernodecanarias.org.\n" +
                        "Dispone de la ESO, Bachillerato y FP Básica, Grado Medio y Superior de Informática y Comunicaciones.\n" +
                        "Cuenta con transporte escolar gratuito, turno de mañana y cafetería."
                    )
                }
            },
            modifier = Modifier.padding(start = 14.dp, end = 7.dp, top = 7.dp),
        )

        Row {
            Column {
                TextButton(
                    onClick = { fpbClick() },
                    modifier = Modifier
                        .size(125.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fpb),
                        contentDescription = "fpb.png",
                    )
                }
            }
            
            Column {
                TextButton(
                    onClick = { fpmClick() },
                    modifier = Modifier
                        .size(125.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fpm),
                        contentDescription = "fpm.png",
                    )
                }
            }
            
            Column {
                TextButton(
                    onClick = { fpsClick() },
                    modifier = Modifier
                        .size(125.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.fps),
                        contentDescription = "fps.png",
                    )
                }
            }
        }
    }
}
/******************* PRIMERA PÁGINA **********************/


/******************* FP BASICO **********************/
@Composable
fun MiFPB(inicioClick: () -> Unit, fpmClick: () -> Unit, fpsClick: () -> Unit){

    Column (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        MiTopBar()

        Spacer(modifier = Modifier.padding(8.dp))
        
        Text(
            text = "Requisitos del Ciclo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 16.sp)) {
                    append(
                        "Tiene una duración de 2000 horas totales.\n" +
                                "Se aprende montaje de equipos en sistemas microinformáticos y redes de transmisión de datos, operaciones auxiliares en montaje y mantenimiento de sistemas informáticos, realizar operaciones para el almacenamiento y transporte de sistemas, periféricos y consumibles; y por último realizar comprobaciones rutinarias de verificación en el montaje\n"
                    )
                }
            },
            modifier = Modifier.padding(16.dp),
        )

        Row {

            TextButton(
                onClick = { inicioClick() },
                modifier = Modifier
                    .size(125.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.inicio),
                    contentDescription = "fpb.png",
                    modifier = Modifier.fillMaxSize(125f)
                )
            }

            TextButton(
                onClick = { fpmClick() },
                modifier = Modifier
                    .size(125.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fpm),
                    contentDescription = "fpm.png",
                )
            }

            TextButton(
                onClick = { fpsClick() },
                modifier = Modifier
                    .size(125.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fps),
                    contentDescription = "fps.png",
                )
            }
        }

        Text(
            text = "Asignaturas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface,
            ),
            border = BorderStroke(2.dp, Color.Black),
            modifier = Modifier
                .size(width = 320.dp, height = 320.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.cienciasaplicadas),
                contentDescription = "fps.png"
            )

        }

    }
}
/******************* FP BASICO **********************/


/******************* FP MEDIO **********************/

/******************* FP MEDIO **********************/


/******************* FP SUPERIOR **********************/

/******************* FP SUPERIOR **********************/
