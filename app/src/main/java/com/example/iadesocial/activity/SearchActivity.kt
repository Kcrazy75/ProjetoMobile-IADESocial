package com.example.iadesocial.activity

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.iadesocial.data.SampleData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
class SearchActivity : ViewModel() {

    val isSearching = MutableStateFlow(false).asStateFlow()
    val searchText = MutableStateFlow("").asStateFlow()
    val users = listOf(
        SampleData.sampleUsers[0].username,
        SampleData.sampleUsers[1].username,
        SampleData.sampleUsers[2].username
    )

    val userList = MutableStateFlow(users)
    val usersList = searchText.combine(userList){
            text, users ->
        if (text.isBlank()){ users }
        else { users.filter { it.contains(text, ignoreCase = true) } }
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = userList
    )

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun searchScreen() {
        val viewModel = SearchActivity()

        val searchText by viewModel.searchText.collectAsState()
        val isSearching by viewModel.isSearching.collectAsState()
        val userList by viewModel.users.collectAsState()

        SearchBar(
            query = searchText,//text showed on SearchBar
            onQueryChange = viewModel::onSearchTextChange, //update the value of searchText
            onSearch = viewModel::onSearchTextChange, //the callback to be invoked when the input service triggers the ImeAction.Search action
            active = isSearching, //whether the user is searching or not
            onActiveChange = { viewModel.onToogleSearch() }, //the callback to be invoked when this search bar's active state is changed
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            LazyColumn {
                items(users) { users ->
                    Text(
                        text = users,
                        modifier = Modifier.padding(4.dp),
                        )
                }
            }
        }
    }
}*/