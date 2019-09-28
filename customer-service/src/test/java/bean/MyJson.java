package bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MyJson {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        Student student = new Student("bob", 24);
        Student student12 = new Student("lily", 23);
        list.add(student);
        list.add(student12);
        System.out.println("*******javaBean  to jsonString*******");
        String str1 = JSON.toJSONString(student);
        System.out.println(str1);
        System.out.println(JSON.toJSONString(list));
        System.out.println();

        System.out.println("******jsonString to javaBean*******");
        //Student stu1=JSON.parseObject(str1,new TypeReference<Student>(){});
        Student stu1 = JSON.parseObject(str1, Student.class);
        System.out.println(stu1);
        System.out.println();

        System.out.println("******javaBean to jsonObject******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(student);
        System.out.println(jsonObject1.getString("name"));
        System.out.println();

        System.out.println("******jsonObject to javaBean******");
        Student student2 = JSON.toJavaObject(jsonObject1, Student.class);
        System.out.println(student2);
        System.out.println();

        System.out.println("*******javaBean to jsonArray******");
        List<Student> stulist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stulist.add(new Student("student" + i, i));

        }
        JSONArray jsonArrays = (JSONArray) JSON.toJSON(stulist);
        for (int i = 0; i < jsonArrays.size(); i++) {
            System.out.println(jsonArrays.getJSONObject(i));
        }
        System.out.println();

        System.out.println("*****jsonArry to javalist******");
        List<Student> myList = new ArrayList<>();
        for (int i = 0; i < jsonArrays.size(); i++) {

            Student student3 = JSON.toJavaObject(jsonArrays.getJSONObject(i), Student.class);
            myList.add(student3);
        }
        for (Student stu : myList) {
            System.out.println(stu);
        }

        System.out.println();

        System.out.println("*****jsonObject to jsonString*****");
        String str4 = JSON.toJSONString(jsonObject1);
        System.out.println(str4);
        System.out.println();

        System.out.println("*******jsonString to jsonObject*****");
        JSONObject jso1 = JSON.parseObject(str1);
        System.out.println(jso1.getString("name"));
        System.out.println();

        System.out.println("*****jsonString to jsonArray*****");
        JSONArray jArray = JSON.parseArray(JSON.toJSONString(stulist));
        for (int i = 0; i < jArray.size(); i++) {
            System.out.println(jArray.getJSONObject(i));
        }
        System.out.println();
    }

}

class Student {

    private String name;
    private int age;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "student [name=" + name + " , " + "age=" + age + "]";
    }

}