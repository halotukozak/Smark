package halotukozak.smark
package typography

import typography.*
import typography.macros.textMacro

private[smark] final class Quote[AlertType <: Alert : ValueOf] extends MdElement:
  override private[smark] def eval: String =
    (s"[!${valueOf[AlertType]}]" +: inner)
      .map(e => textMacro[Quoted](e.eval))
      .mkString("\n")

end Quote