package halotukozak.smark
package typography

import typography.macros.quote

inline def note(inline inner: String*): String = quote[Note](inner *)
inline def tip(inline inner: String*): String = quote[Tip](inner *)
inline def important(inline inner: String*): String = quote[Important](inner *)
inline def warning(inline inner: String*): String = quote[Warning](inner *)
inline def caution(inline inner: String*): String = quote[Caution](inner *)
