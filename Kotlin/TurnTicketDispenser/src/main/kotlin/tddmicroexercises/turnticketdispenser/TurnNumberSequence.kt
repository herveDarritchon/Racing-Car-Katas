package tddmicroexercises.turnticketdispenser;

class TurnNumberSequence
{
    companion object {

    var _turnNumber : Int = 0

    fun getNextTurnNumber() : Int
    {
        return _turnNumber++
    }

    }
}
