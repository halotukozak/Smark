package halotukozak.smark
package typography

inline def hr: String = "***"
inline def paragraph(inline inner: String*): String = "\n" + inner.mkString("\n\n")
inline def comment(inline inner: String*): String = s"<!-- $inner -->"
inline def html(inline args: String*): String = "\n" + args.mkString("\n") + "\n"
