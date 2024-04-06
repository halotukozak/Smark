package halotukozak.smark
package typography


import typography.headingUnsafe
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class HeadingTest extends AnyWordSpec with Matchers {

  "Heading" should {

    "be evaluated" when {
      "level 1" in {
        heading[1]("Hello") shouldBe "#Hello"
      }
      "level 2" in {
        heading[2]("Hello") shouldBe "##Hello"
      }
      "level 3" in {
        heading[3]("Hello") shouldBe "###Hello"
      }
      "level 4" in {
        heading[4]("Hello") shouldBe "####Hello"
      }
      "level 5" in {
        heading[5]("Hello") shouldBe "#####Hello"
      }
      "level 6" in {
        heading[6]("Hello") shouldBe "######Hello"
      }
    }

    "not be evaluated" when {
      "level is out of range" in {
        assertDoesNotCompile("""heading[7]("Hello")""")
        assertDoesNotCompile("""heading[0]("Hello")""")
        assertDoesNotCompile("""heading[-5]("Hello")""")
      }
    }

    "unsafe should be evaluated" when {
      "in range" in {
        for (i <- 1 to 6) do
          headingUnsafe(i, "Hello") shouldBe "#" * i + "Hello"
      }

      "out of range" in {
        for (i <- 7 to 10) do
          assertThrows[IllegalArgumentException](headingUnsafe(i, "Hello"))
        for (i <- -5 to 0) do
          assertThrows[IllegalArgumentException](headingUnsafe(i, "Hello"))
      }
    }
  }
}