package halotukozak.smark
package typography

import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


final class QuoteTest extends AnyWordSpec with Matchers:

  "quote" should {
    "be evaluated correctly" in {
      markdown {
        quote[Note]("Hello, World!")
      } shouldBe
        """|> [!Note]
           |> Hello, World!""".stripMargin
      markdown {
        quote[Tip]("Hello, World!")
      } shouldBe
        """|> [!Tip]
           |> Hello, World!""".stripMargin
      markdown {
        quote[Warning]("Hello, World!")
      } shouldBe
        """|> [!Warning]
           |> Hello, World!""".stripMargin
      markdown {
        quote[Caution]("Hello, World!")
      } shouldBe
        """|> [!Caution]
           |> Hello, World!""".stripMargin

      markdown {
        quote[Note] {
          text[Normal]("Hello")
          text[Bold]("World")
        }
      } shouldBe
        """|> [!Note]
           |> Hello
           |> **World**""".stripMargin
    }
  }
end QuoteTest
