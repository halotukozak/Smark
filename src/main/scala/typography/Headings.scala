package halotukozak.smark
package typography


private[smark] type HeadingLevel = 1 | 2 | 3 | 4 | 5 | 6

final class Heading[N <: HeadingLevel : ValueOf] extends MdElement:
  override private[smark] def eval: String = inner.map(e => headingMacro[N](e.eval)).mkString("\n")

private[smark] inline def headingMacro[N <: HeadingLevel : ValueOf](inline inner: String): String = "#" * valueOf[N] + inner
