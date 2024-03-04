package org.example;

import com.github.javafaker.Faker;
import org.example.Models.Data;
import org.example.Models.Entity;
import org.example.Models.EntityCreated;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;


public class PostDataHelper {

    static Faker faker = new Faker(new Locale("en"));

    public static Map<String, Object> getEntityPostMap(String json) throws IOException {
        return new Entity(json).toMap();
    }

    public static Map<String, Object> getEntityCreatedMap() {
        return new EntityCreated().toMap();
    }

    public static void printMessage(Object message){
        System.out.println(message);
    }

    public static String createEntityData() throws IOException{
        Entity entity = new Entity();
        Data data = new Data();
        data.setCpuModel("Intel Core i9");
        data.setHardDiskSize("2 TB");
        data.setPrice(1300.67);
        data.setYear(2023);
        entity.setName(faker.name().fullName());
        entity.setData(data);
        return entity.toJson();
    }

//    public static PostData createPostData() {
//        GorestUsersTests.userGetID();
//        PostData postData = new PostData();
//        Faker faker = new Faker();
//        postData.setUser_id(GorestUsersTests.userID);
//        postData.setTitle(faker.book().title());
//        postData.setBody(faker.lorem().paragraph());
//        return postData;
//    }
//
//    public static CommentData createCommentData() {
//        GorestPostTests.postGetID();
//        CommentData commentData = new CommentData();
//        Faker faker = new Faker();
//        commentData.setPost_id(GorestPostTests.postID);
//        commentData.setName(faker.name().fullName());
//        commentData.setEmail(faker.internet().emailAddress());
//        commentData.setBody(faker.lorem().paragraph());
//        return commentData;
//    }
//
//    public static TodoData createTodoData() {
//        GorestUsersTests.userGetID();
//        TodoData todoData = new TodoData();
//        todoData.setUser_id(GorestUsersTests.userID);
//        todoData.setTitle(new Faker().book().title());
//        todoData.setDue_on("2024-03-01T00:00:00.000+05:30");
//        todoData.setStatus("pending");
//        return todoData;
//    }
}
