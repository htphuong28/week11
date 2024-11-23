package groceries

/** The class 'Item' represents items that the character will collect and bring home.
 *
 * @param name
 *
 */

class Item {val name: String, val description: String, val isConsumable: Boolean):
  def isGoodCondition = isConsumable
  override def toString = this.name

}
