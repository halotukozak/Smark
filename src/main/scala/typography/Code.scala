package halotukozak.smark
package typography

import typography.macros.{codeUnsafe, text}
import utils.nameOf

type code <: String
type scala <: code
type python <: code
type java <: code
type kotlin <: code
type sql <: code
type bash <: code
type html <: code

inline def code[L <: code](inline code: L): String = codeUnsafe(nameOf[L], code)

implicit class ScalaHelper(private val sc: StringContext) extends AnyVal {
  def scala(args: Any*): scala = sc.s(args *).asInstanceOf[scala]

  def python(args: Any*): python = sc.s(args *).asInstanceOf[python]

  def java(args: Any*): java = sc.s(args *).asInstanceOf[java]

  def kotlin(args: Any*): kotlin = sc.s(args *).asInstanceOf[kotlin]

  def sql(args: Any*): sql = sc.s(args *).asInstanceOf[sql]

  def bash(args: Any*): bash = sc.s(args *).asInstanceOf[bash]

  def html(args: Any*): html = sc.s(args *).asInstanceOf[html]
}
