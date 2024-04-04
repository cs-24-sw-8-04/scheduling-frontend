package dk.scheduling.schedulingfrontend

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

enum class Page {
    Home,
    PAGE_2,
    PAGE_3,
}

data class PageInfo(
    val page: Page,
    val icon: ImageVector,
    val composable: @Composable () -> Unit,
)

val pagesInfo =
    listOf(
        PageInfo(Page.Home, Icons.Default.Home) { HomePage() },
        PageInfo(Page.PAGE_2, Icons.Default.Favorite) { ApiButton() },
        PageInfo(Page.PAGE_3, Icons.Default.Settings) { Page3() },
    )
