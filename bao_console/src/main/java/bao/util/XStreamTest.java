package bao.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.SingleValueConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.File;

public class XStreamTest {
    public static void main(String[] args) {
        try {
//            String xml = ConfigUtils.loadFile("/Users/pengdongneng/projects/cashbus/cashbus/zdtest/src/main/java/bao/util/test.xml");
            XStream xStream = new XStream();
            // 定义最大范围对象别名
            xStream.alias("Users", Class.class);

            // 两者缺一不可
            xStream.alias("User", User.class);
            xStream.addImplicitCollection(Class.class, "users");

            // Field -> Attribute 形式显示
            xStream.useAttributeFor(Class.class, "id");
            xStream.useAttributeFor(User.class, "id");
            xStream.useAttributeFor(User.class, "address");
            xStream.useAttributeFor(Class.class, "name");//(A) 无此行设置，name = null. 默认取值来源：<name></name>. 还有一种替代方式: xStream.useAttributeFor("name", String.class);
            xStream.useAttributeFor(User.class, "name");// 尽管设置了，name = dongneng,也能取值成功。因为xml: <name>dongneng</name>. 但需注意Field和Attribute不能共存


            // 另一种设置, 设置Field或Attribute的类型
//            xStream.useAttributeFor("name", Double.class);// 尽管设置成Double.class 也不会影响结果

            // test convert, add Favorite class
            xStream.registerConverter(new FavoriteConvert());// 没有此项，Favorite字符串将无法转换成 对象

            Class clz = (Class) xStream.fromXML(new File("/Users/pengdongneng/projects/cashbus/cashbus/zdtest/src/main/java/bao/util/test.xml"));// fromXML(xml);
            //XStreamTest.Class(id=234, name=三年一班, users=[XStreamTest.User(id=1, name=dongneng, address=sandong, age=18, favorite=XStreamTest.Favorite(name=games))])
            System.out.println(clz.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Data
    @ToString
    public static class User{
        public int id;
        public String name;
        public String address;
        public int age;
        public Favorite favorite;
    }

    @Data
    @ToString
    @AllArgsConstructor
    public static class Favorite{
        public String name;
    }

    @Data
    @ToString
    public static class Class{
        public int id;
        public String name;
        public User[] users;
    }

    public static class FavoriteConvert implements SingleValueConverter{

        @Override
        public String toString(Object obj) {
            return obj.toString();
        }

        @Override
        public Object fromString(String str) {
            return new Favorite(str);
        }

        @Override
        public boolean canConvert(java.lang.Class type) {
//            Class
//            int
//            String
//            User
//            Integer
//            Favorite

            // 将(A) 代码注释掉，可看到结果：
//            Class
//            int
//            User
//            String
//            Integer
//            Favorite

            // 总结： 说明根据 xstream 定义别名的顺序来进行调用该方法的，默认同一类型只调用一次？

            System.out.println(type.getSimpleName());// 此行可以看到有多少个 对象 进行 '对比' 了
            return Favorite.class.equals(type);
        }
    }
}
