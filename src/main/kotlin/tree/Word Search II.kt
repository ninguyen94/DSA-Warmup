package tree

/**
Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.
 */
fun main() {
    val trie = WordDictionary()
    trie.addWord("day")
    trie.addWord("bay")
    trie.addWord("may")
    println(trie.search("d..."))
}

class HashMapTrieNode() {
    val child = mutableMapOf<Char, HashMapTrieNode>()
    var isWord = false
    fun addWord(word: String) {
        var cur = this
        word.forEach { char ->
            cur = cur.child.getOrPut(char) { HashMapTrieNode() }
        }
        cur.isWord = true
    }
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val root = HashMapTrieNode()
    words.forEach { word ->
        root.addWord(word)
    }
    val res = hashSetOf<String>()
    val visited = hashSetOf<Pair<Int, Int>>()
    val row = board.size
    val col = board[0].size

    fun dfs(r: Int, c: Int, node: HashMapTrieNode, word: String) {
        if (r < 0 || c < 0 || r >= row || c >= col || (r to c) in visited || board[r][c] !in node.child) return
        visited.add(r to c)
        val nextNode = node.child[board[r][c]]!!
        val newWord = word + board[r][c]
        if (nextNode.isWord) {
            res.add(newWord)
        }

        dfs(r + 1, c, nextNode, newWord)
        dfs(r - 1, c, nextNode, newWord)
        dfs(r, c + 1, nextNode, newWord)
        dfs(r, c - 1, nextNode, newWord)

        visited.remove(r to c)
    }

    for (r in 0 until row) {
        for (c in 0 until col) {
            dfs(r, c, root, "")
        }
    }

    return res.toList()

}




