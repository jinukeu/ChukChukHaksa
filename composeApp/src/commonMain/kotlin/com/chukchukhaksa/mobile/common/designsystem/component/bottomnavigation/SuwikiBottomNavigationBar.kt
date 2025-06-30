package com.chukchukhaksa.mobile.common.designsystem.component.bottomnavigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import chukchukhaksa.composeapp.generated.resources.Res
import chukchukhaksa.composeapp.generated.resources.ic_timetable_hamburger
import chukchukhaksa.composeapp.generated.resources.ic_search
import com.chukchukhaksa.mobile.common.designsystem.theme.Gray95
import com.chukchukhaksa.mobile.common.designsystem.theme.Primary
import com.chukchukhaksa.mobile.common.designsystem.theme.White
import com.chukchukhaksa.mobile.presentation.web.navigation.WebNavigationRoute
import org.jetbrains.compose.resources.painterResource

data class BottomNavigationItem(
    val label: String,
    val icon: Painter,
    val route: String,
)

@Composable
fun SuwikiBottomNavigationBar(
    items: List<BottomNavigationItem>,
    selectedRoute: String,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier.height(80.dp),
        containerColor = White,
    ) {
        items.forEach { item ->
            val isSelected = selectedRoute == item.route
            NavigationBarItem(
                selected = isSelected,
                onClick = { onItemClick(item.route) },
                icon = {
                    Icon(
                        painter = item.icon,
                        contentDescription = item.label,
                    )
                },
                label = {
                    Text(text = item.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Primary,
                    selectedTextColor = Primary,
                    unselectedIconColor = Gray95,
                    unselectedTextColor = Gray95,
                    indicatorColor = White,
                ),
            )
        }
    }
}

@Composable
fun getBottomNavigationItems() = listOf(
    BottomNavigationItem(
        label = "시간표",
        icon = painterResource(Res.drawable.ic_timetable_hamburger),
        route = "timetable",
    ),
    BottomNavigationItem(
        label = "웹",
        icon = painterResource(Res.drawable.ic_search),
        route = WebNavigationRoute.homeRoute,
    ),
)
