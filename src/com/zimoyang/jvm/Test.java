package com.zimoyang.jvm;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.net.URL;

public class Test {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
//        System.out.println(systemClassLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        //获取其上层：扩展类加载器
        ClassLoader extClassLoader = systemClassLoader.getParent();
//        System.out.println(extClassLoader);//sun.misc.Launcher$ExtClassLoader@61bbe9ba

        //获取其上层：
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
//        System.out.println(bootstrapClassLoader);//null

        //对于用户自定义类来说：
        ClassLoader classLoader = Test.class.getClassLoader();
//        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2

        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
//        for (URL element : urls) {
//            System.out.println(element);
//        }

        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }

        new Thread().start();

        //native ：超出java处理范围，需要调用底层C的库，调用本地方法栈
        //简单说是java调用非java的接口
//        private native void start0();
    }
}
