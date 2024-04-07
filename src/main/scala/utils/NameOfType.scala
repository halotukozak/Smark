package halotukozak.smark
package utils

import scala.quoted.{Expr, Quotes, Type}

inline def nameOf[T]: String = ${ nameOfImpl[T] }

def nameOfImpl[T](using Type[T], Quotes): Expr[String] = Expr {
  """halotukozak\.smark\.typography\.[A-Za-z]+\$package\.""".r.replaceAllIn(Type.show[T], "")
}
