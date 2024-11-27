package groceries

import scala.io.StdIn.readLine

object TextUI extends App:
  private val game = Adventure()
  private val player = game.player
  this.run()
  
  private def run() =
    println(this.game.welcomMessage)
    while !this.game.isOver do
      this.playTurn()
      
  private def playTurn() =
    println()
    val command = readLine("Command: ")
    val turnReport = this.game.playTurn(command)
    if turnReport.nonEmpty then
      println(turnReport)