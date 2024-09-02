package com.app.ui_common.components.util

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.app.ui_common.R

@Composable
fun GeneralEmptyScreen(
    modifier: Modifier = Modifier,
    @StringRes titleRes: Int? = R.string.not_info,
    @StringRes textRes: Int? = null,
    textStyle: TextStyle = MaterialTheme.typography.titleSmall,
    @DrawableRes imageRes: Int? = null,
    paddingText: Dp = 0.dp
) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.background)
            .wrapContentHeight(align = Alignment.CenterVertically)
    ) {
        val (title, text, image) = createRefs()
        if (titleRes != null) {
            Text(
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                },
                text = stringResource(id = titleRes),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }
        Text(
            modifier = Modifier
                .constrainAs(text) {
                    if (titleRes != null) top.linkTo(title.bottom, 10.dp) else top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    if (titleRes == null) bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                }
                .padding(horizontal = paddingText),
            text = textRes?.let { stringResource(id = it) } ?: "",
            textAlign = TextAlign.Center,
            style = textStyle
        )
        imageRes?.let {
            Image(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(bottom = 12.dp)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        if (titleRes != null) bottom.linkTo(title.top) else bottom.linkTo(text.top)
                    },
                painter = painterResource(id = it),
                contentDescription = null
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
private fun GeneralEmptyScreenPreview() {
    GeneralEmptyScreen()
}

