package example

import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {
  test("CubeCalculstor.cube") {
    assert(CubeCalculator.cube(3) == 27)
  }

}
