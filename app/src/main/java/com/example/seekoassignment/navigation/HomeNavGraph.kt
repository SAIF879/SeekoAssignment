package com.example.seekoassignment.navigation
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.seekoassignment.mainflow.home.animeDetails.ui.AnimeDetailsScreen
import com.example.seekoassignment.mainflow.home.animeDetails.util.viewmodel.AnimeDetailsViewModel
import com.example.seekoassignment.mainflow.home.animeList.ui.screen.AnimeListScreen
import com.example.seekoassignment.mainflow.home.animeList.ui.events.AnimeScreenEvents
import com.example.seekoassignment.mainflow.home.animeList.util.viewmodel.AnimeListViewModel


fun NavGraphBuilder.homeNavGraph(navController: NavController){
    navigation(
        route = NavGraph.HOME,
        startDestination = HomeScreens.AnimeListScreen.route
    ){

        composable(route = HomeScreens.AnimeListScreen.route) {
            val viewModel : AnimeListViewModel = hiltViewModel()
            val events by viewModel.topAnimeState.collectAsState()
            AnimeListScreen( list = events ){
                when(it){
                    is AnimeScreenEvents.OnNavigate -> {
                        navController.navigate(HomeScreens.AnimeDetailsScreen.route + "/${it.id}")
                    }
                }

            }
        }
        composable(route = HomeScreens.AnimeDetailsScreen.route+"/{animeId}",
                arguments = listOf(navArgument("animeId") { type = NavType.IntType })
        ) {backStackEntry->
            val animeId = backStackEntry.arguments?.getInt("animeId") ?: -1
            val viewModel : AnimeDetailsViewModel = hiltViewModel()
            LaunchedEffect(Unit) {
                viewModel.fetchAnimeDetails(animeId)
            }
            val detailsState by viewModel.animeDetailsState.collectAsState()
            AnimeDetailsScreen(detailsState)
        }
    }
}

sealed class HomeScreens(val route : String){
    data object AnimeListScreen : HomeScreens(route = "anime_list_screen")
    data object AnimeDetailsScreen : HomeScreens(route = "anime_details_screen")
}