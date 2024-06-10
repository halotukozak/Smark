package halotukozak.smark
package tables


import tables.Column.symbol
import utils.{HasInner, MdElement}


private[smark] final class Table extends HasInner[Row | Header]:
  extension (it: Iterator[String])
    private def mkRow = it.mkString("| ", " | ", " |")

  override def toString: String = iterator.map {
    case r: Row => r.iterator.map(_.toString).mkRow
    case h: Header => h.iterator.map(_.name).mkRow + "\n" + h.iterator.map(symbol).mkRow
  }.mkString("\n")


private[smark] class Row extends HasInner[Cell]

private[smark] class Header(elements: Seq[Column]) extends HasInner[Column](elements)

private[smark] sealed abstract class Column(val name: String)

private[smark] object Column:
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

private[smark] final class Cell extends MdElement:
  override def toString: String = evaluated.mkString("\n")
end Cell
