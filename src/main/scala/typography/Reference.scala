package halotukozak.smark
package typography

import utils.nameOf

private inline def titleFrom[Title] = nameOf[Title].filterNot(_ == '"') match
  case "scala.Predef.String" => ""
  case t => t
inline def link[Title <: String](inline url: String): String = "[" + titleFrom[Title] + "](" + url + ")"
inline def link(inline url: String, inline title: String): String = "[" + title + "](" + url + ")"

inline def image[title <: String](inline url: String): String = "![" + titleFrom[title] + "](" + url + ")"
inline def image(inline url: String, inline title: String): String = "![" + title + "](" + url + ")"