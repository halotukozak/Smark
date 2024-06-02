package halotukozak.smark
package typography

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class OtherTest extends AnyWordSpec with Matchers:

  "paragraph" should {
    "be evaluated correctly" in {
      markdown {
        paragraph {
          text[Normal]("hello")
          text[Bold]("boldedHello")
          text[Normal](string.text[Italic]("world"))
        }
      } shouldBe
        """
          |hello
          |
          |**boldedHello**
          |
          |*world*""".stripMargin
    }
  }

  "comment" should {
    "be evaluated correctly" in {
      markdown {
        comment("hello")
      } shouldBe "<!-- hello -->"

      markdown {
        comment {
          text[Normal]("hello")
          text[Bold]("boldedHello")
          text[Normal](string.text[Italic]("world"))
        }
      } shouldBe
        """<!-- 
          |hello
          |**boldedHello**
          |*world*
          |-->""".stripMargin
    }
  }

  "hr" should {
    "be evaluated correctly" in {
      markdown {
        hr
      } shouldBe "***"
    }
  }
end OtherTest

