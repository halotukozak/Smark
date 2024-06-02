package halotukozak.smark
package typography

import tables.*
import typography.*
import typography.macros.*

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class CodeTest extends AnyWordSpec with Matchers:

  "code text" should {
    "be evaluated correctly" when {
      "not specified" in {
        string.text[Code]("HelloWorld") shouldBe "`HelloWorld`"
        string.text[Code] {
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

        string.text[Code]("HelloWorld") shouldBe "`HelloWorld`"
        string.text[Code] {
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
        markdown {
          code(python"""print("HelloWorld")""")
        } shouldBe
          """```python
            |print("HelloWorld")
            |```""".stripMargin
      }
      "scala" in {
        markdown {
          code(scala"""println("HelloWorld")""")
        } shouldBe
          """```scala
            |println("HelloWorld")
            |```""".stripMargin
      }
      "java" in {
        markdown {
          code(java"""System.out.println("HelloWorld");""")
        } shouldBe
          """```java
            |System.out.println("HelloWorld");
            |```""".stripMargin
      }
      "kotlin" in {
        markdown {
          code(kotlin"""println("HelloWorld")""")
        } shouldBe
          """```kotlin
            |println("HelloWorld")
            |```""".stripMargin
      }
      "sql" in {
        markdown {
          code(sql"""SELECT * FROM table""")
        } shouldBe
          """```sql
            |SELECT * FROM table
            |```""".stripMargin
      }
      "bash" in {
        markdown {
          code(bash"""echo "HelloWorld"""")
        } shouldBe
          """```bash
            |echo "HelloWorld"
            |```""".stripMargin
      }
      "html" in {
        markdown {
          code(html"""<h1>HelloWorld</h1>""")
        } shouldBe
          """```html
            |<h1>HelloWorld</h1>
            |```""".stripMargin
      }
      "custom" in {
        type custom <: code
        markdown {
          code[custom](
            """
              |println("HelloWorld")
              |""".stripMargin.asInstanceOf[custom])
        } shouldBe
          """```custom
            |
            |println("HelloWorld")
            |
            |```""".stripMargin
      }
    }
  }

end CodeTest
