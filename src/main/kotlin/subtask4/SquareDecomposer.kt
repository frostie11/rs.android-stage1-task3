package subtask4

class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val numberLong = number.toLong()
        val resultList = decomposer(numberLong, numberLong * numberLong)

        return if (resultList != null) {
            resultList.removeAt(resultList.size - 1)
            resultList.toTypedArray()
        } else {
            null
        }
    }

    private fun decomposer(n: Long, remain: Long): MutableList<Int>? {
        if (remain == 0L) return mutableListOf(n.toInt())

        for (i in (n - 1) downTo 1) {
            val diff = remain - i * i
            if (diff >= 0) {
                val result = decomposer(i, diff)
                if (result != null) {
                    result.add(n.toInt())
                    return result
                }
            }
        }
        return null
    }
}
