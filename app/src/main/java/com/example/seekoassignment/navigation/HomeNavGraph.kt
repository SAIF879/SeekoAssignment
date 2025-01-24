package com.example.seekoassignment.navigation


import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.seekoassignment.mainflow.home.animeDetails.ui.AnimeDetailsScreen
import com.example.seekoassignment.mainflow.home.animeList.ui.AnimeListScreen
import com.example.seekoassignment.mainflow.home.animeList.util.viewmodel.AnimeListViewModel


fun NavGraphBuilder.homeNavGraph(){
    navigation(
        route = NavGraph.HOME,
        startDestination = HomeScreens.AnimeListScreen.route
    ){

        composable(route = HomeScreens.AnimeListScreen.route) {
            val viewModel : AnimeListViewModel = hiltViewModel()
            AnimeListScreen(viewmodel =viewModel )
        }
        composable(route = HomeScreens.AnimeDetailsScreen.route) {
            AnimeDetailsScreen()
        }
    }
}

sealed class HomeScreens(val route : String){
    data object AnimeListScreen : HomeScreens(route = "anime_list_screen")
    data object AnimeDetailsScreen : HomeScreens(route = "anime_details_screen")
}