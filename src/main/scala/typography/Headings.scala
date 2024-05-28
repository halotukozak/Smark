package halotukozak.smark
package typography


private[typography] type HeadingLevel = 1 | 2 | 3 | 4 | 5 | 6

inline def heading[N <: HeadingLevel : ValueOf](inline inner: String): String = "#" * valueOf[N] + inner
