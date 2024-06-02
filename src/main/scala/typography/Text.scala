package halotukozak.smark
package typography

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
type Quoted

private[smark] type TextStyle = Normal | Bold | Italic | Strikethrough | Subscript | Superscript | Code | Quoted
