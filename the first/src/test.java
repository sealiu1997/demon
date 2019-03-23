import java.util.HashMap;

public class test {

//可以表达这些数据的方式

 private HashMap<String, HashMap<String, Integer>> student = new  HashMap<String, HashMap<String, Integer>>();

//填充数据的方式
 public void set(String studentname,String coursename, Integer score) {       
	 HashMap<String, Integer> map = student.get(studentname);        
        if(map == null) {
        	 map = new HashMap<String, Integer>();
            student.put(studentname, map);
        }
        map.put(coursename, score);        
        System.out.println("this time is"+map);
 }

//根据学生的姓名，找到他的所有的成绩，而每一门课的成绩，是由课程名称和分数构成的。

  HashMap<String, Integer> listofstu(String name) {        
        return student.get(name);       
    }

//找出某一门课的全部学生的成绩

  HashMap<String, Integer> listofcourse(String course) {
   HashMap<String, Integer> result =new HashMap<String, Integer>();
         for (String studentname : student.keySet()) {
            HashMap<String, Integer> map = student.get(studentname);
            if (map != null) 
                for (String coursename : map.keySet()) 
                    if (course == coursename)
                        result.put(studentname , map.get(coursename));   
        }
         return result;
    }

//以下是测试方法
 public static void main(String[] args) {
      test stu1 = new test();
         stu1.set("A","Math",90);
         stu1.set("A","Chinese",91);
         stu1.set("A","English",93);
         stu1.set("B","Math",94);
         stu1.set("B","Chinese",95);
         stu1.set("B","English",96);
         stu1.set("C","Chinese",97);
         stu1.set("C","English",98);
         System.out.println(stu1.listofstu("A"));
         System.out.println(stu1.listofcourse("Chinese"));
 }

}



