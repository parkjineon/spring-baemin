package exercise.etc;

import ch.qos.logback.core.joran.sanity.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class IteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> sportStars = new ArrayList<>();
        // add 5개
        // for
        sportStars.add("Yuna Kim");
        sportStars.add("Jauk Koo");
        sportStars.add("Heongmin Son");
        sportStars.add("Seri Park");
        sportStars.add("Sanghwa Lee");

        for(int i = 0; i < sportStars.size(); i++){
            System.out.println(sportStars.get(i));
        }

        Iterator<String> sportStarIterator = sportStars.iterator();

        while(sportStarIterator.hasNext()){
            System.out.println(sportStarIterator.next());
        }

        for(String sportStar: sportStars){
            System.out.println(sportStar);
        }

        Map<Integer,String> fruits = new HashMap<>();
        //과일 5개
        //하나씩 출력 (for 문)


        fruits.put(0,"apple");
        fruits.put(1,"grape");
        fruits.put(2,"banana");
        fruits.put(3,"kiwi");
        fruits.put(4,"orange");

        Iterator<String> fruitsIterator = fruits.values().iterator();
        while(fruitsIterator.hasNext()){
            System.out.println(fruitsIterator.next());
        }

        for(String fruit : fruits.values()){
            System.out.println(fruit);
        }

    }
}
