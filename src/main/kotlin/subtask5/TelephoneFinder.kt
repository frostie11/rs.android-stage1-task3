package subtask5

class TelephoneFinder {

    var neighborsMap: Map<Char, CharArray> = mapOf(
        '0' to charArrayOf('8'),
        '1' to charArrayOf('2', '4'),
        '2' to charArrayOf('1', '3', '5'),
        '3' to charArrayOf('2', '6'),
        '4' to charArrayOf('1', '5', '7'),
        '5' to charArrayOf('2', '4', '6', '8'),
        '6' to charArrayOf('3', '5', '9'),
        '7' to charArrayOf('4', '8'),
        '8' to charArrayOf('0', '5', '7', '9'),
        '9' to charArrayOf('6', '8')
    )

    @UseExperimental(ExperimentalStdlibApi::class)
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.startsWith("-")) return null

        val resultList = mutableListOf<String>()

        for (index in number.indices) {
            val currentDigit = number.toCharArray()[index]
            val digitNeighbors = neighborsMap[currentDigit]
            digitNeighbors!!.forEach { neighbor ->
                val numberCharArray = number.toCharArray()
                numberCharArray[index] = neighbor
                resultList.add(numberCharArray.concatToString())
            }
        }
        return resultList.toTypedArray()
    }
}
