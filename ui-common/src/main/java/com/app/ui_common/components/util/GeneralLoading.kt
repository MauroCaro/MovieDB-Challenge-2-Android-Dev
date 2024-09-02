package com.app.ui_common.components.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun GeneralLoadingScreen(
    label: String = "",
    modifier: Modifier = Modifier
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val (circularProgress, description) = createRefs()
        CircularProgressIndicator(modifier = Modifier.constrainAs(circularProgress) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
        if (label.isNotEmpty()) {
            Text(
                modifier = Modifier.constrainAs(description) {
                    top.linkTo(circularProgress.bottom, 23.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
                text = label,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(
    device = Devices.PIXEL_4,
    backgroundColor = 0XFFFFFF,
    showBackground = true
)
@Composable
private fun GeneralLoadingScreenPreview() {
    GeneralLoadingScreen("Loading...")
}