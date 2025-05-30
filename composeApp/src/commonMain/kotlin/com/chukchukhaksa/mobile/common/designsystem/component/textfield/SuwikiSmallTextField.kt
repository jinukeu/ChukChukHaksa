package com.chukchukhaksa.mobile.common.designsystem.component.textfield

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.chukchukhaksa.mobile.common.designsystem.component.button.TextFieldClearButton
import com.chukchukhaksa.mobile.common.designsystem.theme.Gray95
import com.chukchukhaksa.mobile.common.designsystem.theme.GrayCB
import com.chukchukhaksa.mobile.common.designsystem.theme.GrayF6
import com.chukchukhaksa.mobile.common.designsystem.theme.Primary
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme

@Composable
fun SuwikiSmallTextField(
    modifier: Modifier = Modifier,
    placeholder: String = "",
    value: String = "",
    onValueChange: (String) -> Unit = { _ -> },
    showClearButton: Boolean = true,
    onClickClearButton: () -> Unit = {},
    maxLines: Int = 1,
    minLines: Int = 1,
    textStyle: TextStyle = SuwikiTheme.typography.body5,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val isFocused by interactionSource.collectIsFocusedAsState()

    val underlineColor = when {
        isFocused -> Primary
        value.isEmpty() -> Gray95
        else -> GrayF6
    }

    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier.fillMaxWidth(),
        singleLine = maxLines == 1,
        textStyle = textStyle,
        maxLines = if (minLines > maxLines) minLines else maxLines,
        minLines = minLines,
        interactionSource = interactionSource,
        cursorBrush = SolidColor(Primary),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        decorationBox = { innerText ->
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(
                            min = 21.dp,
                        ),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Box(
                        modifier = Modifier.weight(1f),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        innerText()
                        if (value.isEmpty()) {
                            Text(
                                overflow = TextOverflow.Clip,
                                maxLines = 1,
                                text = placeholder,
                                color = GrayCB,
                                style = SuwikiTheme.typography.body5,
                            )
                        }
                    }

                    if (value.isNotEmpty() && showClearButton) {
                        TextFieldClearButton(
                            modifier = Modifier
                                .size(21.dp),
                            onClick = onClickClearButton,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                HorizontalDivider(
                    thickness = 1.dp,
                    color = underlineColor,
                )
            }
        },
    )
}
