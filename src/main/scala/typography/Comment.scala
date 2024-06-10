package halotukozak.smark
package typography

import utils.MdElement

final class Comment extends MdElement:
  override def toString: String = s"<!-- ${if evaluated.length == 1 then evaluated.mkString("\n") else evaluated.mkString("\n", "\n", "\n")} -->"
