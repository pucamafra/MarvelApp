package com.tab.marvelapp;

import com.google.gson.Gson;
import com.tab.marvelapp.model.ComicsResponse;

public class MockUtils {

    private static ComicsResponse comicsResponse;

    public static ComicsResponse getMock() {
        String json = "{\n" +
                "  \"code\": 200,\n" +
                "  \"status\": \"Ok\",\n" +
                "  \"copyright\": \"© 2017 MARVEL\",\n" +
                "  \"attributionText\": \"Data provided by Marvel. © 2017 MARVEL\",\n" +
                "  \"attributionHTML\": \"<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2017 MARVEL</a>\",\n" +
                "  \"etag\": \"658fe112e5bdca298e2d4b41f42d458b5081b88d\",\n" +
                "  \"data\": {\n" +
                "    \"offset\": 0,\n" +
                "    \"limit\": 2,\n" +
                "    \"total\": 40028,\n" +
                "    \"count\": 2,\n" +
                "    \"results\": [\n" +
                "      {\n" +
                "        \"id\": 22582,\n" +
                "        \"digitalId\": 0,\n" +
                "        \"title\": \"Civil War (Hardcover)\",\n" +
                "        \"issueNumber\": 0,\n" +
                "        \"variantDescription\": \"\",\n" +
                "        \"description\": \"The landscape of the Marvel Universe is changing, and it's time to choose: Whose side are you on? A conflict has been brewing from more than a year, threatening to pit friend against friend, brother against brother - and all it will take is a single misstep to cost thousands their lives and ignite the fuse! As the war claims its first victims, no one is safe as teams, friendships and families begin to fall apart. The crossover that rewrites the rules, Civil War stars Spider-Man, the New Avengers, the Fantastic Four, the X-Men and the entirety of the Marvel pantheon! Collecting CIVIL WAR #1-7, MARVEL SPOTLIGHT: CIVIL WAR and CIVIL WAR SCRIPT BOOK.\\r<br>Rated T+ ...$39.99\\r<br>ISBN: 978-0-7851-2178-7\\r<br>Trim size: oversized\\r<br>\",\n" +
                "        \"modified\": \"2013-03-18T15:33:12-0400\",\n" +
                "        \"isbn\": \"978-0-7851-2178-7\",\n" +
                "        \"upc\": \"5960612178-00111\",\n" +
                "        \"diamondCode\": \"AUG082435\",\n" +
                "        \"ean\": \"9780785 121787 53999\",\n" +
                "        \"issn\": \"\",\n" +
                "        \"format\": \"Hardcover\",\n" +
                "        \"pageCount\": 512,\n" +
                "        \"textObjects\": [\n" +
                "          {\n" +
                "            \"type\": \"issue_solicit_text\",\n" +
                "            \"language\": \"en-us\",\n" +
                "            \"text\": \"The landscape of the Marvel Universe is changing, and it's time to choose: Whose side are you on? A conflict has been brewing from more than a year, threatening to pit friend against friend, brother against brother - and all it will take is a single misstep to cost thousands their lives and ignite the fuse! As the war claims its first victims, no one is safe as teams, friendships and families begin to fall apart. The crossover that rewrites the rules, Civil War stars Spider-Man, the New Avengers, the Fantastic Four, the X-Men and the entirety of the Marvel pantheon! Collecting CIVIL WAR #1-7, MARVEL SPOTLIGHT: CIVIL WAR and CIVIL WAR SCRIPT BOOK.\\r<br>Rated T+ ...$39.99\\r<br>ISBN: 978-0-7851-2178-7\\r<br>Trim size: oversized\\r<br>\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/22582\",\n" +
                "        \"urls\": [\n" +
                "          {\n" +
                "            \"type\": \"detail\",\n" +
                "            \"url\": \"http://marvel.com/comics/collection/22582/civil_war_hardcover?utm_campaign=apiRef&utm_source=c9a0ab6a03e62fe32e7bbede9aea94bf\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"series\": {\n" +
                "          \"resourceURI\": \"http://gateway.marvel.com/v1/public/series/6208\",\n" +
                "          \"name\": \"Civil War (2008 - Present)\"\n" +
                "        },\n" +
                "        \"variants\": [],\n" +
                "        \"collections\": [],\n" +
                "        \"collectedIssues\": [],\n" +
                "        \"dates\": [\n" +
                "          {\n" +
                "            \"type\": \"onsaleDate\",\n" +
                "            \"date\": \"2029-12-31T00:00:00-0500\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"focDate\",\n" +
                "            \"date\": \"2008-10-09T00:00:00-0400\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"prices\": [\n" +
                "          {\n" +
                "            \"type\": \"printPrice\",\n" +
                "            \"price\": 39.99\n" +
                "          }\n" +
                "        ],\n" +
                "        \"thumbnail\": {\n" +
                "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/8/c0/51dda501724ed\",\n" +
                "          \"extension\": \"jpg\"\n" +
                "        },\n" +
                "        \"images\": [\n" +
                "          {\n" +
                "            \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/8/c0/51dda501724ed\",\n" +
                "            \"extension\": \"jpg\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/c/d0/4bb67e65e44df\",\n" +
                "            \"extension\": \"jpg\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"creators\": {\n" +
                "          \"available\": 0,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/22582/creators\",\n" +
                "          \"items\": [],\n" +
                "          \"returned\": 0\n" +
                "        },\n" +
                "        \"characters\": {\n" +
                "          \"available\": 0,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/22582/characters\",\n" +
                "          \"items\": [],\n" +
                "          \"returned\": 0\n" +
                "        },\n" +
                "        \"stories\": {\n" +
                "          \"available\": 2,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/22582/stories\",\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/50048\",\n" +
                "              \"name\": \"Civil War 1-7; Marvel Spotlight Civil War; Civil War Script Book\",\n" +
                "              \"type\": \"cover\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/50049\",\n" +
                "              \"name\": \"Civil War 1-7; Marvel Spotlight Civil War; Civil War Script Book\",\n" +
                "              \"type\": \"interiorStory\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"returned\": 2\n" +
                "        },\n" +
                "        \"events\": {\n" +
                "          \"available\": 1,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/22582/events\",\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/events/238\",\n" +
                "              \"name\": \"Civil War\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"returned\": 1\n" +
                "        }\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": 37499,\n" +
                "        \"digitalId\": 0,\n" +
                "        \"title\": \"Marvels Vol. 1 (1994) #3\",\n" +
                "        \"issueNumber\": 3,\n" +
                "        \"variantDescription\": \"\",\n" +
                "        \"description\": null,\n" +
                "        \"modified\": \"2014-05-08T12:18:41-0400\",\n" +
                "        \"isbn\": \"\",\n" +
                "        \"upc\": \"\",\n" +
                "        \"diamondCode\": \"\",\n" +
                "        \"ean\": \"\",\n" +
                "        \"issn\": \"\",\n" +
                "        \"format\": \"Digital Comic\",\n" +
                "        \"pageCount\": 0,\n" +
                "        \"textObjects\": [],\n" +
                "        \"resourceURI\": \"http://gateway.marvel.com/v1/public/comics/37499\",\n" +
                "        \"urls\": [\n" +
                "          {\n" +
                "            \"type\": \"detail\",\n" +
                "            \"url\": \"http://marvel.com/comics/issue/37499/marvels_vol_1_1994_3?utm_campaign=apiRef&utm_source=c9a0ab6a03e62fe32e7bbede9aea94bf\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"series\": {\n" +
                "          \"resourceURI\": \"http://gateway.marvel.com/v1/public/series/13495\",\n" +
                "          \"name\": \"Marvels Vol. 1 (1994)\"\n" +
                "        },\n" +
                "        \"variants\": [],\n" +
                "        \"collections\": [],\n" +
                "        \"collectedIssues\": [],\n" +
                "        \"dates\": [\n" +
                "          {\n" +
                "            \"type\": \"onsaleDate\",\n" +
                "            \"date\": \"2029-12-31T00:00:00-0500\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"type\": \"focDate\",\n" +
                "            \"date\": \"-0001-11-30T00:00:00-0500\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"prices\": [\n" +
                "          {\n" +
                "            \"type\": \"printPrice\",\n" +
                "            \"price\": 0\n" +
                "          }\n" +
                "        ],\n" +
                "        \"thumbnail\": {\n" +
                "          \"path\": \"http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available\",\n" +
                "          \"extension\": \"jpg\"\n" +
                "        },\n" +
                "        \"images\": [],\n" +
                "        \"creators\": {\n" +
                "          \"available\": 0,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/37499/creators\",\n" +
                "          \"items\": [],\n" +
                "          \"returned\": 0\n" +
                "        },\n" +
                "        \"characters\": {\n" +
                "          \"available\": 0,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/37499/characters\",\n" +
                "          \"items\": [],\n" +
                "          \"returned\": 0\n" +
                "        },\n" +
                "        \"stories\": {\n" +
                "          \"available\": 1,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/37499/stories\",\n" +
                "          \"items\": [\n" +
                "            {\n" +
                "              \"resourceURI\": \"http://gateway.marvel.com/v1/public/stories/106385\",\n" +
                "              \"name\": \"cover from Marvels Vol. 1 #3\",\n" +
                "              \"type\": \"cover\"\n" +
                "            }\n" +
                "          ],\n" +
                "          \"returned\": 1\n" +
                "        },\n" +
                "        \"events\": {\n" +
                "          \"available\": 0,\n" +
                "          \"collectionURI\": \"http://gateway.marvel.com/v1/public/comics/37499/events\",\n" +
                "          \"items\": [],\n" +
                "          \"returned\": 0\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        if (comicsResponse == null) {
            comicsResponse = new Gson().fromJson(json, ComicsResponse.class);
        }

        return comicsResponse;
    }

}
