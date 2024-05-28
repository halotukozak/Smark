package halotukozak.smark
package typography

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EmojiTest extends AnyWordSpec with Matchers {

  "emoji" should {
    "be evaluated correctly" in {
      emoji[smile] shouldBe ":smile:"
      emoji[`+1`] shouldBe ":+1:"
    }
  }
}
