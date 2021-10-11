import Trees.LeftViewBinaryTree;
import Trees.SecondHighestNumberInBST;
import Trees.TreeProblems;
import jdk.jfr.internal.tool.Main;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.Timestamp;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 11, 50, 10);
        AtomicInteger count = new AtomicInteger();
        list.stream().forEach(x -> {
            count.addAndGet(x);
        });
        //System.out.println("result:"+count);

        // Map<Integer, Integer> map1 = list.stream().collect(Collectors.toMap(x->x,x->2*x));
        //System.out.println(list.stream().collect(Collectors.summingInt(x->x)));
        //System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        //System.out.println(map1);
        // checkSumPair();
        //shoppingCartMatch();
        //sortHashMapValue();
        //kthSmallestElement();
        //kthHighestElement();
        //MultiThreading multiThreading = new MultiThreading();
        // multiThreading.threadDemo();
        //restrictiveManipulationOfObjects();
        //testDemo();
        //fileCreator();
       // sortMapByValue();
       // TreeProblems.solveTreeProblems();
        //Singleton singleton1 = Singleton.getSingletonInstance();

        //concurrentModificationException();
        new MainDemo().printPermutationsOfString("abc","");


    }

    public static void kthSmallestElement() {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(A.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < A.size(); i++) {
            // if the current element is less than the root of the heap
            if (A.get(i) < pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(A.get(i));
            }
        }

        // return the root of max-heap
        System.out.println("Smallest Elem:" + pq.peek());
    }

    public static void kthHighestElement() {
        List<Integer> A = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(A.subList(0, k));

        // do for remaining array elements
        for (int i = k; i < A.size(); i++) {
            // if the current element is less than the root of the heap
            if (A.get(i) > pq.peek()) {
                // replace root with the current element
                pq.poll();
                pq.add(A.get(i));
            }
        }

        // return the root of max-heap
        System.out.println("HighestElem:" + pq.peek());
    }

    public static void restrictiveManipulationOfObjects() {
        SituationSolving situationSolving = new SituationSolving();
        List<String> list = situationSolving.getTestList();
        System.out.println("Before Modification from external Class:"+list);
        Collections.unmodifiableList(list);
        list.add("Anil");
        System.out.println("After modifying same class:"+list);
        System.out.println(situationSolving.getTestList());
    }

    public static void checkSumPair() {
        List<Integer> list1 = Arrays.asList(1, 5, 7, -1, 9, 10, -3);
        int sum = 6;
        Map<Integer, Integer> diff = list1.stream().collect(Collectors.toMap(x -> x, x -> sum - x));

        //System.out.println(diff);
        Map<Integer, Integer> resultMap = new HashMap<>();

        list1.stream().forEach(x -> {
            if (list1.contains(diff.get(x))) {
                System.out.println("pair:" + x + ":" + diff.get(x));
                if (resultMap.get(x) == null && resultMap.get(6 - x) == null)
                    resultMap.put(x, diff.get(x));
            }
        });
        System.out.println(resultMap);
    }

    public static void sortHashMapValue() {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Anil", 25);
        hashMap.put("Akhil", 10);
        hashMap.put("Maalu", 35);
        hashMap.put("Geethu", 75);
        hashMap.put("Ajimama", 15);


        /**
         Making use of a Binary Operator
         Map<String, Object> sortedHashMap = new LinkedHashMap<>();
         sortedHashMap = hashMap.entrySet().stream().sorted((x1,x2)-> {
         return x1.getValue().compareTo(x2.getValue());
         }).collect(Collectors.toMap(x->x.getKey(),x->x.getValue(),(o, o2) -> o2,LinkedHashMap::new));
         System.out.println(sortedHashMap);
         */

        //The method i am comfy with
        List<Map.Entry<String, Integer>> listOfMapObj = new LinkedList<>(hashMap.entrySet());

        Collections.sort(listOfMapObj, (x1, x2) -> {
            return x1.getValue().compareTo(x2.getValue());
        });
        System.out.println(listOfMapObj);

       /* Queue<Integer> queue = new LinkedList<>(Arrays.asList());
        //System.out.println(queue.poll()+":"+queue.size()+":"+queue.remove()+":"+queue.size());
        Optional<Integer> t1 = Optional.ofNullable(queue.poll());
        System.out.println(t1.isPresent());*/

    }



    public static void testDemo() {
        List<String>testList = Stream.of("VanDjk","VanPersie","MezutOzil","CarlosPuyol").collect(Collectors.toList());
        List<String> tempList =Stream.of("Messi","Ronaldo","Flamini","Ballack").collect(Collectors.toList());
        testList = Collections.unmodifiableList(testList);
        try {
            testList.add("Henry");
        }catch (Exception e) {
            System.out.println("Caught you here!!!");
        }

        System.out.println(testList);
    }

    public static void fileCreator() {
        File file = new File("/Users/anangathputhenve/PayPal_Projects/DemoProject/OutsideBuild/sample1.text");
        File file1 = new File("/Users/anangathputhenve/PayPal_Projects/DemoProject/OutsideBuild/sample1.text");

        try {
            System.out.println("Start:"+ System.currentTimeMillis());
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("kyun likh rahe ho");
            fileWriter.close();
            System.out.println("After:"+System.currentTimeMillis());


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Yahan pe ayega Exception");
        }
    }

    public static void sortMapByValue() {
        HashMap<Integer,String> hashMap = new HashMap<>();
        hashMap.put(1,"Flamini");
        hashMap.put(4,"Zidane");
        hashMap.put(9,"Puyol");
        hashMap.put(2,"Henry");

        hashMap.entrySet().stream().sorted((x1,x2)->{return x1.getValue().compareTo(x2.getValue());})
                .forEach(System.out::println);
    }

    public static void shoppingCartMatch() {
        //Amazon problem
        List<List<String>> codeList = new ArrayList() {
            {
                add(Arrays.asList("apple", "apple"));
                add(Arrays.asList("banana", "anything", "banana"));
            }
        };
        List<String> shoppingCart = Arrays.asList("orange", "apple", "apple", "banana", "orange", "banana");
        System.out.println(codeList);
        int codeIndex = 0;

        if (codeIndex == shoppingCart.size()) {
            System.out.println("Winner FOund");
        } else {
            System.out.println("Not winner");
        }

    }


    public static void concurrentModificationException() {

        //Use CopyOnWriteArrayList
        List<Integer> list1 = new ArrayList<>();
        list1.add(29);list1.add(90);list1.add(12);list1.add(5);


        Iterator<Integer> iterator = list1.iterator();
        for(int i=0;i<list1.size();i++){
            System.out.println(list1.get(i));
            list1.add(10);
            if(i>30) break;
        }
        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
            list1.add(10);
        }*/
    }

    void  printPermutationsOfString(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) +
                        str.substring(i + 1);
                printPermutationsOfString(rem, prefix + str.charAt(i));

            }
        }

    }


}
