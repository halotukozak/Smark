package halotukozak.smark
package tables


import tables.Column.symbol

import scala.collection.mutable.ArrayBuffer

private final class Table(private[tables] val rows: ArrayBuffer[Row | Header] = new ArrayBuffer[Row | Header]) extends AnyVal:
  extension (ab: Iterable[String])
    private def mkRow = ab.mkString("| ", " | ", " |")

  private[tables] def eval = rows.map {
    case r: Row => r.cells.map(_.elem).mkRow
    case h: Header => h.elements.map(_.name).mkRow + "\n" + h.elements.map(symbol).mkRow
  }.mkString("\n")


private class Row(private[tables] val cells: ArrayBuffer[Cell] = new ArrayBuffer[Cell]) extends AnyVal

private class Header(private[tables] val elements: Seq[Column]) extends AnyVal


sealed abstract class Column(val name: String)

private object Column:
  final case class Left(override val name: String) extends Column(name)

  final case class Right(override val name: String) extends Column(name)

  final case class Center(override val name: String) extends Column(name)

  final case class None(override val name: String) extends Column(name)

  def symbol: Column => String = (_: Column) match
    case Left(name) => ":---"
    case Right(name) => "---:"
    case Center(name) => ":---:"
    case None(name) => "---"

end Column

type Left = Column.Left
type Right = Column.Right
type Center = Column.Center
type None = Column.None
given Conversion[String, Left] = Column.Left(_)
given Conversion[String, Right] = Column.Right(_)
given Conversion[String, Center] = Column.Center(_)
given Conversion[String, None] = Column.None(_)


private final class Cell(private[tables] val elem: String) extends AnyVal

def table(init: Table ?=> Unit): String =
  given t: Table = Table()

  init(using t)
  t.eval

def row(init: Row ?=> Unit)(using t: Table): Unit =
  given r: Row = Row()

  init(using r)
  t.rows += r

def header(columns: (Column | String)*)(using t: Table): Unit =
  t.rows += Header(columns.map {
    case c: Column => c
    case s: String => s: None
  })

def cell(str: String)(using r: Row): Unit = r.cells += Cell(str)
