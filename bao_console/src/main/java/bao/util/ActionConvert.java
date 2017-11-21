package bao.util;

import bao.action.preHandler.DigitalInputAction;
import bao.action.preHandler.SelectedDigitalAction;
import com.thoughtworks.xstream.converters.SingleValueConverter;

import java.util.ArrayList;
import java.util.List;

public class ActionConvert<T> implements SingleValueConverter {
    private static ActionConvert instance = new ActionConvert();

    public static ActionConvert getInstance() {
        return instance;
    }

    private static List<Class> actionList = new ArrayList<>();

    public static void registerAction(Class clz){
        if(clz!=null && !actionList.contains(clz)){
           actionList.add(clz);
        }
    }

    @Override
    public String toString(Object obj) {
        return obj.getClass().getName();
    }

    @Override
    public Object fromString(String str) {
        try {
            if(str == null || "".equals(str)){
                return null;
            }
            Class clz = Class.forName(str);
            if(actionList.contains(clz)) {
                try {
                    Object obj = clz.newInstance();
                    return obj;
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean canConvert(Class type) {
        return actionList.contains(type) || instanceOf(type, actionList);
}

    /**
     *
     * @param type 比需要有无参构造器
     * @param actionList
     * @return
     */
    private static boolean instanceOf(Class type, List<Class> actionList) {
        for(Class clz : actionList){
            try {
                Object o = type.newInstance();
                if(clz.isInstance(o)){
                    return true;
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<Class> clzs = new ArrayList<>();
        clzs.add(DigitalInputAction.class);
        System.out.println(instanceOf(SelectedDigitalAction.class, clzs));// true
        System.out.println(SelectedDigitalAction.class.isInstance(DigitalInputAction.class));
        System.out.println(DigitalInputAction.class.isInstance(Object.class));
        SelectedDigitalAction s = new SelectedDigitalAction();
        System.out.println(SelectedDigitalAction.class.isInstance(s));// trye
        System.out.println(DigitalInputAction.class.isInstance(s));// true
        System.out.println(new SelectedDigitalAction() instanceof Object);
    }
}
