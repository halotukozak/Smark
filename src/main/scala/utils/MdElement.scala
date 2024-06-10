package halotukozak.smark
package utils

private[smark] trait MdElement extends HasInner[MdContent]:
  final protected def evaluated: Seq[String] = iterator.map(_.toString).toSeq
