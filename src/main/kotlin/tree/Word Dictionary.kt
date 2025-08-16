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

class WordDictionary() {
    val root = TrieNode()

    fun addWord(word: String) {
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
        return searchWithNode(word, root)
    }

    fun searchWithNode(word: String, node: TrieNode): Boolean {
        if (word.isBlank()) return node.isEndWord
        var currentNode = node
        for (i in 0 until word.length) {
            val char = word[i]
            if (char == '.') {
                val restOfWord = word.substring(i + 1)
                val array = currentNode.characterList
                for (i in 0 until 26) {
                    if (array[i] == null) continue
                    if (searchWithNode(restOfWord, array[i]!!)) {
                        return true
                    }
                }
                return false
            }
            val idx = char - 'a'
            currentNode = currentNode.characterList[idx] ?: return false
        }
        return currentNode.isEndWord
    }

}



