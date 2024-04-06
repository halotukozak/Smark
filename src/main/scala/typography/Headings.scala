package halotukozak.smark
package typography

import typography.macros.heading


private[typography] type HeadingLevel = 1 | 2 | 3 | 4 | 5 | 6

def headingUnsafe(n: Int, inner: String): String = n match
  case 1 => heading[1](inner)
  case 2 => heading[2](inner)
  case 3 => heading[3](inner)
  case 4 => heading[4](inner)
  case 5 => heading[5](inner)
  case 6 => heading[6](inner)
  case _ => throw IllegalArgumentException(s"Invalid heading level: $n")
