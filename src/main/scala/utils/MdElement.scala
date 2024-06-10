package halotukozak.smark
package utils

private[smark] trait MdElement extends HasInner[MdContent]:
  def eval: String

  final protected def evaluated: Seq[String] = elements.map(_.eval)
  