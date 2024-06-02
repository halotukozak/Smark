package halotukozak.smark
package typography

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class EmojiTest extends AnyWordSpec with Matchers:

  "emoji" should {
    "be evaluated correctly" in {
      emojiMacro[smile] shouldBe ":smile:"
      emojiMacro[`+1`] shouldBe ":+1:"
    }
  }

end EmojiTest
