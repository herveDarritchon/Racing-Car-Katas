package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls (val DiagnosticChannelConnectionString : String = "*111#",
                                          var telemetryClient : TelemetryClient,
                                          var diagnosticInfo : String = "")
{
        fun TelemetryDiagnosticControls()
        {
            telemetryClient = TelemetryClient()
        }


        fun checkTransmission() : Unit //throws Exception
        {
            diagnosticInfo = ""

            telemetryClient.disconnect()

            var retryLeft : Int = 3

            while (telemetryClient.onlineStatus == false && retryLeft > 0)
            {
                telemetryClient.connect(DiagnosticChannelConnectionString)
                retryLeft -= 1;
            }

            if(telemetryClient.onlineStatus == false)
            {
                throw Exception("Unable to connect.")
            }

            telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE)
            diagnosticInfo = telemetryClient.receive()
    }
}
