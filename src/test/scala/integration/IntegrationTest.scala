package halotukozak.smark
package integration

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class IntegrationTest extends AnyWordSpec with Matchers:

  "Integration" should {
    "work" in {
      markdown {
        text[Normal]("hello")
        text[Bold]("boldedHello")
        text[Normal](string.text[Italic]("world"))
        heading[1]("heading1")
        heading[2](string.text[Bold]("heading2"))
        code {
          scala"""val x = 1"""
        }
        emoji[joy]
        quote[Caution]("read this!")
        paragraph {
          text[Bold & Italic]("boldedHello")
          heading[4](string.text[Bold]("heading4"))
          list[Ordered](
            "item1",
            "item2",
          )
        }
        taskList(
          true -> "task1",
          false -> "task2",
          "task3"
        )
        image["Google"](url = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png")
        link["Google"](url = "https://www.google.com")
        table {
          row {
            cell {
              text[Bold]("a")
              text[Italic]("ba")
            }
            cell("b")
          }
          row {
            cell {
              //              string.text[Code](scala"val x = 1")
            }
            cell("d")
          }
        }
      } shouldEqual
        """hello
          |
          |**boldedHello**
          |
          |*world*
          |
          |#heading1
          |
          |##**heading2**
          |
          |```scala
          |val x = 1
          |```
          |
          |:joy:
          |
          |> [!Caution]
          |> read this!
          |
          |
          |***boldedHello***
          |
          |####**heading4**
          |
          |1. item1
          |2. item2
          |
          |- [x] task1
          |- [ ] task2
          |- [ ] task3
          |
          |![Google](https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png)
          |
          |[Google](https://www.google.com)
          |
          || **a***ba* | b |
          || `val x = 1` | d |""".stripMargin
    }
  }
end IntegrationTest
