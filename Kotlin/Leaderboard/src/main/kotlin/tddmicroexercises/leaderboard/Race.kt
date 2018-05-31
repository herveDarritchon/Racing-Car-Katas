package tddmicroexercises.leaderboard

import java.util.*

class Race(private val name: String, vararg drivers: Driver) {
    val results: List<Driver>

    private val driverNames: MutableMap<Driver, String>

    init {
        this.results = Arrays.asList(*drivers)
        this.driverNames = HashMap()
        for (driver in results) {
            var driverName: String = driver.name
            if (driver is SelfDrivingCar) {
                driverName = "Self Driving Car - " + driver.country + " (" + driver.algorithmVersion + ")"
            }
            this.driverNames[driver] = driverName
        }
    }

    fun position(driver: Driver): Int {
        return this.results.indexOf(driver)
    }

    fun getPoints(driver: Driver): Int {
        return Race.POINTS[position(driver)]
    }

    fun getDriverName(driver: Driver): String {
        return this.driverNames[driver].toString()
    }

    override fun toString(): String {
        return name
    }

    companion object {

        private val POINTS = arrayOf(25, 18, 15)
    }
}
