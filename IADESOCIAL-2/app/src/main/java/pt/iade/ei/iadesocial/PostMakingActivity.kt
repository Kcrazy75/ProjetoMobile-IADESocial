package pt.iade.ei.iadesocial

import androidx.compose.runtime.Composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import pt.iade.ei.iadesocial.api.PostsRepositoryImplementation
import pt.iade.ei.iadesocial.api.ProfilesRepositoryImplementation
import pt.iade.ei.iadesocial.api.RetrofitInstance
import pt.iade.ei.iadesocial.api.UsersRepositoryImplementation
import pt.iade.ei.iadesocial.models.SessionManager
import pt.iade.ei.iadesocial.ui.menus.MainMenuFeed
import pt.iade.ei.iadesocial.ui.menus.PostMakingMenu
import pt.iade.ei.iadesocial.viewmodels.PostsViewModel
import pt.iade.ei.iadesocial.viewmodels.ProfilesViewModel
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel


class PostMakingActivity : ComponentActivity() {
    private val viewModel by viewModels<UsersViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return UsersViewModel(
                    UsersRepositoryImplementation(RetrofitInstance.api),
                    applicationContext)
                        as T
            }
        }
    })

    private val PostsViewModel by viewModels<PostsViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PostsViewModel(
                    PostsRepositoryImplementation(RetrofitInstance.api))
                        as T
            }
        }
    })

    private val ProfilesViewModel by viewModels<ProfilesViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return ProfilesViewModel(
                    ProfilesRepositoryImplementation(RetrofitInstance.api)
                )
                        as T
            }
        }
    })

    // Iniciar o SessionManager
    private lateinit var sessionManager: SessionManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(applicationContext)
        setContent {
            PostMakingMenu(viewModel, PostsViewModel, ProfilesViewModel)
        }
    }
}



