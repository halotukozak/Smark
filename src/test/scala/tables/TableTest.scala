package halotukozak.smark
package tables

import typography.macros.text
import typography.{Bold, Code, ScalaHelper}

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


final class TableTest extends AnyWordSpec with Matchers {

  "table" should {
    "be evaluated" in {
      table {
        row {}
      } shouldBe "|  |"

      table {
        row {
          cell("a")
          cell("b")
        }
      } shouldBe "| a | b |"

      table {
        row {
          cell {
            text[Bold]("a")
          }
          cell("b")
        }
        row {
          cell {
            text[Code](scala"val x = 1")
          }
          cell("d")
        }
      } shouldBe "| **a** | b |\n| `val x = 1` | d |"

      table {
        header("a": Left, "b")
        row {
          cell("1")
          cell("2")
        }
      } shouldBe "| a | b |\n| :--- | --- |\n| 1 | 2 |"

      table {
        header("a": Right, "b": Center)
        row {
          cell("1")
          cell("2")
        }
      } shouldBe "| a | b |\n| ---: | :---: |\n| 1 | 2 |"
    }
  }

}
