package halotukozak.smark
package typography

final class Paragraph extends MdElement:

  override private[smark] def eval: String = paragraphMacro(inner.map(e => e.eval).mkString("\n\n"))

private[smark] inline def paragraphMacro(inline inner: String): String = "\n" + inner
