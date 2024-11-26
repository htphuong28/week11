package groceries

/** The class 'Item' represents items that the character will collect and bring home.
 *
 * @param name...........item's name
 * @param description....describe item
 * @param isConsumable...determines whether an item is consumable or not
 * @param isOnSale       determines whether an item is on sale or not
 *
 */

class Item (val name: String, val description: String, val isConsumable: Boolean, private var isOnSale: Boolean):

  def isGoodCondition = isConsumable
  
  def isBuyable = isOnSale



  override def toString = this.name


