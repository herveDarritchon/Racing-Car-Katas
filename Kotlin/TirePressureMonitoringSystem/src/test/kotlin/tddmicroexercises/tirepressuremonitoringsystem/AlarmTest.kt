package tddmicroexercises.tirepressuremonitoringsystem

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

/**
 * Created by Hervé Darritchon on 10/06/2018.
 */
class AlarmTest {
    companion object {
        @BeforeAll
        @JvmStatic
        fun beforeAllTestCases() {
            println("Runs once before all test cases.")
        }

        @AfterAll
        @JvmStatic
        fun afterAllTestCases() {
            println("Runs once after all test cases.")
        }
    }

    @Test
    fun simpleTestCase() {
        println("A simple test case.")

        val numberTwo = 2
        assertEquals(2, numberTwo)
    }
}
