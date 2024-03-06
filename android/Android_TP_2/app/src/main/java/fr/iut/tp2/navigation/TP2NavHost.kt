package fr.iut.tp2.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fr.iut.tp2.data.Stub
import fr.iut.tp2.ui.conversation.ConversationScreen
import fr.iut.tp2.ui.home.HomeScreen


@Composable
fun TP2NavHost() {
    val navController = rememberNavController()

    val conversations = Stub.conversations
    val contacts = Stub.contacts

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = "home"
    ) {

        composable(route = "home") {
            HomeScreen(
                conversations = conversations,
                contacts = contacts,
                goToConversation = {
                    navController.navigate("conversation/${it.id}")
                }
            )
        }

        composable(
            route = "conversation/{conversationId}",
            arguments = listOf(navArgument("conversationId") { type = NavType.LongType })
        ) {
            it.arguments?.getLong("conversationId")?.let { conversationId ->
                conversations.find { it.id == conversationId }?.let {
                    ConversationScreen(
                        conversation = it,
                        navigateBack = {
                            navController.popBackStack()
                        }
                    )
                }
            } ?: run {
                LaunchedEffect(Unit) {
                    navController.popBackStack()
                }
            }
        }

    }
}
