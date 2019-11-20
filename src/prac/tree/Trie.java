package prac.tree;

public class Trie {

	public static final int ALPHABET_SIZE = 26;

	static TrieNode root;

	static class TrieNode {
		private TrieNode[] nodes = new TrieNode[ALPHABET_SIZE];
		private boolean isEndOfWord = false;

		TrieNode() {
			isEndOfWord = false;
			for (int i = 0; i < ALPHABET_SIZE; i++)
				nodes[i] = null;
		}
	}

	private void insert(String key) {

		int length = key.length();

		TrieNode node = root;
		for (int l = 0; l < length; l++) {

			int index = key.charAt(l) - 'a';
			if (node.nodes[index] == null)
				node.nodes[index] = new TrieNode();
			node = node.nodes[index];
		}
		node.isEndOfWord = true;
	}

	private boolean search(String key) {

		int length = key.length();
		TrieNode node = root;
		for (int l = 0; l < length; l++) {
			int index = key.charAt(l) - 'a';
			if (node.nodes[index] == null)
				return false;
			node = node.nodes[index];
		}
		return (null != node && node.isEndOfWord);
	}

	public static void main(String[] args) {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		Trie trie = new Trie();

		root = new TrieNode();
		// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			trie.insert(keys[i]);

		// Search for different keys
		if (trie.search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (trie.search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (trie.search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (trie.search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}
}
