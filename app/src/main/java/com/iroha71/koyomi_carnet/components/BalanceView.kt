package com.iroha71.koyomi_carnet.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.iroha71.koyomi_carnet.R
import com.iroha71.koyomi_carnet.ui.theme.AccentColor
import com.iroha71.koyomi_carnet.ui.theme.BrandPrimary
import com.iroha71.koyomi_carnet.ui.theme.KoyomicarnetTheme
import com.iroha71.koyomi_carnet.ui.theme.harmonizeWithPrimary
import com.iroha71.koyomi_carnet.utils.formatYen

@Composable
fun BalanceView(
    budget: Int,
    expense: Int
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = BrandPrimary.harmonizeWithPrimary()),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = stringResource(R.string.usable_payment), color = MaterialTheme.colorScheme.onPrimary, fontSize = 16.sp)
            Text(
                text = formatYen(getUsablePayment(budget, expense)),
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 32.sp,
            )
            Spacer(modifier = Modifier.padding(bottom = 8.dp))
            LinearProgressIndicator(
                progress = { getBudgetProgress(budget, expense) },
                modifier = Modifier.fillMaxWidth().height(10.dp),
                color = AccentColor,
                trackColor = Color.White,
                strokeCap = StrokeCap.Round,
                drawStopIndicator = {}
            )
            Text(text = "${formatYen(expense)} / ${formatYen(budget)}", color = MaterialTheme.colorScheme.onPrimary, fontSize = 16.sp)
        }
    }
}

fun getBudgetProgress(budget: Int, expense: Int): Float {
    return (expense.toFloat() / budget.toFloat())
}

fun getUsablePayment(budget: Int, expense: Int): Int {
    return budget - expense
}

@Preview(showBackground = true)
@Composable
fun BalancePreview() {
    KoyomicarnetTheme() {
        BalanceView(1000, 90)
    }
}