package groceries
import util.Random

class NPC(name: String, description: String):
  def greeting: String = "Good morning, I have a question for you. Do you want to take it?"

  def userInteraction = "What is"

  override def toString: String = this.description

class Helper