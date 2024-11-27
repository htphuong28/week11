package groceries

class Adventure:
  
  /* the name of the game */
  val title = "Grocery Spree"
  
  private val house       = Area("House", "Home sweet home. Not if you don't do what your moms says though;\nshe is pretty angry right now and will probably ground you!")
  private val sideStreet  = Area("Side Street", "A small, bland street leading up to the local park.")
  private val park        = Area("Park", "If you can call a large patch of grass with a treehouse, a seesaw, and a slide a park,\nthen it's a park.")
  private val treehouse   = Area("Treehouse", "A cramped place to rest in or to hide some stuffs.")
  private val supermarket = Area("Supermarket", "You can find most things needed in here, but they aren't really cheap.")
  private val parkingLot  = Area("Parking Lot", "Here resides cars and troubled individuals. Mom did tell you to avoid talking to strangers,\nand here is a good place to apply that.")
  private val mainStreet  = Area("Main Street", "There are a lot of cars out here, so be careful crossing the road.")
  private val oldPort     = Area("Old Port", "Albeit abandoned, it's still a good place to go fishing.\nSometimes, vendors propped up here for some reasons.")
  private val beach       = Area("Beach", "Relax, find seashells, make sandcastles, or swim: It's chill out here.")

  val player = Player(house)
  
  var turnCount = 0
  
  val timeLimit = 40
  
  def isComplete = this.player.location == house && this.player.inventory.forall(player.haveToBuyList.contains)

end Adventure