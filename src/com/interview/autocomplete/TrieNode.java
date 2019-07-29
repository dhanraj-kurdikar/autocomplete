package com.interview.autocomplete;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dkurdikar
 * @since 29/07/2019
 *
 * Defines Trie Data Structure
 */
public class TrieNode {

  char data;
  List<TrieNode> children;
  TrieNode parent;
  boolean endOfWord;

  public TrieNode(char ch) {
    data = ch;
    children = new ArrayList<>();
    endOfWord = false;
  }

  public TrieNode getChild(char c) {
    if (children != null) {
      for (TrieNode eachChild : children) {
        if (eachChild.data == c) {
          return eachChild;
        }
      }
    }
    return null;
  }

  /**
   * This method returns list of Strings associated with this TrieNode. It uses recursive approach
   * and does the following :- if this Trie Node is end of word (base condition), then add its
   * parent & word to list else, for every children of this Trie Node, perform pre-order traversal
   * until end of word is reached
   *
   * @return list of Strings associated with this TrieNode
   */
  protected List getWords() {
    List list = new ArrayList();
    if (endOfWord) {
      list.add(toString());
    }

    if (children != null) {
      for (int i = 0; i < children.size(); i++) {
        if (children.get(i) != null) {
          list.addAll(children.get(i).getWords());
        }
      }
    }
    return list;
  }

  public String toString() {
    if (parent == null) {
      return "";
    } else {
      return parent.toString() + new String(new char[] {data});
    }
  }

}
