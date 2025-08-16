package tree

/**
Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.
 */
fun main() {
    val trie = Trie()
    trie.insert("apple")
    trie.insert("app")
    val res = trie.search("app")
    println(res)
}

class Trie() {
    val root = TrieNode()

    fun insert(word: String) {
        if (word.isBlank()) return
        var currentNode = root
        for (i in 0 until word.length) {
            val idx = word[i] - 'a'
            if (currentNode.characterList[idx] == null) {
                currentNode.characterList[idx] = TrieNode()
            }
            currentNode = currentNode.characterList[idx]!!
            if (i == word.lastIndex) {
                currentNode.isEndWord = true
            }
        }
    }

    fun search(word: String): Boolean {
        if (word.isBlank()) return false
        var currentNode = root
        for (i in 0 until word.length) {
            val idx = word[i] - 'a'
            currentNode = currentNode.characterList[idx] ?: return false
        }
        return currentNode.isEndWord
    }

    fun startsWith(prefix: String): Boolean {
        if (prefix.isBlank()) return false
        var currentNode = root
        for (i in 0 until prefix.length) {
            val idx = prefix[i] - 'a'
            currentNode = currentNode.characterList[idx] ?: return false
        }
        return true
    }
}

class TrieNode() {
    val characterList = Array<TrieNode?>(26) { null }
    var isEndWord = false
}


