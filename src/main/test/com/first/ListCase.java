package com.first;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 周云龙
 * @date 2018/4/25 9:34
 */
public class ListCase {


    @Test
    public void caseOne(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");


        Iterator iterator= list.iterator();

        while (iterator.hasNext()){
            if (iterator.next().equals("3")){
//                list.add("5");
//                iterator.remove();
            }
            System.out.println(iterator.next());
        }
//        for (String i : list) {
//            if (i.equals("3")) {
//                list.remove(i);
//            }
//        }

//        for (int i=0;i<list.size();i++){
//            if (list.get(i) == 3) {
//                list.remove(i);
//            }
//        }
        list.forEach(System.out::print);
    }

    @Test
    public void caseTwo(){
        int i=1;
        System.out.println(i);
        System.out.println(i>>1);
    }
}
