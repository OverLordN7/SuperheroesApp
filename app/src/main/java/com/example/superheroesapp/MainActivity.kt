package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.ui.theme.SuperheroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@Composable
fun SuperheroesApp(){
    Scaffold(
        topBar = {SuperheroTopBar()}
    ) {
        LazyColumn(){
            items(HeroesRepository.heroes){
                HeroItem(hero = it)
            }
        }   
    }
    
}

@Composable
fun SuperheroTopBar(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)
        .height(56.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "Superheroes", style = MaterialTheme.typography.h1)
        
    }
}

@Composable
fun HeroItem(hero: Hero,modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .background(color = MaterialTheme.colors.background)
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp,
                bottom = 8.dp
            ),
        elevation = 2.dp
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(4f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = stringResource(id = hero.nameRes), style = MaterialTheme.typography.h3 )
                Text(text = stringResource(id = hero.descriptionRes), style = MaterialTheme.typography.body1)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                modifier = Modifier
                    .size(60.dp)
                    .weight(1f),
                painter = painterResource(id = hero.imageRes),
                contentDescription = stringResource(id = hero.nameRes),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroesAppPreview() {
    SuperheroesAppTheme {
        SuperheroesApp()
    }
}

@Preview(showBackground = true)
@Composable
fun DarkThemeSuperheroesAppPreview() {
    SuperheroesAppTheme(darkTheme = true) {
        SuperheroesApp()
    }
}