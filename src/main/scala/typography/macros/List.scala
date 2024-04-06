package halotukozak.smark
package typography.macros

import typography.*

import _root_.scala.quoted.{Expr, Quotes, Type}

inline def list[Style <: ListStyle](inline inner: String*): String = ${ listImpl[Style]('{ inner }) }
private def listImpl[Style <: ListStyle : Type](inner: Expr[Seq[String]])(using Quotes): Expr[String] = {
  Type.of[Style] match {
    case '[Ordered] => '{ $inner.zipWithIndex.map((s, i) => s"${i + 1}. $s").mkString("\n") }
    case '[Unordered] =>
      '{
        val marker = ${ Expr(Type.of[Style] match
          case '[Plus] => "+"
          case '[Hyphen] => "-"
          case _ => "*"
        ) }
        $inner.map(s => s"$marker $s").mkString("\n")
      }
  }
}

inline def taskList(inline points: ((Boolean, String) | String)*): String = ${ taskListImpl('{ points }) }
private def taskListImpl(points: Expr[Seq[(Boolean, String) | String]])(using Quotes): Expr[String] = {
  '{ $points.map {
    case (true, s) => s"- [x] $s"
    case (false, s) => s"- [ ] $s"
    case s: String => s"- [ ] $s"
  }.mkString("\n") }
}