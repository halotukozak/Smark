package halotukozak.smark
package typography.macros

import typography.*

import _root_.scala.quoted.{Expr, Quotes, Type}

inline def text[Styles <: TextStyle](inline inner: String): String = ${ textImpl[Styles]('{ inner }) }
private def textImpl[Styles <: TextStyle : Type](inner: Expr[String])(using Quotes): Expr[String] = {
  Type.of[Styles] match {
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
    case '[Quote] => '{ "> " + $inner }
  }
}
