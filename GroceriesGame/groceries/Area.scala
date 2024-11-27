package groceries

import scala.collection.mutable.Map

class Area(var name: String, var description: String):

  private val neighbors = Map[String, Area]()
  private val items = Map[String, Item]()
  
  private def pickableItems = items.filter( (name, item) => !item.isBuyable )
  private def buyableItems = items.filter( (name, item) => item.isBuyable )

  def onSale = buyableItems

  def addItem(item: Item) = this.items += item.name -> item

  def removeItem(itemName: String) = this.items.remove(itemName)

  def neighbor(direction: String) = this.neighbors.get(direction)

  def setNeighbor(direction: String, neighbor: Area) =
    this.neighbors += direction -> neighbor

  def setNeighbors(exits: Vector[(String, Area)]) =
    this.neighbors ++= exits

  def fullDescription: String =
    //val pickUpItemList = if items.nonEmpty then "\nYou see here: " + this.items.keys.mkString(" ") else ""
    //val forSaleItemList = if items.nonEmpty then "\nThe vendors here sell: " + this.items.keys.mkString(" ") else ""
    //val npcList
    val exitList = "\n\nExits available: " + this.neighbors.keys.mkString(" ")
    this.description + /* pickUpItemList + forSaleItemList + npcList + */ exitList

  /** Returns a single-line description of the area for debugging purposes. */
  override def toString =
    this.name + ": " + this.description.replaceAll("\n", " ").take(150)

end Area
