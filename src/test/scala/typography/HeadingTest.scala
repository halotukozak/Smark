package halotukozak.smark
package typography


import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class HeadingTest extends AnyWordSpec with Matchers:

  "Heading" should {
    "be evaluated" when {
      "level 1" in {
        markdown {
          heading[1] {
            "Hello"
          }
        } shouldBe "#Hello"
      }
      "level 2" in {
        markdown {
          heading[2]("Hello")
        } shouldBe "##Hello"
      }
      "level 3" in {
        markdown {
          heading[3]("Hello")
        } shouldBe "###Hello"
      }
      "level 4" in {
        markdown {
          heading[4]("Hello")
        } shouldBe "####Hello"
      }
      "level 5" in {
        markdown {
          heading[5]("Hello")
        } shouldBe "#####Hello"
      }
      "level 6" in {
        markdown {
          heading[6]("Hello")
        } shouldBe "######Hello"
      }
      "multiline" in {
        markdown {
          heading[1] {
            text[Normal]("Hello")
            text[Bold]("World")
          }
        } shouldBe "#Hello\n#**World**"
      }
    }

    "not be evaluated" when {
      "level is out of range" in {
        assertDoesNotCompile("""markdown{ heading[7]("Hello") }""")
        assertDoesNotCompile("""markdown{ heading[0]("Hello") }""")
        assertDoesNotCompile("""markdown{ heading[-5]("Hello") }""")
      }
    }
  }

end HeadingTest
