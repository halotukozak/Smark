package halotukozak.smark
package typography

import utils.nameOf

private inline def titleFrom[Title] = nameOf[Title].filterNot(_ == '"') match
  case "scala.Predef.String" => ""
  case t => t

inline def link[Title <: String](inline url: String): String = s"[${titleFrom[Title]}]($url)"
inline def link(inline url: String, inline title: String): String = s"[$title]($url)"

inline def image[title <: String](inline url: String): String = s"!${link[title](url)}"
inline def image(inline url: String, inline title: String): String = s"!${link(url, title)}"
