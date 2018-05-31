package tddmicroexercises.leaderboard

import java.util.*

class Leaderboard(vararg races: Race) {

    private val races: List<Race> = Arrays.asList<Race>(*races)

    private fun driverResults(): Map<String, Int> {
        val results : HashMap<String, Int>  = HashMap()
        for (race : Race in this.races) {
            for (driver : Driver in race.results) {
                val driverName : String = race.getDriverName(driver)
                val points : Int = race.getPoints(driver)
                if (results.containsKey(driverName)) {
                    results[driverName] = results[driverName]!! + points
                } else {
                    results[driverName] = 0 + points
                }
            }
        }
        return results
    }

    fun driverRankings(): List<String> {
        val results = driverResults()
        val resultsList = ArrayList(results.keys)
        Collections.sort(resultsList, DriverByPointsDescendingComparator(results))
        return resultsList
    }

    private class DriverByPointsDescendingComparator constructor(private val results: Map<String, Int>) : Comparator<String> {

        override fun compare(driverName1: String, driverName2: String): Int {
            return -results[driverName1]!!.compareTo(results[driverName2]!!)
        }
    }

}
