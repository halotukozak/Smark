package halotukozak.smark
package typography

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class ReferenceTest extends AnyWordSpec with Matchers {

  "link" should {
    "be evaluated correctly" in {
      link["Google"]("https://www.google.com") shouldBe "[Google](https://www.google.com)"
      link[""]("https://www.google.com") shouldBe "[](https://www.google.com)"
      link("https://www.google.com") shouldBe "[](https://www.google.com)"

      for name <- Seq("google", "facebook", "twitter") do
        link("https://www." + name + ".com") shouldBe s"[](https://www.$name.com)"

      for name <- Seq("google", "facebook", "twitter") do
        link("https://www." + name + ".com", name) shouldBe s"[$name](https://www.$name.com)"

    }
  }

  "image" should {
    "be evaluated correctly" in {
      image["img"]("https://www.google.com") shouldBe "![img](https://www.google.com)"
      image[""]("https://www.google.com") shouldBe "![](https://www.google.com)"
      image("https://www.google.com") shouldBe "![](https://www.google.com)"

      for name <- Seq("google", "facebook", "twitter") do
        image("https://www." + name + ".com") shouldBe s"![](https://www.$name.com)"

      for name <- Seq("google", "facebook", "twitter") do
        image("https://www." + name + ".com", name) shouldBe s"![$name](https://www.$name.com)"
    }
  }
}
