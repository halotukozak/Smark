package halotukozak.smark
package typography

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class ReferenceTest extends AnyWordSpec with Matchers:

  "link" should {
    "be evaluated correctly" in {
      string.link["Google"]("https://www.google.com") shouldBe "[Google](https://www.google.com)"
      string.link[""]("https://www.google.com") shouldBe "[](https://www.google.com)"
      string.link("https://www.google.com") shouldBe "[](https://www.google.com)"

      markdown {
        link["Google"]("https://www.google.com")
      } shouldBe "[Google](https://www.google.com)"
      markdown {
        link[""]("https://www.google.com")
      } shouldBe "[](https://www.google.com)"
      markdown {
        link("https://www.google.com")
      } shouldBe "[](https://www.google.com)"
    }
  }

  "image" should {
    "be evaluated correctly" in {
      string.image["img"]("https://www.google.com") shouldBe "![img](https://www.google.com)"
      string.image[""]("https://www.google.com") shouldBe "![](https://www.google.com)"
      string.image("https://www.google.com") shouldBe "![](https://www.google.com)"

      markdown {
        image["img"]("https://www.google.com")
      } shouldBe "![img](https://www.google.com)"
      markdown {
        image[""]("https://www.google.com")
      } shouldBe "![](https://www.google.com)"
      markdown {
        image("https://www.google.com")
      } shouldBe "![](https://www.google.com)"
    }
  }

end ReferenceTest
