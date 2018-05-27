package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.*

// The reading of the pressure value from the sensor is simulated in this implementation.
// Because the focus of the exercise is on the other class.

class Sensor(val OFFSET: Double = 16.0) {

    fun popNextPressurePsiValue(): Double {
        var pressureTelemetryValue: Double
        pressureTelemetryValue = Sensor.samplePressure()

        return OFFSET + pressureTelemetryValue;
    }

    companion object {
        private fun samplePressure(): Double {
            // placeholder implementation that simulate a real sensor in a real tire
            val basicRandomNumbersGenerator: Random = Random()
            val pressureTelemetryValue: Double = 6 * basicRandomNumbersGenerator.nextDouble() * basicRandomNumbersGenerator.nextDouble()
            return pressureTelemetryValue;
        }
    }
}
