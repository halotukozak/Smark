package halotukozak.smark
package typography.macros

import typography.*
import utils.nameOf

inline def quote[AlertType <: Alert](inline inner: String*): String = (s"[!${nameOf[AlertType].capitalize}]" +: inner)
  .map(text[Quote]).mkString("\n")