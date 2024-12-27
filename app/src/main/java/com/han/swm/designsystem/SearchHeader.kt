package com.han.swm.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.han.swm.R

@Composable
fun SearchHeader(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = searchText,
            onValueChange = {
                onSearchTextChange(it)
            },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = "")
            },
            placeholder = {
                Text("Tìm kiếm")
            }
        )

        IconButton(
            modifier = Modifier.padding(start = 3.dp),
            onClick = {}
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_filter),
                contentDescription = "",
                tint = Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
private fun SearchHeaderPreview() {
    Surface {
        SearchHeader(
            searchText = "",
            onSearchTextChange = {}
        )
    }
}

