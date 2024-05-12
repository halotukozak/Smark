package halotukozak.smark
package typography.macros

import typography.HeadingLevel

inline def heading[N <: HeadingLevel : ValueOf](inline inner: String): String = "#" * valueOf[N] + inner