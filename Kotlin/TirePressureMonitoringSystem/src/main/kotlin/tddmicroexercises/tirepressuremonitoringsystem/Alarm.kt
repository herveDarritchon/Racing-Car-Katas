package tddmicroexercises.tirepressuremonitoringsystem

class Alarm (val LowPressureThreshold : Double = 17.0,
                    val HighPressureThreshold : Double = 21.0,
                    var sensor : Sensor = Sensor(),
                    var alarmOn : Boolean = false)
{

    fun check()
    {
        val psiPressureValue : Double = this.sensor.popNextPressurePsiValue()

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    fun isAlarmOn() : Boolean
    {
        return alarmOn;
    }
}
