package halotukozak.smark
package utils

private[smark] abstract class HasInner[T](private var inner: Seq[T] = Nil) extends Iterable[T]:
  final def iterator: Iterator[T] = inner.iterator
  final def add(e: T): MdUnit = {
    inner = inner :+ e
  }.asInstanceOf
