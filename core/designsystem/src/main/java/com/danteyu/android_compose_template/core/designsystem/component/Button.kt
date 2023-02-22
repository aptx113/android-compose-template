package com.danteyu.android_compose_template.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.danteyu.android_compose_template.core.designsystem.icon.AppIcons
import com.danteyu.android_compose_template.core.designsystem.theme.AppTheme
import com.danteyu.android_compose_template.core.designsystem.theme.ThemePreviews

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    AppButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        }
    ) {
        AppButtonContent(text = text, leadingIcon = leadingIcon)
    }
}

@Composable
fun AppOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colorScheme.onBackground),
        border = BorderStroke(
            width = AppButtonDefaults.OutlinedButtonBorderWidth, color = if (enabled) {
                MaterialTheme.colorScheme.outline
            } else {
                MaterialTheme.colorScheme.onSurface.copy(alpha = AppButtonDefaults.DisabledOutlinedButtonBorderAlpha)
            }
        ),
        contentPadding = contentPadding,
        content = content
    )
}

@Composable
fun AppOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    AppOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        }
    ) {
        AppButtonContent(text = text, leadingIcon = leadingIcon)
    }
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.onBackground),
        content = content
    )
}

@Composable
fun AppTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    AppTextButton(onClick = onClick, modifier = modifier, enabled = enabled) {
        AppButtonContent(text = text, leadingIcon = leadingIcon)
    }
}

@Composable
private fun AppButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier.padding(
            start = if (leadingIcon != null) {
                ButtonDefaults.IconSize
            } else {
                0.dp
            }
        )
    ) {
        text()
    }
}

@ThemePreviews
@Composable
fun AppButtonPrev() {
    AppTheme {
        AppButton(onClick = { }) {
            Text(text = "Hello World")
        }
    }
}

@ThemePreviews
@Composable
fun AppButtonWithIconPrev() {
    AppTheme {
        AppButton(
            onClick = {},
            text = { Text(text = "Hello World") },
            leadingIcon = { Icon(imageVector = AppIcons.ArrowBack, contentDescription = null) })
    }
}

@ThemePreviews
@Composable
fun AppOutlinedButtonPrev() {
    AppTheme {
        AppOutlinedButton(onClick = {}) {
            Text(text = "Hello World")
        }
    }
}

@ThemePreviews
@Composable
fun AppOutlinedButtonWithIconPrev() {
    AppTheme {
        AppOutlinedButton(onClick = {}, text = { Text(text = "Hello World") },
            leadingIcon = { Icon(imageVector = AppIcons.ArrowBack, contentDescription = null) })
    }
}

@ThemePreviews
@Composable
fun AppTextButtonPrev() {
    AppTheme {
        AppTextButton(onClick = {}) {
            Text(text = "Hello World")
        }
    }
}

@ThemePreviews
@Composable
fun AppTextButtonWithIconPrev() {
    AppTheme {
        AppTextButton(onClick = {}, text = { Text(text = "Hello World") },
            leadingIcon = { Icon(imageVector = AppIcons.ArrowBack, contentDescription = null) })
    }
}

object AppButtonDefaults {
    const val DisabledOutlinedButtonBorderAlpha = 0.12f
    val OutlinedButtonBorderWidth = 1.dp
}
