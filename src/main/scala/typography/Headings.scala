package halotukozak.smark
package typography

import utils.MdElement


private[smark] type HeadingLevel = 1 | 2 | 3 | 4 | 5 | 6

final class Heading[N <: HeadingLevel : ValueOf] extends MdElement:
  override def toString: String = evaluated.map(e => s"${"#" * valueOf[N]}$e").mkString("\n")
