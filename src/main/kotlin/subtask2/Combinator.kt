package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val m = array[0]
        val n = array[1]

        for (x in 0..(n / 2)) {
            if (factorial(n) == m * factorial(x) * factorial(n - x))
                return x
        }
        return null
    }

    private fun factorial(j: Int): Int {
        return when {
            j < 1 -> -1
            j == 1 -> 1
            else -> j * factorial(j - 1)
        }
    }
}
