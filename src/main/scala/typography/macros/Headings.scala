package halotukozak.smark
package typography.macros

import typography.HeadingLevel

import scala.quoted.{Expr, Quotes}

inline def heading[N <: HeadingLevel : ValueOf](inline inner: String): String = ${ headingImpl('{ inner }, '{ valueOf[N] }) }
private def headingImpl(inner: Expr[String], n: Expr[Int])(using Quotes): Expr[String] = '{ "#" * $n + $inner }
