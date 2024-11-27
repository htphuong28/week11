package groceries
import util.Random

trait NPC (name: String, description: String):
  def greeting: String = "Good morning. I'm here to ask you a question. Do you want to answer it?"

  def userInteraction: Nothing

  override def toString = this.description


class HelperNPC(name: String, description: String) extends NPC(name, description):
  val num1 = Random(3)
  val num2 = Random(5)
  def userInteraction = 
    "Here's your question: " + num1 + "+" + num2 + "= ?"
    
  def checkAns(input: Int) =
    if input == num1 + num2 then 
      "Congrats"
         
    else 
      "Nuh uh"
