package halotukozak.smark
package typography

import typography.macros.{list, taskList}

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

final class ListTest extends AnyWordSpec with Matchers {

  "List" should {
    "be evaluated" when {
      "asterisk" in {
        list[Asterisk]("a", "b", "c") shouldBe "* a\n* b\n* c"
      }
      "plus" in {
        list[Plus]("a", "b", "c") shouldBe "+ a\n+ b\n+ c"
      }
      "hyphen" in {
        list[Hyphen]("a", "b", "c") shouldBe "- a\n- b\n- c"
      }
      "unordered" in {
        list[Unordered]("a", "b", "c") shouldBe "* a\n* b\n* c"
      }
      "ordered" in {
        list[Ordered]("a", "b", "c") shouldBe "1. a\n2. b\n3. c"
      }
      "default" ignore {
        //        list("a", "b", "c") shouldBe "* a\n* b\n* c"
      }


    }
  }

  "task list" should {
    "be evaluated" when {
      "only task" in {
        taskList("a", "b", "c") shouldBe "- [ ] a\n- [ ] b\n- [ ] c"
      }
      "with completion status" in {
        taskList(
          true -> "a",
          false -> "b",
          true -> "c",
        ) shouldBe "- [x] a\n- [ ] b\n- [x] c"
      }
      "mixed" in {
        taskList(
          true -> "a",
          "b",
          false -> "c",
        ) shouldBe "- [x] a\n- [ ] b\n- [ ] c"
      }
    }
  }

}
