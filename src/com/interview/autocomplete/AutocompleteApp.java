package com.interview.autocomplete;

import java.util.List;

/**
 * @author dkurdikar
 * @since 29/07/2019
 *
 * An Autocomplete App that returns suggestions for a given word
 */
public class AutocompleteApp {

  public static void main(String[] args) {
    TrieOperation trieOperation = new TrieOperation();
    trieOperation.insert("ship");
    trieOperation.insert("shipment");
    trieOperation.insert("shipping");
    trieOperation.insert("container");
    trieOperation.insert("contaminate");
    trieOperation.insert("control");
    trieOperation.insert("cat");
    trieOperation.insert("category");
    trieOperation.insert("catch");

    List a= trieOperation.autocomplete("shi");
    // Expected output - ship, shipment, shipping
    for (int i = 0; i < a.size(); i++) {
      System.out.println(a.get(i));
    }
  }

}
