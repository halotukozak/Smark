package halotukozak.smark
package typography

import typography.*
import typography.macros.textMacro
import utils.MdElement

private[smark] final class Quote[AlertType <: Alert : ValueOf] extends MdElement:
  override def toString: String =
    (s"[!${valueOf[AlertType]}]" +: evaluated)
      .map(textMacro[Quoted])
      .mkString("\n")

end Quote
