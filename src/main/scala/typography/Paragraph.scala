package halotukozak.smark
package typography

import utils.MdElement

final class Paragraph extends MdElement:
  override def toString: String = "\n" + evaluated.mkString("\n\n")
