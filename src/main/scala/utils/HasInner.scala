package halotukozak.smark
package utils

private[smark] abstract class HasInner[T](private var inner: Seq[T] = Nil):

  final def elements: Seq[T] = inner

  final def add(e: T): MdUnit = {
    inner = inner :+ e
  }.asInstanceOf
