package com.zhugaru.calculator

import org.junit.Assert
import org.junit.Test

class CalculatorTest {
    private val calc = Calculator()

    @Test
    fun evaluate() {
        //given
        val input = "2+3"
        val expectedResult = "5"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate1() {
        //given
        val input = "4-6"
        val expectedResult = "-2"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate2() {
        //given
        val input = "2*3"
        val expectedResult = "6"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate3() {
        //given
        val input = "12/3"
        val expectedResult = "4"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate4() {
        //given
        val input = "2+3*4"
        val expectedResult = "14"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate5() {
        //given
        val input = "10/2-7+3*4"
        val expectedResult = "10"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate6() {
        //given
        val input = "10/(2-7+3)*4"
        val expectedResult = "-20"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate7() {
        //given
        val input = "22/3*3.0480"
        val expectedResult = "22.352"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate8() {
        //given
        val input = "22/4*2.159"
        val expectedResult = "11.8745"

        //run
        val result: String = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate9() {
        //given
        val input = "22/4*2,159"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate10() {
        //given
        val input = "- 12)1//("
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate11() {
        //given
        val input = "10/(5-5)";
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate12() {
        //given
        val input = null
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate13() {
        //given
        val input = "(12*(5-1)"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate14() {
        //given
        val input = ""
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate15() {
        //given
        val input = "5+41..1-6"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate16() {
        //given
        val input = "5++41-6"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate17() {
        //given
        val input = "5--41-6"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate18() {
        //given
        val input = "5**41-6"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }

    @Test
    fun evaluate19() {
        //given
        val input = "5//41-6"
        val expectedResult = null

        //run
        val result: String? = calc.evaluate(input)

        //assert
        Assert.assertEquals(expectedResult, result)
    }
}