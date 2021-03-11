package ch11;

import java.lang.reflect.InvocationTargetException;

public class NewInstanceExample {
    public static void main(String[] args){
        try{
            //Class clazz = Class.forName("ch11.SendAction");
            Class clazz = Class.forName("ch11.ReceiveAction");
            Action action = (Action) clazz.getDeclaredConstructor().newInstance();
            action.execute();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
