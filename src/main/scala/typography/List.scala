package halotukozak.smark
package typography

type Asterisk
type Plus
type Hyphen
type Unordered = Asterisk | Plus | Hyphen
type Ordered

private[smark] type ListStyle = Unordered | Ordered
