package subtask1

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) return null
        var resultString = ""
        for ((index, degree) in numbers.withIndex()) {
            if (degree != 0) {
                resultString += degree.toString() + "x^" + (numbers.size - index - 1)
                if (index != numbers.lastIndex)
                    resultString += " + "
            }

        }
        resultString = resultString.replace("1x", "x")
        resultString = resultString.replace("x^1", "x")
        resultString = resultString.replace("x^0", "")
        resultString = resultString.replace("+ -", "- ")
        return resultString
    }
}
