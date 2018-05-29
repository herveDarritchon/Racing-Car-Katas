package tddmicroexercises.telemetrysystem;

import java.util.*

class TelemetryClient(val connectionEventsSimulator: Random = Random(42),
                      var diagnosticMessageResult: String = "",
                      var onlineStatus: Boolean = false
) {

    companion object {

        val DIAGNOSTIC_MESSAGE: String = "AT#UD"
    }


    fun connect(telemetryServerConnectionString: String): Unit {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString)) {
            throw IllegalArgumentException()
        }

        // simulate the operation on a real modem
        val success: Boolean = connectionEventsSimulator.nextInt(10) <= 8

        onlineStatus = success
    }

    fun disconnect(): Unit {
        onlineStatus = false
    }

    fun send(message: String): Unit {
        if (message == null || "".equals(message)) {
            throw IllegalArgumentException()
        }

        if (message == DIAGNOSTIC_MESSAGE) {
            // simulate a status report
            diagnosticMessageResult =
                    "LAST TX rate................ 100 MBPS\r\n" + "HIGHEST TX rate............. 100 MBPS\r\n" +
                    "LAST RX rate................ 100 MBPS\r\n" + "HIGHEST RX rate............. 100 MBPS\r\n" +
                    "BIT RATE.................... 100000000\r\n" + "WORD LEN.................... 16\r\n" +
                    "WORD/FRAME.................. 511\r\n" + "BITS/FRAME.................. 8192\r\n" +
                    "MODULATION TYPE............. PCM/FM\r\n" + "TX Digital Los.............. 0.75\r\n" +
                    "RX Digital Los.............. 0.10\r\n" + "BEP Test.................... -5\r\n" +
                    "Local Rtrn Count............ 00\r\n" + "Remote Rtrn Count........... 00"

            return
        }

        // here should go the real Send operation (not needed for this exercise)
    }

    fun receive(): String {
        var message: String;

        if (diagnosticMessageResult == null || "".equals(diagnosticMessageResult)) {
            // simulate a received message (just for illustration - not needed for this exercise)
            message = ""
            var messageLength: Int = connectionEventsSimulator.nextInt(50) + 60
            for (i: Int in messageLength downTo 0) {
                message += connectionEventsSimulator.nextInt(40) + 86
            }

        } else {
            message = diagnosticMessageResult
            diagnosticMessageResult = ""
        }

        return message;
    }
}

