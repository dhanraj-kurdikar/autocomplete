package com.interview.autocomplete;


import java.util.ArrayList;
import java.util.List;

/**
 * @author dkurdikar
 * @since 29/07/2019
 *
 * This utility class defines various operations on Trie
 */
public class TrieOperation {

  private TrieNode root;

  /**
   * Constructor creates Trie root node & assigns empty character to it as data
   */
  public TrieOperation() {
    root = new TrieNode(' ');
  }

  /**
   * This method inserts data to Trie Data structure. If the given word is already present, it
   * simply returns
   *
   * @param word - Word to be inserted into this Trie
   */
  public void insert(String word) {
    if (find(word) == true) {
      return;
    }

    TrieNode current = root;
    TrieNode pre;
    for (char ch : word.toCharArray()) {
      pre = current;
      TrieNode child = current.getChild(ch);
      if (child != null) {
        current = child;
        child.parent = pre;
      } else {
        current.children.add(new TrieNode(ch));
        current = current.getChild(ch);
        current.parent = pre;
      }
    }
    //mark the current nodes endOfWord as true
    current.endOfWord = true;
  }

  /**
   * This method performs a search to check if word is present in Trie
   *
   * @param word - Word to be searched into this Trie
   * @return true if found, else false
   */
  public boolean find(String word) {
    TrieNode current = root;
    for (char ch : word.toCharArray()) {
      if (current.getChild(ch) == null) {
        return false;
      } else {
        current = current.getChild(ch);
      }
    }
    if (current.endOfWord == true) {
      return true;
    }
    return false;
  }

  /**
   * This method returns list of autocomplete suggestions for a given prefix
   *
   * @param prefix prefix of the word to be searched
   * @return all the nodes associated with last word of prefix
   *
   * ex:- input prefix -> Cat | output [Catch, Categories]
   */
  public List autocomplete(String prefix) {
    TrieNode lastNode = root;
    for (int i = 0; i < prefix.length(); i++) {
      lastNode = lastNode.getChild(prefix.charAt(i));
      if (lastNode == null) {
        return new ArrayList();
      }
    }

    return lastNode.getWords();
  }
}
