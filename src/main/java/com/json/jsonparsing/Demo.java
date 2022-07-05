package com.json.jsonparsing;

import org.json.JSONArray;
import org.json.JSONObject;

public class Demo {

	static String json = "{\n" +
            "       \"social_media\": \"instagram\",\n" +
            "       \"pageInfo\": {\n" +
            "             \"pageName\": \"abc\",\n" +
            "             \"pagePic\": \"http://example.com/content.jpg\"\n" +
            "        },\n" +
            "        \"posts\": [\n" +
            "             {\n" +
            "                  \"post_id\": \"123456789012_123456789012\",\n" +
            "                  \"actor_id\": \"1234567890\",\n" +
            "                  \"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\n" +
            "                  \"nameOfPersonWhoPosted\": \"Jane Doe\",\n" +
            "                  \"message\": \"Sounds cool. Can't wait to see it!\",\n" +
            "                  \"likesCount\": \"2\",\n" +
            "                  \"comments\": \"{\\\"name1\\\":\\\"Priya\\\",\\\"name2\\\":\\\"Sakshi\\\",\\\"name3\\\":\\\"Raheem\\\"}\",\n" +
            "                  \"timeOfPost\": \"1234567890\"\n" +
            "             }\n" +
            "        ]\n" +
            "    }";

    public static void main(String[] args) {
        JSONObject obj = new JSONObject(json);

        //parse String
        String s_media = obj.getString("social_media");
        System.out.println(s_media);

        //parse object
        String pageinfo = obj.getJSONObject("pageInfo").toString();
        System.out.println(pageinfo);

        //parse pageName from object pageInfo
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        System.out.println(pageName);

        //Parse post_id from nested object
        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++) {
            String post_id = arr.getJSONObject(i).getString("post_id");
            System.out.println(post_id);
        }

        //parse  nested object from array
        for (int i = 0; i < arr.length(); i++) {
            String seperate_obj = arr.getJSONObject(i).get("comments").toString();
            System.out.println(seperate_obj);
        }
    }

}
