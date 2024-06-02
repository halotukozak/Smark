package halotukozak.smark

import tables.Table
import utils.HasInner

type MdContent = String | MdElement | Table
opaque type MdUnit = Unit

private trait MdElement extends HasInner[MdContent]:
  private[smark] def eval: String
end MdElement

private class Markdown extends MdElement:
  private[smark] def eval = inner.mkString("\n\n")

end Markdown

extension (s: MdContent)
  private def eval: String = s match
    case s: String => s
    case e: MdElement => e.eval
    case t: Table => t.eval

implicit def stringToModifier(s: String)(using m: MdElement): MdUnit = m.add(s)