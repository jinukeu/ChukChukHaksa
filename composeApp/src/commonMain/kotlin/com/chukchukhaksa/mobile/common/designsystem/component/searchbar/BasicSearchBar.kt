package com.chukchukhaksa.mobile.common.designsystem.component.searchbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp
import chukchukhaksa.composeapp.generated.resources.Res
import chukchukhaksa.composeapp.generated.resources.ic_search
import com.chukchukhaksa.mobile.common.designsystem.component.button.TextFieldClearButton
import com.chukchukhaksa.mobile.common.designsystem.theme.Black
import com.chukchukhaksa.mobile.common.designsystem.theme.Primary
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun BasicSearchBar(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    maxLines: Int,
    minLines: Int,
    interactionSource: MutableInteractionSource,
    placeholder: String,
    placeholderColor: Color,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onClickClearButton: () -> Unit,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = SuwikiTheme.typography.header7.copy(color = Black),
        singleLine = maxLines == 1,
        maxLines = if (minLines > maxLines) minLines else maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(Primary),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        decorationBox = { innerText ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(resource = Res.drawable.ic_search),
                    contentDescription = "",
                )

                Spacer(modifier = Modifier.size(5.dp))

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart,
                ) {
                    innerText()
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = placeholderColor,
                            style = SuwikiTheme.typography.header7,
                        )
                    }
                }

                if (value.isNotEmpty()) {
                    TextFieldClearButton(
                        onClick = onClickClearButton,
                    )
                }
            }
        },
    )
}
