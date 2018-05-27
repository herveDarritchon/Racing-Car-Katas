package tddmicroexercises.turnticketdispenser

class TicketDispenser {
    val turnTicket: TurnTicket
        get() {
            val newTurnNumber = TurnNumberSequence.getNextTurnNumber()
            val newTurnTicket = TurnTicket(newTurnNumber)

            return newTurnTicket
        }
}
