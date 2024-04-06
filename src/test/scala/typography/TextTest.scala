package halotukozak.smark
package typography

import typography.macros.text

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class TextTest extends AnyWordSpec with Matchers {

  "Text eval" when {
    "normal text" in {
      text[Normal]("HelloWorld") shouldBe "HelloWorld"
    }
    "bold text" in {
      text[Bold]("HelloWorld") shouldBe "**HelloWorld**"
    }
    "italic text" in {
      text[Italic]("HelloWorld") shouldBe "*HelloWorld*"
    }
    "bold italic text" in {
      text[Bold & Italic]("HelloWorld") shouldBe "***HelloWorld***"

      text[Italic & Bold]("HelloWorld") shouldBe "***HelloWorld***"
    }
    "strikethrough text" in {
      text[Strikethrough]("HelloWorld") shouldBe "~~HelloWorld~~"
    }
    "subscript text" in {
      text[Subscript]("HelloWorld") shouldBe "<sub>HelloWorld</sub>"
    }
    "superscript text" in {
      text[Superscript]("HelloWorld") shouldBe "<sup>HelloWorld</sup>"
    }
    "quoted text" in {
      text[Quote]("HelloWorld") shouldBe "> HelloWorld"
    }
  }

  "Nested text" should {
    "be evaluated correctly" in {
      text[Bold]("Hello" + text[Italic]("World")) shouldBe "**Hello*World***"
      text[Strikethrough]("Hello" + text[Subscript]("World")) shouldBe "~~Hello<sub>World</sub>~~"
      text[Bold](text[Bold](text[Bold]("Hello"))) shouldBe "******Hello******"
    }
  }

  "untyped" should {
    "be evaluated correctly" in {
      bold("HelloWorld") shouldBe "**HelloWorld**"
      italic("HelloWorld") shouldBe "*HelloWorld*"
      boldAndItalic("HelloWorld") shouldBe "***HelloWorld***"
      strikethrough("HelloWorld") shouldBe "~~HelloWorld~~"
      subscript("HelloWorld") shouldBe "<sub>HelloWorld</sub>"
      superscript("HelloWorld") shouldBe "<sup>HelloWorld</sup>"
    }
    "not be evaluated" in {
      assertDoesNotCompile("text(\"HelloWorld\")")
    }
  }
}
