package groceries

/** The class 'Item' represents items that the character will collect and bring home.
 * @param name            item's name
 * @param description     describe item
 * @param isQuality       determines whether an item's condition is acceptable or not
 * @param isOnSale        determines whether an item is on sale or not
 */

class Item (val name: String, val description: String, private val isQuality: Boolean, private var isOnSale: Boolean, private val price: Int):

  def isGoodCondition = isQuality
  
  def itemPrice = this.price
  
  def isBuyable = isOnSale

  override def toString = this.name

end Item

