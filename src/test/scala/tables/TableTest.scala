package halotukozak.smark
package tables

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class TableTest extends AnyWordSpec with Matchers:

  "table" should {
    "be evaluated" in {
      markdown {
        table {
          row{
            cell{
              ""
            }
          }
        }
      } shouldBe "|  |"

      markdown {
        table {
          row {
            cell("a")
            cell("b")
          }
        }
      } shouldBe "| a | b |"

      markdown {
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
        }
      } shouldBe "| **a** | b |\n| `val x = 1` | d |"

      markdown {
        table {
          header("a": Left, "b")
          row {
            cell("1")
            cell("2")
          }
        }
      } shouldBe "| a | b |\n| :--- | --- |\n| 1 | 2 |"

      markdown {
        table {
          header("a": Right, "b": Center)
          row {
            cell("1")
            cell("2")
          }
        }
      } shouldBe "| a | b |\n| ---: | :---: |\n| 1 | 2 |"
    }
  }

end TableTest
