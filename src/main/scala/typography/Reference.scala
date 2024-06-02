package halotukozak.smark
package typography

import utils.nameOf

private[smark] inline def titleFrom[Title] = nameOf[Title].filterNot(_ == '"') match
  case "scala.Predef.String" => ""
  case t => t

private[smark] inline def linkMacro[Title <: String](inline url: String): String = s"[${titleFrom[Title]}]($url)"
private[smark] inline def imageMacro[title <: String](inline url: String): String = s"!${linkMacro[title](url)}"
