package pt.iade.ei.iadesocial.ui.menus

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.iadesocial.MainMenuFeedActivity
import pt.iade.ei.iadesocial.PostMakingActivity
import pt.iade.ei.iadesocial.R
import pt.iade.ei.iadesocial.models.Posts
import pt.iade.ei.iadesocial.models.SessionManager
import pt.iade.ei.iadesocial.models.Users
import pt.iade.ei.iadesocial.viewmodels.PostsViewModel
import pt.iade.ei.iadesocial.viewmodels.ProfilesViewModel
import pt.iade.ei.iadesocial.viewmodels.UsersViewModel
import pt.iade.ei.iadesocial.api.Result
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostMakingMenu(viewModel: UsersViewModel, postsViewModel: PostsViewModel, profilesViewModel: ProfilesViewModel) {
    var postDescription by remember { mutableStateOf("") }
    val context = LocalContext.current
    val sessionManager = SessionManager(LocalContext.current)
    val userId = sessionManager.getUserId()
    val profileState by profilesViewModel.profileState.collectAsState()

    // Fetch the profile when the Composable is composed
    LaunchedEffect(userId) {
        profilesViewModel.fetchProfileByUserId(userId)
    }
    val randomImages = listOf(
        R.drawable.postex_1, // Certifique-se de que essas imagens existam no diretório res/drawable
        R.drawable.postex_2,
        R.drawable.postex_3,
        R.drawable.postex_4,
        R.drawable.postex_5,
        R.drawable.postex_6,
    )

    // Seleciona uma imagem aleatória
    val randomImage = randomImages.random()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("IADE Social", color = Color.Black) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFB33A3A)),
                navigationIcon = {
                    IconButton(onClick = { /* Ação do ícone de perfil */ },
                        modifier = Modifier.size(80.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_applogo),
                            contentDescription = "Perfil",
                            tint = Color.Black,
                            modifier = Modifier.size(80.dp)
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* Ação do menu */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = Color.Black
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(containerColor = Color(0xFFB33A3A)) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = "Home"
                        )
                    },
                    selected = true,
                    onClick = { val intent = Intent(context, MainMenuFeedActivity::class.java)
                        context.startActivity(intent) }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.CameraAlt,
                            contentDescription = "Postar"
                        )
                    },
                    selected = false,
                    onClick = { val intent = Intent(context, PostMakingActivity::class.java)
                        context.startActivity(intent) }
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Filled.Person,
                            contentDescription = "Perfil"
                        )
                    },
                    selected = false,
                    onClick = { /* Navegar para Perfil */ }
                )
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues).padding(8.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(550.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.postex_3),
                    contentDescription = "Imagem do post",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
            OutlinedTextField(
                value = postDescription,
                onValueChange = { postDescription = it },
                label = { Text("Descrição do Post") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    val profile = (profileState as? Result.Success)?.data
                    if (profile != null) {
                        val post = Posts(
                            content = postDescription,
                            profileId = profile.id,
                            // Outros campos, se necessário
                        )
                        postsViewModel.createPost(post)
                        val intent = Intent(context, MainMenuFeedActivity::class.java)
                        context.startActivity(intent)
                    } else {
                        // Lidar com o caso em que o perfil não foi carregado ou houve erro
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Publicar")
            }
            Spacer(modifier = Modifier.height(16.dp))

                }
            }
        }





