package halotukozak.smark
package typography.macros

import typography.Emoji
import utils.nameOf

inline def emoji[E <: Emoji] = s":${nameOf[E]}:"

inline def emojiUnsafe(inline name: String): String = s":$name:"
