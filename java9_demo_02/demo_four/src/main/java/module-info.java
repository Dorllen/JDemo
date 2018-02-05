open module demo.four {
    requires transitive fastjson;
    exports com.example.robot;
    exports com.example.robot.one;

//    opens com.example.robot.two;

//    exports com.example.robot.four;

    provides com.example.robot.three.Service with com.example.robot.three.impl.ServiceImpl;
}


