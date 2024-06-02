package halotukozak.smark
package typography.macros

import typography.*

import _root_.scala.quoted.{Expr, Quotes, Type}

private[smark] inline def textMacro[Style <: TextStyle](inline inner: String): String = ${ textImpl[Style]('{ inner }) }
def textImpl[Style <: TextStyle : Type](inner: Expr[String])(using Quotes): Expr[String] = {
  Type.of[Style] match {
    case '[Normal] => inner
    case '[Bold & Italic] => '{ "***" + $inner + "***" }
    case '[Bold] => '{ "**" + $inner + "**" }
    case '[Italic] => '{ "*" + $inner + "*" }
    case '[Strikethrough] => '{ "~~" + $inner + "~~" }
    case '[Subscript] => '{ "<sub>" + $inner + "</sub>" }
    case '[Superscript] => '{ "<sup>" + $inner + "</sup>" }
    case '[InlineCode] => '{ "`" + $inner + "`" }
    case '[BlockCode] => '{ "```\n" + $inner + "\n```" }
    case '[Code] => '{
      if ($inner.split("\n").length == 1) "`" + $inner + "`"
      else "```\n" + $inner + "\n```"
    }
    case '[Quoted] => '{ "> " + $inner }
  }
}
