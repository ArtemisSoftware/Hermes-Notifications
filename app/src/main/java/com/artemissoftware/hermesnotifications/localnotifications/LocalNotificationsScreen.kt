@file:OptIn(ExperimentalMaterial3Api::class)

package com.artemissoftware.hermesnotifications.localnotifications

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.hermesnotifications.R
import com.artemissoftware.hermesnotifications.service.WaterNotificationService
import com.artemissoftware.hermesnotifications.ui.theme.HermesNotificationsTheme

@Composable
fun LocalNotificationsScreen(
    onPopBack: () -> Unit,
    waterNotificationService: WaterNotificationService
) {
    with(waterNotificationService){
        LocalNotificationsContent(
            onPopBack = onPopBack,
            basicNotification = { showBasicNotification() },
            imageNotification = { showExpandableNotification() },
            expandableLongText = { showExpandableLongText() },
            inboxStyle = { showInboxStyle() },
            group = { showNotificationGroup() },
        )
    }
}

@Composable
fun LocalNotificationsContent(
    onPopBack: () -> Unit,
    basicNotification: () -> Unit,
    imageNotification: () -> Unit,
    expandableLongText: () -> Unit,
    inboxStyle: () -> Unit,
    group: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.local_notifications))
                },
                navigationIcon = {
                    IconButton(onClick = onPopBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Localized description")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            NotificationButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = basicNotification,
                text = R.string.basic_notification
            )

            NotificationButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = imageNotification,
                text = R.string.expandable_with_image_notification
            )

            NotificationButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = expandableLongText,
                text = R.string.expandable_with_big_text_notification
            )

            NotificationButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = inboxStyle,
                text = R.string.inbox_style_notification
            )

            NotificationButton(
                modifier = Modifier.padding(vertical = 8.dp),
                onClick = group,
                text = R.string.group_notification
            )

        }
    }
}

@Composable
private fun NotificationButton(
    modifier: Modifier,
    onClick: () -> Unit,
    @StringRes text: Int
) {
    Button(
        modifier = modifier,
        onClick = onClick
    ) {
        Text(text = stringResource(id = text))
    }
}

@Preview(showBackground = true)
@Composable
private fun LocalNotificationsContentPreview() {
    HermesNotificationsTheme {
        LocalNotificationsContent(
            onPopBack = {},
            basicNotification = {},
            imageNotification = {},
            expandableLongText = {},
            inboxStyle = {},
            group = {},
        )
    }
}
