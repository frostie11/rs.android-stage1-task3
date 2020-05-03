package subtask3

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var intList = itemsFromArray.filterIsInstance<Int>()
        if (intList.isNotEmpty()) {
            intList = intList.sortedWith(Comparator.comparingInt(Math::abs)).reversed()
            var result = 1

            if (numberOfItems < intList.size) {
                val positiveList = (intList.filter { e: Int -> e >= 0 }).toMutableList()
                var lastNegativeIndex = -1

                for (i in 0 until numberOfItems) {
                    val intToMultiply = intList[i]
                    result *= intToMultiply

                    positiveList.remove(intToMultiply)
                    if (intToMultiply < 0) {
                        lastNegativeIndex = i
                    }
                }

                if ((result < 0) && (lastNegativeIndex >= 0) && (positiveList.isNotEmpty())) {
                    result = result / intList[lastNegativeIndex] * positiveList.first()
                }
                return result
            } else {
                for (item in intList) {
                    result *= item
                }
                return result
            }
        }
        return 0
    }
}