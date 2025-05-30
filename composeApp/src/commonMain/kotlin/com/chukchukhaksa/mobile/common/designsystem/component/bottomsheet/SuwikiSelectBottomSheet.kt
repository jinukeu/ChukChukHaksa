package com.chukchukhaksa.mobile.common.designsystem.component.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import chukchukhaksa.composeapp.generated.resources.Res
import chukchukhaksa.composeapp.generated.resources.ic_align_checked
import com.chukchukhaksa.mobile.common.designsystem.theme.Gray6A
import com.chukchukhaksa.mobile.common.designsystem.theme.Gray95
import com.chukchukhaksa.mobile.common.designsystem.theme.Primary
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.mobile.common.designsystem.theme.White
import com.chukchukhaksa.mobile.common.ui.suwikiClickable
import kotlinx.collections.immutable.PersistentList
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuwikiSelectBottomSheet(
    isSheetOpen: Boolean,
    onDismissRequest: () -> Unit,
    onClickItem: (Int) -> Unit,
    itemList: PersistentList<String>,
    title: String,
    selectedPosition: Int?,
) {
    SuwikiBottomSheet(
        sheetState = rememberModalBottomSheetState(
            skipPartiallyExpanded = true,
        ),
        isSheetOpen = isSheetOpen,
        onDismissRequest = onDismissRequest,
    ) {
        SuwikiSelectBottomSheetContent(
            onClickAlignBottomSheetItem = onClickItem,
            bottomSheetTitle = title,
            itemList = itemList,
            selectedPosition = selectedPosition,
        )
    }
}

@Composable
private fun SuwikiSelectContainer(
    modifier: Modifier = Modifier,
    text: String,
    isChecked: Boolean = false,
    onClick: () -> Unit = {},
) {
    val textColor = if (isChecked) Primary else Gray6A
    Box(
        modifier = modifier
            .background(White)
            .fillMaxWidth()
            .wrapContentHeight()
            .suwikiClickable(
                onClick = onClick,
                rippleColor = Gray6A,
            ),
    ) {
        Text(
            text = text,
            color = textColor,
            style = SuwikiTheme.typography.body2,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(top = 13.dp, bottom = 14.dp, start = 24.dp, end = 52.dp),
        )
        if (isChecked) {
            Icon(
                painter = painterResource(resource = Res.drawable.ic_align_checked),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 16.dp)
                    .size(24.dp),
                tint = Primary,
            )
        }
    }
}

@Composable
fun SuwikiSelectBottomSheetContent(
    selectedPosition: Int?,
    onClickAlignBottomSheetItem: (Int) -> Unit = {},
    bottomSheetTitle: String,
    itemList: List<String>,
) {
    Column(
        modifier = Modifier
            .padding(top = 36.dp, bottom = 45.dp),
    ) {
        Text(
            text = bottomSheetTitle,
            style = SuwikiTheme.typography.body5,
            color = Gray95,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 15.dp),
        )

        itemList.forEachIndexed { index, item ->
            val isChecked = index == selectedPosition
            SuwikiSelectContainer(
                text = item,
                isChecked = isChecked,
                onClick = {
                    if (!isChecked) {
                        onClickAlignBottomSheetItem(index)
                    }
                },
            )
        }
    }
}
