package com.tab.marvelapp.utils;

import com.tab.marvelapp.model.Item;
import com.tab.marvelapp.model.Result;

public class FormatUtils {

    public static String formatAuthors(Result result) {
        Item[] items = result.getCreators().getItems();

        if (items.length == 0) {
            return "N/A";
        }

        StringBuilder authors = new StringBuilder(items[0].getName());
        for (int i = 1; i < items.length; i++) {
            authors.append("\n");
            authors.append(items[i].getName());
        }

        return authors.toString();
    }
}
