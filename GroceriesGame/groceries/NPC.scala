package groceries
import util.Random

class NPC (name: String, description: String):
  private var currentlyInteracting = 0
  
  def isInteracting = currentlyInteracting
  
  def greeting: String = 
    currentlyInteracting +=1
    "Good morning. I'm here to ask you a question. Do you want to answer it? (Yes or No)"

  override def toString = this.description

  val num1 = Random.nextInt(300)
  val num2 = Random.nextInt(500)
  
  def userInteraction: String = 
    currentlyInteracting +=1
    "Here's your question: " + num1 + "+" + num2 + "= ?"
    
  var answerRight = false
  def checkAns(input: Int) =
    currentlyInteracting +=1
    if input == num1 + num2 then 
      answerRight = true
      "Congrats"
    else 
      "Nuh uh"
      

