import com.sun.tools.javac.jvm.ByteCodes.swap as swap1

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   Old Gold
 * Project Author: Jayden Neale
 * GitHub Repo:    https://github.com/waimea-jmneale/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * Old Gold is a two-player game, played on a one-dimensional grid with coins, where the aim is to win by being the player who **removes the gold coin**.
 * =====================================================================
 */
const val EMPTY = " "     // Represents an empty square
const val NUMSQUARE = 20 // Number of squares

fun main() {
    println("-------------------------------------------------------------")
    println("Welcome to the Old Gold Game!")
    println("-------------------------------------------------------------")
    println("Old Gold is a two-player game, played on a one-dimensional grid with coins,")
    println("where the aim is to win by being the player who gets the gold coin in the first square.")
    println("-------------------------------------------------------------")
    println("RULES:")
    println("You cannot move the coins right, only left!")
    println("You cannot jump other coins!")
    println("You can move as far left as you can as long as you don't jump!")
    println("You win if you get the gold coin into the first square!")
    println("You can remove the normal coins if they are in the first box by inputting 0 when choosing your coin!")
    println("-------------------------------------------------------------")
    println()

    // Get player 1's and 2's names
    println("Player 1, please enter your name:")
    val player1 = readln()
    println("Player 1 is $player1")
    println()

    println("Player 2, please enter your name:")
    val player2 = readln()
    println("Player 2 is $player2")
    println()

    // Coins in the game
    val coins = setupBoard()
    coins.add("C1")
    coins.add("C2")
    coins.add("C3")
    coins.add("C4")
    coins.add("C5")
    coins.add("G")

    // Shuffle coins in the game board
    showCoins(coins)
    coins.shuffle()

    // Prints the game box
    printGameBox(coins)
    println()

    var currentPlayer = player1
    while (true) {
        println("$currentPlayer's turn. Please enter the box number with the coin you want to move in it: (1-${coins.size}) or enter '0' to remove the coin in box 1:")
        val coinInput = readln()

        // Check if the input is "0" to remove the coin in box 1
        if (coinInput == "0") {
            if (coins[0] != EMPTY) {
                println("Removing ${coins[0]} from box 1.")
                coins[0] = EMPTY
                printGameBox(coins)
                println()
            } else {
                println("There is no coin in box 1 to remove.")
            }
        } else {
            val coinIndex = coinInput.toIntOrNull()?.minus(1) ?: continue

            if (coinIndex < 0 || coinIndex >= coins.size || coins[coinIndex] == EMPTY) {
                println("There is no coin in this box. Please choose another.")
                continue
            }

            println("Please enter the box you want to move this coin to: (1-${coins.size}):")
            val newPosition = readln().toIntOrNull()?.minus(1) ?: continue

            if (newPosition < 0 || newPosition >= coins.size || coins[newPosition] != EMPTY) {
                println("Cannot move here. The square you chose is either out of bounds or not empty. Please try again.")
                continue
            }

            // Move the coin
            coins[newPosition] = coins[coinIndex]
            coins[coinIndex] = EMPTY

            printGameBox(coins)
            println()
        }

        // Check for win condition (if the gold coin is removed at sq1)
        if (coins[0] == "G") {
            println("$currentPlayer has removed the gold coin! $currentPlayer wins!")
            break
        }

        // Switch players
        currentPlayer = if (currentPlayer == player1) player2 else player1
    }
}


fun setupBoard(): MutableList<String> {
    val squareList = mutableListOf<String>()
    for (i in 1..NUMSQUARE - 6) squareList.add(EMPTY)
    return squareList
}

// Show the players the coins they're playing with
fun showCoins(coinList: List<String>) {
    println("List of the coins | 5 Normal and 1 gold")
    println("------------------------------------")
}

// Add coins in boxes
fun listAllCoins(coinList: List<String>) {
    for (i in 0 until coinList.size) {
        if (coinList[i] != EMPTY) {
            println(coinList[i].padEnd(0))
        }
    }
}

fun printGameBox(coinList: List<String>) {
    println("-----".repeat(20) + "+")
    for (i in 0 until coinList.size) {
        print("| ${i + 1} ".padEnd(5))
    }
    println("|")
    println("+----".repeat(20) + "+")
    for (i in 0 until coinList.size) {
        print("| ${coinList[i]} ".padEnd(5))
    }
    println("|")
    println("-----".repeat(20) + "+")
}


//const val EMPTY = " "     // Represents an empty square
//const val NUMSQUARE = 20 // Number of squares
//
//fun main() {
//
//
//    println("-------------------------------------------------------------")
//    println("Welcome to the Old Gold Game!")
//    println("-------------------------------------------------------------")
//    println("Old Gold is a two-player game, played on a one-dimensional grid with coins,")
//    println("where the aim is to win by being the player who removes the gold coin.")
//    println("-------------------------------------------------------------")
//    println()
//
//    println("Player 1, please enter your name:")
//    val player1 = readln()
//    println("Player 1 is $player1")
//    println()
//
//    println("Player 2, please enter your name:")
//    val player2 = readln()
//    println("Player 2 is $player2")
//    println()
//
//    //-------------------------------------------------
//
//    val coins = setupBoard()
//
//    coins.add("C1")
//    coins.add("C2")
//    coins.add("C3")
//    coins.add("C4")
//    coins.add("C5")
//    coins.add("G")
//
//    showCoins(coins)
//
//    //----------------------------------------
//
//    listAllCoins(coins)
//    coins.shuffle()
//
//    //----------------------------------------
//
//    printGameBox(coins)
//    println()
//
//    //----------------------------------------
//
//
//
//    //----------------------------------------
//
//
//}
////
//fun setupBoard(): MutableList<String> {
//    val squareList = mutableListOf<String>()
//    for (i in 1..NUMSQUARE - 6) squareList.add(EMPTY)
//    return squareList
//}
////Show the players the coins they're playing with
//fun showCoins(coinList: List<String>) {
//    println("List of the coins | 5 Normal and 1 gold")
//    println("------------------------------------")
//}
//
////add coins in boxes
//fun listAllCoins(coinList: List<String>) {
//    for (i in 0..coinList.size -1 ) {
//        if (coinList[i] != EMPTY) {
//            println(coinList[i].padEnd(0))
//        }
//    }
//}
//
//
//fun printGameBox(coinList: List<String>) {
//
//    println("-----".repeat(20) + "+")
//    for (i in 0..coinList.size - 1) {
//        print("| ${i + 1} ".padEnd(5))
//    }
//    println("|")
//    println("+----".repeat(20) + "+")
//    for (i in 0..coinList.size - 1) {
//        print("| ${coinList[i]} ".padEnd(5))
//    }
//    println("|")
//    println("-----".repeat(20) + "+")
//
//}




//removing last coin
//fun deleteLastMonkey(monkeyList: MutableList<String>) {
//    // Remove the last one from the list
//    monkeyList.removeAt(4)
//    // Show some feedback
//    println("Removing monkey: $monkeyList ")
//}

//part 2
//fun clearCage(cageList: MutableList<String>, cageNum: Int) {
//    println("--- Clearing cage $cageNum")
//
//    cageList[cageNum - 1] = EMPTY
//}











