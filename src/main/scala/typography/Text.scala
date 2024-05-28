package halotukozak.smark
package typography

import typography.macros.text

import scala.annotation.targetName
import scala.compiletime.constValue
import scala.quoted.{Expr, Quotes, quotes}

type Normal
type Bold
type Italic
type Strikethrough
type Subscript
type Superscript
type InlineCode
type BlockCode
type Code = InlineCode | BlockCode
type Quote

private[typography] type TextStyle = Normal | Bold | Italic | Strikethrough | Subscript | Superscript | Code | Quote

inline def bold(inner: String): String = text[Bold](inner)
inline def italic(inner: String): String = text[Italic](inner)
inline def boldAndItalic(inner: String): String = text[Bold & Italic](inner)
inline def strikethrough(inner: String): String = text[Strikethrough](inner)
inline def subscript(inner: String): String = text[Subscript](inner)
inline def superscript(inner: String): String = text[Superscript](inner)
inline def quoted(inner: String): String = text[Quote](inner)
