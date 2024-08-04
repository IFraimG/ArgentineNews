package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.presentation.viewModels.NewsViewModel

class HomeFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return ComposeView(requireContext()).apply {
            setContent {
                HomeScreen()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsViewModel: NewsViewModel by viewModels() { NewsViewModel.Factory }

//        binding.btnTranslate.setOnClickListener {
//            newsViewModel.translateNews()
//        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }

    Column {
        Row(verticalAlignment = Alignment.Top, modifier = Modifier.padding(16.dp)) {
            TextField(
                value = searchText,
                onValueChange = { searchText = it },
                shape = RoundedCornerShape(50),
                placeholder = { Text("Поиск....") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search description") },
            )

            FloatingActionButton(onClick = { }) {
                Icon(Icons.Filled.Notifications, contentDescription = "Notifications description")
            }
        }

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            Text(text = "Последние новости", fontSize = 24.sp)
            Text(text = "Смотреть все ->", fontSize = 14.sp)
        }

        Row(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
            AssistChip(onClick = {},
                label = { Text("Экономика") },
                leadingIcon = {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "Localized description",
                        Modifier.size(AssistChipDefaults.IconSize)
                    )
                })
        }
    }
}