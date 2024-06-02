package halotukozak.smark
package typography

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class TextTest extends AnyWordSpec with Matchers:

  "Text eval" when {
    "normal text" in {
      string.text[Normal]("HelloWorld") shouldBe "HelloWorld"
    }
    "bold text" in {
      string.text[Bold]("HelloWorld") shouldBe "**HelloWorld**"
    }
    "italic text" in {
      string.text[Italic]("HelloWorld") shouldBe "*HelloWorld*"
    }
    "bold italic text" in {
      string.text[Bold & Italic]("HelloWorld") shouldBe "***HelloWorld***"

      string.text[Italic & Bold]("HelloWorld") shouldBe "***HelloWorld***"
    }
    "strikethrough text" in {
      string.text[Strikethrough]("HelloWorld") shouldBe "~~HelloWorld~~"
    }
    "subscript text" in {
      string.text[Subscript]("HelloWorld") shouldBe "<sub>HelloWorld</sub>"
    }
    "superscript text" in {
      string.text[Superscript]("HelloWorld") shouldBe "<sup>HelloWorld</sup>"
    }
    "quoted text" in {
      string.text[Quoted]("HelloWorld") shouldBe "> HelloWorld"
    }
  }

  "Nested text" should {
    "be evaluated correctly" in {
      string.text[Bold]("Hello" + string.text[Italic]("World")) shouldBe "**Hello*World***"
      string.text[Strikethrough]("Hello" + string.text[Subscript]("World")) shouldBe "~~Hello<sub>World</sub>~~"
      string.text[Bold](string.text[Bold](string.text[Bold]("Hello"))) shouldBe "******Hello******"
    }
  }

  "untyped" should {
    "not be evaluated" in {
      assertDoesNotCompile("text(\"HelloWorld\")")
    }
  }
end TextTest
