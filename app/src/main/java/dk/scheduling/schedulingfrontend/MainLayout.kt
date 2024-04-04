import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import dk.scheduling.schedulingfrontend.ApiButton


enum class Page {
    Home,
    PAGE_2,
    PAGE_3
}

data class PageInfo(
    val page: Page,
    val icon: ImageVector,
    val composable: @Composable () -> Unit
)


val pagesInfo = listOf(
    PageInfo(Page.Home, Icons.Default.Home) { Page1() },
    PageInfo(Page.PAGE_2, Icons.Default.Favorite) { ApiButton() },
    PageInfo(Page.PAGE_3, Icons.Default.Settings) { Page3() }
)

@Composable
fun App() {
    var currentPage by remember { mutableStateOf(Page.Home) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Content of the current page
        Column(modifier = Modifier.fillMaxSize()) {
            pagesInfo.find { it.page == currentPage }?.composable?.invoke() ?: Page1() // Default to Page1 if not found
            Spacer(modifier = Modifier.weight(1f))
        }

        // Bottom navigation bar
        BottomNavigationBar(
            currentPage = currentPage,
            onPageSelected = { page -> currentPage = page },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun Page1() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Page 1, click the heart to reach the api button!", fontSize = 24.sp)
    }
}

@Composable
fun Page3() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Page 3", fontSize = 24.sp)
    }
}

@Preview
@Composable
fun BottomNavigationBarPreview() {
    Box(modifier = Modifier.height(56.dp)) { // Adjust the height as needed
        BottomNavigationBar(
            currentPage = Page.Home,
            onPageSelected = { },
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun BottomNavigationBar(currentPage: Page, onPageSelected: (Page) -> Unit, modifier: Modifier = Modifier) {
    Surface(color = Color.Gray, modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            pagesInfo.forEach { pageInfo ->
                BottomNavigationButton(
                    icon = pageInfo.icon,
                    isSelected = currentPage == pageInfo.page
                ) { onPageSelected(pageInfo.page) }
            }
        }
    }
}

@Composable
fun BottomNavigationButton(
    icon: ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = if (isSelected) Color.White else Color.Magenta
        )
    }
}

@Preview
@Composable
fun PreviewApp() {
    App()
}
