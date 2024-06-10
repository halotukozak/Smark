package halotukozak.smark

import tables.Table
import utils.{HasInner, MdElement}

type MdContent = String | MdElement | Table

opaque type MdUnit = Unit

private class Markdown extends MdElement:
  override def toString: String = evaluated.mkString("\n\n")
