package groceries

import scala.collection.mutable.Map

/** A `Player` object represents a player character controlled by the real-life user
  * of the program.
  *
  * A player object’s state is mutable: the player’s location and possessions can change,
  * for instance.
  *
  * @param startingArea  the player’s initial location */

class Player(startingArea: Area):

  private var currentLocation = startingArea        // gatherer: changes in relation to the previous location
  private var quitCommandGiven = false              // one-way flag
  private val storedItems = Map[String, Item]()     // where the player's items are stored
  private var wallet: Int = 0                       // the amounf of money the player has

  /** Determines if the player has indicated a desire to quit the game. */
  def hasQuit = this.quitCommandGiven

  /** Returns the player’s current location. */
  def location = this.currentLocation

  def buy(itemName: String): String =
    currentLocation.onSale.get(itemName) match
      case Some(item) => useMoney(item.itemPrice) match
        case "You don't have enough money to buy this." => "Purchase failed"
        case other => 
          storedItems += item.name -> item
          s"You purchased the ${itemName}."
      case None => s"There is no ${itemName} available to buy."
      

  def callMom(itemName: String): String = "Bring home    for your sister's birthday party!"
  
  /*def interact(npc: String): String */

  def drop(itemName: String): String =
    storedItems.remove(itemName) match
      case None => "You don't have that!"
      case Some(item) =>
        currentLocation.addItem(item)
        s"You drop the ${itemName}."

  def examine(itemName: String): String =
    storedItems.get(itemName) match
      case None => "If you want to examine something, you need to pick it up first."
      case Some(item) => s"You look closely at the ${itemName}.\n${item.description}"

  def get(itemName: String): String =
    currentLocation.removeItem(itemName) match
      case None => s"There is no ${itemName} here to pick up."
      case Some(item) =>
        storedItems += item.name -> item
        s"You pick up the ${itemName}."

  def has(itemName: String): Boolean = storedItems.contains(itemName)

  def inventory: String =
    if storedItems.isEmpty then "You are empty-handed."
    else "You are carrying:\n" + storedItems.map( (name, item) => name ).mkString("\n")

  /** Attempts to move the player in the given direction. This is successful if there
    * is an exit from the player’s current location towards the direction name. Returns
    * a description of the result: "You go DIRECTION." or "You can't go DIRECTION." */
  def go(direction: String) =
    val destination = this.location.neighbor(direction)
    this.currentLocation = destination.getOrElse(this.currentLocation)
    if destination.isDefined then s"You go $direction." else s"You can't go $direction."

  /** Signals that the player wants to quit the game. Returns a description of what happened within
    * the game as a result (which is the empty string, in this case). */
  def quit() =
    this.quitCommandGiven = true
    ""

  def setMoney(amount: Int) =
    this.wallet = amount
    s"Your balance: ${this.wallet}"

  def addMoney(amount: Int) =
    this.wallet += amount
    s"You received: ${amount}\nYour balance: ${this.wallet}"

  def useMoney(amount: Int) = (this.wallet - amount) match
    case remaining if remaining < 0 => "You don't have enough money to buy this."
    case remaining if remaining >= 0 =>
      this.wallet -= amount
      s"You spent: ${amount}\nYour balance: ${this.wallet}"

  /** Returns a brief description of the player’s state, for debugging purposes. */
  override def toString = "Now at: " + this.location.name

end Player

