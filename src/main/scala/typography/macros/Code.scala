package halotukozak.smark
package typography.macros

import scala.quoted.{Expr, Quotes}

inline def codeUnsafe(inline language: String, inline inner: String): String = ${ codeUnsafeImpl('{ language }, '{ inner }) }
def codeUnsafeImpl(language: Expr[String], inner: Expr[String])(using Quotes): Expr[String] = '{ "```" + $language + "\n" + $inner + "\n```" }
