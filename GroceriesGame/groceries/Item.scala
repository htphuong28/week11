package groceries

/** The class 'Item' represents items that the character will collect and bring home.
 *
 * @param name...........item's name
 * @param description....describe item
 * @param isConsumable...determines whether item is consumable or not
 *
 */

class Item (val name: String, val description: String, val isConsumable: Boolean):
  def isGoodCondition = isConsumable
  override def toString = this.name

}
