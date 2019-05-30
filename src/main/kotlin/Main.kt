fun main(args:Array<String>)
{
    println("Choose 1 for Arabic to Roman & 2 for Roman to Arabic")
    val userInput = Integer.valueOf(readLine())
    if(userInput == 1)
    {
        getRoman()
    }
    else if (userInput == 2)
    {
        getArabic()
    }
    else{
        println("Make a choice between 1 or 2!")
    }

}


fun getRoman() {
    println("Enter any arabic number between 1 to 100: ")
    val arabicInput = Integer.valueOf(readLine())
    var romanOutput = ""

    val arabicToRoman = mutableMapOf<Int, String>(
        Pair(1, "I"),
        Pair(4, "IV"),
        Pair(5, "V"),
        Pair(9, "IX"),
        Pair(10, "X"),
        Pair(40, "XL"),
        Pair(50, "L"),
        Pair(90, "XC"),
        Pair(100, "C")

    )

    val arrayRoman = arrayOf(100, 90, 50, 40, 10, 9, 5, 4, 1)
    var startCount = 0

    if (arabicInput > 100) { romanOutput = "Number must be between 1 to 100 " }
    else {
        if (arabicInput > 90) { startCount = 1 }
        else if (arabicInput > 50) { startCount = 2 }
        else if (arabicInput > 40) { startCount = 3 }
        else if (arabicInput > 10) { startCount = 4 }
        else if (arabicInput > 5) { startCount = 5 }
        else if (arabicInput > 4) { startCount = 6 }
        else if (arabicInput > 1) { startCount = 7 }

        var num = arabicInput
        for (i in startCount..arrayRoman.size - 1) {
            var count = num / arrayRoman[i]
            num = num % arrayRoman[i]
            while (count > 0) {
                romanOutput += arabicToRoman[arrayRoman[i]]
                count--
            }
        }

    }
    println(romanOutput)
}

fun getArabic(){
    println("Enter any roman number between I to C: ")
    val romanInput = readLine()!!.toUpperCase()
    var arabicOutput = 0

    val romanToArabic = mutableMapOf<String,Int>(
        Pair("I",1),
        Pair("V",5),
        Pair("X",10),
        Pair("L",50),
        Pair("C",100)
    )

    var prevNum = 0
    val romanInputReversed = romanInput.reversed()
    for (i in 0..romanInputReversed.length -1)
    {
//        println(i)
       val arabicNum:Int = romanToArabic[romanInputReversed[i].toString()]!!
        if(arabicNum < prevNum)
        {
            arabicOutput -= arabicNum
        }
        else{
            arabicOutput += arabicNum
        }
        prevNum = arabicNum
    }

    println(arabicOutput)

}