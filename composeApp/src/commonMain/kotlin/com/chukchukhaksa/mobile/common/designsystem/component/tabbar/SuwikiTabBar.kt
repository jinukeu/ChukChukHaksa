package com.chukchukhaksa.mobile.common.designsystem.component.tabbar

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Placeable
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.chukchukhaksa.mobile.common.designsystem.theme.Black
import com.chukchukhaksa.mobile.common.designsystem.theme.Gray95
import com.chukchukhaksa.mobile.common.designsystem.theme.SuwikiTheme
import com.chukchukhaksa.mobile.common.designsystem.theme.White
import com.chukchukhaksa.mobile.common.ui.suwikiClickable

enum class SubComposeID {
  PRE_CALCULATE_ITEM,
  ITEM,
  INDICATOR,
}

data class TabPosition(
  val left: Dp,
  val width: Dp,
)

// https://github.com/GautierLouis/ComposePlayground/blob/1c5ffb483291bb21d9820a2fe7a18aec049c7bd2/app/src/main/java/com/louis/composeplayground/ui/TabRow.kt
@Composable
fun SuwikiTabBar(
  indicatorColor: Color = Black,
  paddingValues: PaddingValues = PaddingValues(start = 12.dp, end = 12.dp),
  animationSpec: AnimationSpec<Dp> = tween(durationMillis = 250, easing = FastOutSlowInEasing),
  selectedTabPosition: Int = 0,
  tabItem: @Composable () -> Unit,
) {
  Surface(
    modifier = Modifier,
    color = White,
  ) {
    SubcomposeLayout(
      Modifier
        .padding(paddingValues)
        .selectableGroup(),
    ) { constraints ->
      val tabMeasurable: List<Placeable> = subcompose(SubComposeID.PRE_CALCULATE_ITEM, tabItem)
        .map { it.measure(constraints) }

      val maxItemHeight = tabMeasurable.maxOf { it.height }

      val tabPlacables = subcompose(SubComposeID.ITEM, tabItem).map {
        it.measure(constraints)
      }

      val tabPositions = tabPlacables.mapIndexed { index, placeable ->
        val itemWidth = placeable.width
        val x = tabPlacables.take(index).sumOf { it.width }
        TabPosition(x.toDp(), itemWidth.toDp())
      }

      val tabRowWidth = tabPlacables.sumOf { it.width }

      layout(tabRowWidth, maxItemHeight) {
        subcompose(SubComposeID.INDICATOR) {
          Box(
            Modifier
              .tabIndicator(tabPositions[selectedTabPosition], animationSpec)
              .fillMaxWidth()
              .height(maxItemHeight.toDp())
              .background(color = indicatorColor),
          )
        }.forEach {
          it.measure(Constraints.fixed(tabRowWidth, maxItemHeight)).placeRelative(0, 0)
        }

        tabPlacables.forEachIndexed { index, placeable ->
          val x = tabPlacables.take(index).sumOf { it.width }
          placeable.placeRelative(x, 0)
        }
      }
    }
  }
}

private fun Modifier.tabIndicator(
  tabPosition: TabPosition,
  animationSpec: AnimationSpec<Dp>,
): Modifier = composed(
  inspectorInfo = debugInspectorInfo {
    name = "tabIndicatorOffset"
    value = tabPosition
  },
) {
  val currentTabWidth by animateDpAsState(
    targetValue = tabPosition.width,
    animationSpec = animationSpec,
    label = "",
  )
  val indicatorOffset by animateDpAsState(
    targetValue = tabPosition.left,
    animationSpec = animationSpec,
    label = "",
  )
  fillMaxWidth()
    .wrapContentSize(Alignment.BottomStart)
    .offset(x = indicatorOffset + 12.dp)
    .width(currentTabWidth - 24.dp)
    .height(2.dp)
}

@Composable
fun TabTitle(
  title: String,
  position: Int,
  selected: Boolean,
  onClick: (Int) -> Unit,
) {
  Text(
    text = title,
    style = SuwikiTheme.typography.header6,
    modifier = Modifier
      .wrapContentWidth(Alignment.CenterHorizontally)
      .padding(12.dp)
      .suwikiClickable(
        rippleEnabled = false,
        onClick = { onClick(position) },
      ),
    color = if (selected) Black else Gray95,
  )
}
