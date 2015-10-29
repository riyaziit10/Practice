package main.java.com.personal.Random;

import java.lang.reflect.*;

/**
 * Created by riyaz on 21/10/15.
 */

interface XYZ {
void show();
}
class ABC {

}
final class TestDemo extends ABC  implements XYZ{

    private String str;

    private Integer num;

    protected char protedtedChar;

    public Integer publicInteger;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public char getCh() {
        return protedtedChar;
    }

    public void setCh(char ch) {
        this.protedtedChar = ch;
    }

    public Integer getPublicInteger() {
        return publicInteger;
    }

    public void setPublicInteger(Integer publicInteger) {
        this.publicInteger = publicInteger;
    }

    public String getPublicString() {
        return publicString;
    }

    public void setPublicString(String publicString) {
        this.publicString = publicString;
    }

    public String publicString;
    public void showPublicFields() {
        System.out.println(publicInteger + "\t" + publicString + "\t" + protedtedChar);
    }
    public TestDemo(String a) {
        System.out.println("String constructor");
    }

    public TestDemo(Integer i) {
        System.out.println("Integer Constructor");
    }

    public TestDemo(String str, Integer a) {
        this.str = str;
        this.num = a;
        System.out.println("Arguements are\t" + str + "\t" + a);
    }

    public TestDemo() {
    }

    private void privateShow() {
        System.out.println("Private show method\t" + str + "\t" + num);
    }

    protected  void protectedShow() {
        System.out.println("Protected show method\t" + str + "\t"+ num);
    }

    public void publicShow() {
        System.out.println("Public show method" + str + "\t" + num);
    }

    public void showPublicFields(String str, Integer integer) {
        System.out.println("Provided input is \t" + str + "\t" + integer);
    }
    private static void staticMethod() {
        System.out.println("private Static Method");
    }
    @Override
    public void show() {
        System.out.println("XYZ interface's method");
    }
}
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
//        String str = "Riyaz";
//        Class classObject = TestDemo.class;
//
//        System.out.println("Reflection Example \t" + classObject.getName());
//        System.out.println("Reflection Example \t" + classObject.getSimpleName());
//
//        int sepecifier = classObject.getModifiers();
//
//        System.out.println("Is final \t" + Modifier.isFinal(sepecifier));
//        System.out.println("Pakage name \t" + classObject.getPackage());
//        System.out.println("Super class \t " + classObject.getSuperclass().getSimpleName());
//        System.out.println("Interface \t" + classObject.getInterfaces()[0]);

//        Class classObject = TestDemo.class;
//
//
//        Constructor constructor = classObject.getConstructor(String.class);
//
//        System.out.println("String Constructor is \t" + constructor.getName());
//
//        Class [] parameterType = constructor.getParameterTypes();
//
//        System.out.println("Parameters Types are \t" + parameterType[0].getSimpleName());
//
//        TestDemo a = TestDemo.class.getConstructor(new Class[]{String.class, Integer.class}).newInstance("RiyazAli", 10);
//        a.protectedShow();

//        Class name = Class.forName("main.java.com.personal.Random.Reflection");
//        System.out.println(name);

//        Class classObject = TestDemo.class;
//        Field [] fields = classObject.getFields();
//        for(Field  f: fields)
//            System.out.println(f.getType().getName());
//
//
//        Class classObject = TestDemo.class;
//        Field field=null;
//        try {
//            field = classObject.getField("publicString");
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(field.getType());
//
//        TestDemo t = new TestDemo();
//        field.set(t, "riyazAli");
//        t.showPublicFields();
//        TestDemo t = new TestDemo();
//        Class classObject = TestDemo.class;
//        Field integerField = classObject.getField("integerField");
//        Field stringField = classObject.getField("stringField");
//        Method method = TestDemo.class.getMethod("showPublicFields", null);
//        method.invoke(t, "riyazAli", 10);

//        Class classObject = TestDemo.class;
//
//        Method [] methods = classObject.getMethods();
//
//        for(Method method: methods) {
//            if(isGetter(method)) {
//                System.out.println("Getter method is \t" + method.getName());
//            }
//            if(isSetter(method)) {
//                System.out.println("Setter Method is \t" + method.getName());
//            }
//        }


        Class classObject = TestDemo.class;

//        Field [] fields = classObject.getDeclaredFields();
//
//        for(Field field: fields)
//            System.out.println("All private, protected and public fields  are \t" + field.getName());
//
//        Method [] methods = classObject.getDeclaredMethods();
//        System.out.println("=============================================");
//
//        for(Method method: methods)
//            System.out.println("All private, protedted and public methods are\t" + method.getName() );

//        Method method = classObject.getMethod("publicShow");
//        Constructor constructor = TestDemo.class.getConstructor(new Class[]{String.class, Integer.class});
//        TestDemo t = (TestDemo) constructor.newInstance("Snapdeal", 10);
//        method.invoke(t);
//
//        TestDemo object = TestDemo.class.getConstructor().newInstance();
//        object.setCh('R');
//        object.setNum(100);
//        System.out.println("char value is \t" + object.getCh() + "\t And number is \t" + object.getNum());

//        int [] arr = (int[]) Array.newInstance(int.class, 3);
//
//        Array.set(arr, 0, 100);
//        Array.set(arr, 1, 200);
//        Array.set(arr, 2, 300);
//
//        System.out.println("Array values are \t" + Array.get(arr, 0));
//        System.out.println("Array values are \t" + Array.get(arr, 1));
//        System.out.println("Array values are \t" + Array.get(arr,2));


        System.out.println(int[].class.getSimpleName());

    }

    private static boolean isSetter(Method method) {
        if(!method.getName().startsWith("set"))
            return false;
        if(method.getParameterTypes().length != 1)
            return false;
        return true;
    }

    private static boolean isGetter(Method method) {
        if(!method.getName().startsWith("get"))
            return false;
        if(method.getParameterTypes().length != 0)
            return false;
        if(void.class.equals(method.getReturnType()))
            return false;
        return true;
    }
}
