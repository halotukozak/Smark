package halotukozak.smark

import tables.Table
import utils.{HasInner, MdElement}

type MdContent = String | MdElement | Table

opaque type MdUnit = Unit

private class Markdown extends MdElement:
  override def eval: String = evaluated.mkString("\n\n")

extension (s: MdContent)
  private def eval: String = s match
    case s: String => s
    case e: MdElement => e.eval
    case t: Table => t.eval
