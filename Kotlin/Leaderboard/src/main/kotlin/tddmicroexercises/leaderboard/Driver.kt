package tddmicroexercises.leaderboard

open class Driver(val name: String, val country: String) {

    override fun hashCode(): Int {
        return name.hashCode() * 31 + country.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || other !is Driver) {
            return false
        }
        val other = other
        return this.name == other.name && this.country == other.country
    }
}
