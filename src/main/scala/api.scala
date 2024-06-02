package halotukozak.smark

import tables.*
import typography.*
import typography.macros.*


private inline def initAndAdd[T <: MdElement](inline q: T)(inline init: T ?=> MdUnit)(using m: MdElement): MdUnit =
  init(using q)
  m.add(q)

def markdown(init: MdElement ?=> MdUnit): String =
  given m: MdElement = new Markdown

  init(using m)
  m.eval

inline def text[Style <: TextStyle](inline inner: String)(using m: MdElement): MdUnit = m.add(textMacro[Style](inner))

inline def emoji[E <: Emoji](using m: MdElement): MdUnit = m.add(emojiMacro[E])

inline def quote[AlertType <: Alert : ValueOf](inline init: MdElement ?=> MdUnit)(using m: MdElement): MdUnit = initAndAdd(new typography.Quote[AlertType])(init)

inline def heading[N <: HeadingLevel : ValueOf](inline init: MdElement ?=> MdUnit)(using m: MdElement): MdUnit = initAndAdd(new typography.Heading[N])(init)

inline def code[L <: code](inline inner: L)(using m: MdElement): MdUnit = m.add(codeMacro[L](inner))

inline def list[Style <: ListStyle](inline elements: String*)(using m: MdElement): MdUnit = m.add(listMacro[Style](elements))

inline def taskList(inline points: ((Boolean, String) | String)*)(using m: MdElement): MdUnit = m.add(taskListMacro(points *))

inline def hr(using m: MdElement): MdUnit = m.add("***")

inline def paragraph(inline init: MdElement ?=> MdUnit)(using m: MdElement): MdUnit = initAndAdd(new typography.Paragraph)(init)

inline def comment(inline init: MdElement ?=> MdUnit)(using m: MdElement): MdUnit = initAndAdd(new typography.Comment)(init)

inline def link[Title <: String](inline url: String)(using m: MdElement): MdUnit = m.add(linkMacro[Title](url))

inline def image[title <: String](inline url: String)(using m: MdElement): MdUnit = m.add(imageMacro[title](url))

def table(init: Table ?=> MdUnit)(using m: MdElement): MdUnit =
  given t: Table = new Table

  init(using t)
  m.add(t)

def row(init: Row ?=> MdUnit)(using t: Table): MdUnit =
  given r: Row = new Row

  init(using r)
  t.add(r)

def header(columns: (Column | String)*)(using t: Table): MdUnit =
  t.add {
    Header(columns.map {
      case c: Column => c
      case s: String => Column.None(s)
    })
  }

def cell(init: MdElement ?=> MdUnit)(using r: Row): MdUnit =
  r.add {
    given c: Cell = new Cell

    init(using c)
    c
  }


package string:
  inline def text[Style <: TextStyle](inline inner: String): String = textMacro[Style](inner)

  inline def emoji[E <: Emoji]: String = emojiMacro[E]

  inline def link[Title <: String](inline url: String): String = linkMacro[Title](url)

  inline def image[title <: String](inline url: String): String = imageMacro[title](url)
end string


import _root_.scala.language.implicitConversions

given Conversion[Unit, MdUnit] with
  def apply(u: Unit): MdUnit = ().asInstanceOf