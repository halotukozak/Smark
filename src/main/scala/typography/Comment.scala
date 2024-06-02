package halotukozak.smark
package typography

final class Comment extends MdElement:
  override private[smark] def eval: String =
    val lines = inner.map(e => e.eval).toSeq
    commentMacro(if lines.length == 1 then lines.mkString("\n") else lines.mkString("\n", "\n", "\n"))

private[smark] inline def commentMacro(inline inner: String): String = s"<!-- $inner -->"
