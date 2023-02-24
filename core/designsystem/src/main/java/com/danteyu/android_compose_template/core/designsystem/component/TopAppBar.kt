package com.danteyu.android_compose_template.core.designsystem.component

import android.R
import androidx.annotation.StringRes
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.danteyu.android_compose_template.core.designsystem.icon.AppIcons
import com.danteyu.android_compose_template.core.designsystem.theme.AppTheme
import com.danteyu.android_compose_template.core.designsystem.theme.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDesc: String?,
    actionIcon: ImageVector,
    actionIconContentDesc: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(
                onClick = onNavigationClick
            ) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDesc,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDesc,
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("appTopAppBar")
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    @StringRes titleRes: Int,
    actionIcon: ImageVector,
    actionIconContentDesc: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onActionClick: () -> Unit = {}
) {
    CenterAlignedTopAppBar(title = { Text(text = stringResource(id = titleRes)) }, actions = {
        IconButton(
            onClick = onActionClick
        ) {
            Icon(
                imageVector = actionIcon,
                contentDescription = actionIconContentDesc,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    },
        colors = colors,
        modifier = modifier.testTag("appTopAppBar")
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@ThemePreviews
@Composable
fun AppTopAppBarPrev() {
    AppTheme {
        AppTopAppBar(
            titleRes = R.string.untitled,
            actionIcon = AppIcons.ArrowBack,
            actionIconContentDesc = "Action icon"
        )
    }
}
