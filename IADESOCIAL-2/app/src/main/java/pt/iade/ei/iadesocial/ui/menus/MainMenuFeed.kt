package pt.iade.ei.iadesocial.ui.menus

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.iadesocial.MainMenuFeedActivity
import pt.iade.ei.iadesocial.PostMakingActivity
import pt.iade.ei.iadesocial.R
import pt.iade.ei.iadesocial.models.Posts
import pt.iade.ei.iadesocial.viewmodels.PostsViewModel
import pt.iade.ei.iadesocial.viewmodels.ProfilesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuFeed(postsViewModel: PostsViewModel, profilesViewModel: ProfilesViewModel) {
    val context = LocalContext.current
    val posts by postsViewModel.postsState.collectAsState()

    // Carrega os posts ao exibir a tela
    LaunchedEffect(Unit) {
        postsViewModel.fetchAllPosts()  // Garantir que os posts sejam carregados
    }

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
                        context.startActivity(intent)}
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
        // Exibe os posts na LazyColumn

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(posts.size) { post ->
                PostItem(post = posts[post], profilesViewModel = profilesViewModel)
            }
        }
    }


}

@Composable
fun PostItem(post: Posts, profilesViewModel: ProfilesViewModel) {
    val profileState by profilesViewModel.profileState.collectAsState()

    // Carrega o perfil do post
    LaunchedEffect(post.profileId) {
        profilesViewModel.fetchProfileByUserId(post.profileId)
    }

    var likes by remember { mutableIntStateOf(5) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Exibe o nome do autor e descrição
            Row(modifier = Modifier.height(25.dp)) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Autor",
                    tint = Color.Black,
                    modifier = Modifier.size(25.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = profileState?.data?.name ?: "Carregando...",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Exibe a imagem do post (pode ser substituída por uma imagem real)
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

            Spacer(modifier = Modifier.height(8.dp))

            // Ações de curtidas e comentários
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(onClick = { likes++ }) {
                Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "Curtir")
                }
                Text(text = likes.toString(), modifier = Modifier.padding(start = 0.dp), fontSize = 18.sp)
                Spacer(modifier = Modifier.width(16.dp))
                Icon(imageVector = Icons.Filled.ChatBubbleOutline, contentDescription = "Comentar")
                Text(text = "2", modifier = Modifier.padding(start = 4.dp),fontSize = 18.sp)
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Descrição: " + post.content, fontSize = 12.sp)
            // Exibe os comentários
            Text(text = "Kelvin Lamas comentou: 'Excelente post!'", fontSize = 12.sp)
            Text(text = "Ver todos os 5 comentários", fontSize = 12.sp, color = Color.Gray)
        }
    }
}
