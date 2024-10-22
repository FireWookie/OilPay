package oilpay.mobile.foundation.uikit.input

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.oilpay.mobile.foundation.core.utils.PhoneVisualTransformation

private const val MASK_NUMBER = '0'
private const val MASK = "000 000 00 00"

@Composable
fun PhoneField(
    phone: String,
    modifier: Modifier = Modifier,
    mask: String = MASK,
    maskNumber: Char = MASK_NUMBER,
    onPhoneChanged: (String) -> Unit
) {
    OutlinedTextField(
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Phone,
                null,
                modifier = Modifier
                    .padding(start = 25.dp)
                    .padding(end = 10.dp)
            )
        },
        value = phone,
        onValueChange = { it ->
            val digit = it.filter { char ->
                char.isDigit()
            }
            onPhoneChanged(digit.take(mask.count { it == maskNumber }))
        },
        placeholder = {
            Row {
                Text("+998", color = Color.White)
                Text(
                    text = " 00 000 00 00",
                    color = Color(0xff6A6A6A)
                )
            }
        },
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.White,
            focusedContainerColor = Color.Black,
            unfocusedContainerColor = Color.Black,
            unfocusedIndicatorColor = Color(0xffFF7C1A)

        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        visualTransformation = PhoneVisualTransformation(mask, maskNumber),
        modifier = modifier.fillMaxWidth(),
    )
}