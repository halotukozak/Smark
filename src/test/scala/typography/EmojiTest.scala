package halotukozak.smark
package typography

import typography.macros.{emoji, emojiUnsafe}

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class EmojiTest extends AnyWordSpec with Matchers {

  "emoji" should {
    "be evaluated correctly" in {
      emoji[smile] shouldBe ":smile:"
      emoji[`+1`] shouldBe ":+1:"
    }
  }

  "unsafeEmoji" should {
    "be evaluated correctly" in {
      emojiUnsafe("smile") shouldBe ":smile:"
      emojiUnsafe("+1") shouldBe ":+1:"
    }
  }

}
