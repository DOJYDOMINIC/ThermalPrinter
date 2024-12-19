package com.example.myapplication.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dantsu.escposprinter.EscPosPrinter
import com.dantsu.escposprinter.connection.bluetooth.BluetoothConnection
import com.dantsu.escposprinter.connection.bluetooth.BluetoothPrintersConnections

@Composable
fun PrintReceiptButton() {
    val printer = BluetoothPrintersConnections.selectFirstPaired()
    if (printer != null) {
        Button(
            onClick = { printReceipt(printer) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "print Bluetooth")
        }
        Button(
            onClick = { printReceipt(printer) },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Print")
        }
    } else {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "No paired Bluetooth printer found", modifier = Modifier.padding(16.dp))
        }
    }
}

fun printReceipt(printer: BluetoothConnection) {
    val escPosPrinter = EscPosPrinter(
        printer,
        203,  // Dots per inch (DPI)
        48f,  // Text size
        32    // Number of characters per line
    )
    val receiptContent = """
        [L]
        [C]<u><font size='big'>ORDER N°045</font></u>
        [C]================================
        [L]
        [L]<b>BEAUTIFUL SHIRT</b>[R]9.99€
        [L]  + Size : S
        [L]
        [L]<b>AWESOME HAT</b>[R]24.99€
        [L]  + Size : 57/58
        [L]
        [C]--------------------------------
        [R]TOTAL PRICE :[R]34.98€
        [R]TAX :[R]4.23€
        [L]
        [C]================================
        [L]
        [L]<font size='tall'>Customer :</font>
        [L]Raymond DUPONT
        [L]5 rue des girafes
        [L]31547 PERPETES
        [L]Tel : +33801201456
        [L]
        [C]<barcode type='ean13' height='10'>831254784551</barcode>
    """.trimIndent()

    try {
        escPosPrinter.printFormattedText(receiptContent)
//        Toast.makeText(context, "Printing Receipt", Toast.LENGTH_SHORT).show()
    } catch (e: Exception) {
        // Toast.makeText(context, "Error printing receipt: ${e.message}", Toast.LENGTH_SHORT).show()
    }
}
