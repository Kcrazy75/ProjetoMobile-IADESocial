package pt.iade.ei.iadesocial.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import pt.iade.ei.iadesocial.api.PostsRepository
import pt.iade.ei.iadesocial.models.Posts
import pt.iade.ei.iadesocial.api.Result

class PostsViewModel(private val repository: PostsRepository) : ViewModel() {

    private val _postsState =  MutableStateFlow<List<Posts>>(emptyList())
    val postsState = _postsState.asStateFlow()

    private val _createPostState = MutableStateFlow<Result<Posts>?>(null)
    val createPostState: StateFlow<Result<Posts>?> = _createPostState

    private val _showErrorToastChannel = Channel<Boolean>()
    val showErrorToastChannel = _showErrorToastChannel.receiveAsFlow()
    // Função para obter todos os posts
    fun fetchAllPosts() {
        viewModelScope.launch {
            repository.getAllPosts().collectLatest { result ->
                when (result) {
                    is Result.Error -> {
                        _showErrorToastChannel.send(true)
                    }
                    is Result.Success -> {
                        result.data?.let { posts ->
                            _postsState.update {
                                posts
                            }
                        }
                    }
                }
            }
        }
    }

    // Função para criar um novo post
    fun createPost(newPost: Posts) {
        viewModelScope.launch {
            val result = repository.createPost(newPost)
            _createPostState.value = result
        }
    }
}
