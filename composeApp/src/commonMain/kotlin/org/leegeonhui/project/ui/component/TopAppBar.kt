package org.leegeonhui.project.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.unit.dp
import org.leegeonhui.project.ui.component.button.MyIconButton
import org.leegeonhui.project.ui.theme.White
import org.leegeonhui.project.ui.theme.fontFamily

private val paddingValues = PaddingValues(top = 10.dp, start = 15.dp, bottom = 0.dp, end = 15.dp)

enum class TopAppBarType {
    DEFAULT, SMALL
}

@Composable
fun MyTopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = White,
    type: TopAppBarType = TopAppBarType.DEFAULT,
    title: String,
    onBackClick: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
                .background(backgroundColor)
                .statusBarsPadding()
        ) {
            if (type == TopAppBarType.SMALL) {
                Spacer(modifier = Modifier.width(10.dp))
                MyIconButton(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    content = rememberVectorPainter(Icons.Filled.ArrowBack),
                    onClick = onBackClick
                )
                Spacer(modifier = Modifier.width(4.dp))

            }
            if(type == TopAppBarType.DEFAULT){
                Spacer(modifier = Modifier.width(14.dp))
            }

            Text(modifier = Modifier.align(Alignment.CenterVertically), text = title, style = when(type){
                TopAppBarType.DEFAULT -> fontFamily.h5
                TopAppBarType.SMALL -> fontFamily.h5

            })
        }
        Box(modifier = Modifier.weight(1f)) {
            content(paddingValues)
        }
    }
}
