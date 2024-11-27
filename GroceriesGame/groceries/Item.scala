package groceries

/** The class 'Item' represents items that the character will collect and bring home.
 * @param name            item's name
 * @param description     describe item
 * @param isQuality       determines whether an item's condition is acceptable or not
 * @param isOnSale        determines whether an item is on sale or not
 */

class Item(val name: String,
           val description: String,
           val isQuality: Boolean,
           val isOnSale: Boolean,
           val price: Int):
  override def toString = this.name
end Item

