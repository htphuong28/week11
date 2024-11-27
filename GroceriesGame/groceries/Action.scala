package groceries

/** The class `Action` represents actions that a player may take in a text adventure game.
  * `Action` objects are constructed on the basis of textual commands and are, in effect,
  * parsers for such commands. An action object is immutable after creation.
  * @param input  a textual in-game command such as “go east” or “rest” */
class Action(input: String):

  private val commandText = input.trim.toLowerCase
  private val verb        = commandText.takeWhile( _ != ' ' )
  private val modifiers   = commandText.drop(verb.length).trim

  def execute(actor: Player): Option[String] =
    this.verb match
      case "go"                     => Some(actor.go(this.modifiers))
      case "call mom"               => Some(actor.callMom)
      //case "interact with"          => Some(actor.interact(this.modifiers))
      case "quit"                   => Some(actor.quit())
      case "inventory"              => Some(actor.inventory)
      case "examine"                => Some(actor.examine(this.modifiers))
      case "get"                    => Some(actor.get(this.modifiers))
      case "drop"                   => Some(actor.drop(this.modifiers))
      case "buy"                    => Some(actor.buy(this.modifiers))
      case "interact"               => Some(actor.interact)
      case "answer"                 => Some(actor.getAnswer(this.modifiers))
      case other                    => None

  
  /** Returns a textual description of the action object, for debugging purposes. */
  override def toString = s"$verb (modifiers: $modifiers)"

end Action