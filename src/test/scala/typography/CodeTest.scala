package halotukozak.smark
package typography

import typography.macros.text

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class CodeTest extends AnyWordSpec with Matchers {
  "code text" should {
    "be evaluated correctly" when {
      "no specified" in {
        text[Code]("HelloWorld") shouldBe "`HelloWorld`"
        text[Code] {
          """
            |var a = 1
            |var b = 2
            |""".stripMargin
        } shouldBe {
          """```
            |
            |var a = 1
            |var b = 2
            |
            |```""".stripMargin
        }

        text[Code]("HelloWorld") shouldBe "`HelloWorld`"
        text[Code] {
          """
            |var a = 1
            |var b = 2
            |""".stripMargin
        } shouldBe {
          """```
            |
            |var a = 1
            |var b = 2
            |
            |```""".stripMargin
        }
      }

      "python" in {
        code(python"""print("HelloWorld")""") shouldBe
          """python```
            |print("HelloWorld")
            |```""".stripMargin
      }
      "scala" in {
        code(scala"""println("HelloWorld")""") shouldBe
          """scala```
            |println("HelloWorld")
            |```""".stripMargin
      }
      "java" in {
        code(java"""System.out.println("HelloWorld")""") shouldBe
          """java```
            |System.out.println("HelloWorld")
            |```""".stripMargin
      }
      "kotlin" in {
        code(kotlin"""println("HelloWorld")""") shouldBe
          """kotlin```
            |println("HelloWorld")
            |```""".stripMargin
      }
      "sql" in {
        code(sql"""SELECT * FROM table""") shouldBe
          """sql```
            |SELECT * FROM table
            |```""".stripMargin
      }
      "bash" in {
        code(bash"""echo "HelloWorld"""") shouldBe
          """bash```
            |echo "HelloWorld"
            |```""".stripMargin
      }
      "html" in {
        html"""<h1>HelloWorld</h1>""" shouldBe
          """
            |<h1>HelloWorld</h1>
            |""".stripMargin
      }
      "Custom" in {
        codeUnsafe(
          "custom",
          """
            |println("HelloWorld")
            |""".stripMargin) shouldBe
          """custom```
            |
            |println("HelloWorld")
            |
            |```""".stripMargin
      }
    }

  }
}
