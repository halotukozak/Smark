package halotukozak.smark
package utils

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, Seq}

private[smark] abstract class HasInner[T](private[smark] val inner: ListBuffer[T] = new ListBuffer[T]):
  final def add(e: T): Unit = inner.addOne(e)
