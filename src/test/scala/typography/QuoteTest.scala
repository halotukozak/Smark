package halotukozak.smark
package typography

import typography.*
import typography.macros.quote

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class QuoteTest extends AnyWordSpec with Matchers {
  "quote" should {
    "be evaluated correctly" in {
      quote[Note]("Hello, World!") shouldBe
        """|> [!Note]
           |> Hello, World!""".stripMargin
      quote[Tip]("Hello, World!") shouldBe
        """|> [!Tip]
           |> Hello, World!""".stripMargin
      quote[Warning]("Hello, World!") shouldBe
        """|> [!Warning]
           |> Hello, World!""".stripMargin
      quote[Caution]("Hello, World!") shouldBe
        """|> [!Caution]
           |> Hello, World!""".stripMargin

      typography.note("Hello, World!") shouldBe
        """|> [!Note]
           |> Hello, World!""".stripMargin
      tip("Hello, World!") shouldBe
        """|> [!Tip]
           |> Hello, World!""".stripMargin
      warning("Hello, World!") shouldBe
        """|> [!Warning]
           |> Hello, World!""".stripMargin
      caution("Hello, World!") shouldBe
        """|> [!Caution]
           |> Hello, World!""".stripMargin

    }
  }
}
