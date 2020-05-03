package subtask6

import java.util.*


class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
        var resultStr: String = ""
        allPossibleFBT(count).stream().forEach { node ->
            var str = "[0,${node}]"

            str = str.replace(",]", "]")
            while (str.endsWith(",null,null]")) {
                str = str.replace(",null,null]", "]")
            }
            resultStr += str
        }
        return "[$resultStr]"
    }

    private var memo = hashMapOf<Int, List<TreeNode>>()

    private fun allPossibleFBT(N: Int): List<TreeNode> {
        if (!memo.containsKey(N)) {
            val ans = LinkedList<TreeNode>()
            if (N == 1) {
                ans.add(TreeNode(0))
            } else if (N % 2 == 1) {
                for (x in 0 until N) {
                    val y = N - 1 - x
                    for (left in allPossibleFBT(x))
                        for (right in allPossibleFBT(y)) {
                            val bns = TreeNode(0)
                            bns.left = left
                            bns.right = right
                            ans.add(bns)
                        }
                }
            }
            memo[N] = ans
        }
        return memo[N]!!
    }

    class TreeNode(var id: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null

        override fun toString(): String {
            return if (left != null && right != null) {
                "${left!!.id},${right!!.id}," + left.toString() + right.toString()
            } else {
                "${left.toString()},${right.toString()},"
            }
        }

    }
}