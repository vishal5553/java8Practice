import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//public class java8Demo.Main {
   /* int id;
    String name;
    double percentage;
    String specialization;
    public java8Demo.Main(int id, String name, double percentage, String specialization) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.specialization = specialization;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString()
    {
        return id+"-"+name+"-"+percentage+"-"+specialization;
    }
*/

//   public static void main(String[] args) {

// System.out.println("hello");
       /* List<java8Demo.Main> mainList1= new ArrayList<java8Demo.Main>();

        mainList1.add(new java8Demo.Main(111, "John", 81.0, "Mathematics"));
        mainList1.add(new java8Demo.Main(222, "Harsha", 79.5, "History"));
        mainList1.add(new java8Demo.Main(333, "Ruth", 87.2, "Computers"));
        mainList1.add(new java8Demo.Main(444, "Aroma", 63.2, "Mathematics"));
        mainList1.add(new java8Demo.Main(555, "Zade", 83.5, "Computers"));
        mainList1.add(new java8Demo.Main(666, "Xing", 58.5, "Geography"));
        mainList1.add(new java8Demo.Main(777, "Richards", 72.6, "Banking"));
        mainList1.add(new java8Demo.Main(888, "Sunil", 86.7, "History"));

        Predicate<java8Demo.Main> mathematicsPredicate = (java8Demo.Main main1) -> main1.getSpecialization().equals("Mathematics");
        List<java8Demo.Main> mathematicsStudents = new ArrayList<java8Demo.Main>();

        for (java8Demo.Main main1 : mainList1) {
            if (mathematicsPredicate.test(main1)) {
                mathematicsStudents.add(main1);
            }
        }
        System.out.println("students specializing in math");
        for (java8Demo.Main student : mathematicsStudents){
            System.out.println(student);
        }


        Consumer<java8Demo.Main> percentageConsumer = (java8Demo.Main main1) -> {
            System.out.println(main1.getName()+" : "+main1.getPercentage());
        };

        for (java8Demo.Main main1 : mainList1)
        {
            percentageConsumer.accept(main1);
        }


        Function<java8Demo.Main,String> nameFunction = java8Demo.Main::getName;
        List<String> studentNames = mainList1.stream()
                .map(nameFunction)
                .collect(Collectors.toList());
        System.out.println("Students Names:");
        studentNames.forEach(System.out::println);


        Supplier<java8Demo.Main> studentSupplier = ()-> new java8Demo.Main(111111, "New Student", 92.9, "Java 8");
        mainList1.add(studentSupplier.get());
        System.out.println("Student List: ");
        mainList1.forEach(System.out::println);




    }}
*/


public class Main {

    public static void main(String[] args) {
        //Creates a stream from values
        // Static Method
        Stream<Integer> stream = Stream.of(7, 4, 2, 9, 3, 5);
        System.out.println(stream.count());

        // Creating streams from collections

        List<String> stringList = new ArrayList<>();
        stringList.add("*********************************");
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("*********************************");
        stringList.stream().forEach(System.out::println);

        //filter() : Selecting with a predicate
        // Intermediate Operation

        List<String> names = new ArrayList<>();
        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");
        names.add("*********************************");

        names.stream().filter((String name) -> name.length() > 5).forEach(System.out::println);

        // distinct() : Selects only unique elements
        //Intermediate Operation
        //Selecting only unique names
        List<String> names1 = new ArrayList<>();
        names1.add("David");
        names1.add("Johnson");
        names1.add("Samontika");
        names1.add("Brijesh");
        names1.add("John");
        names1.add("David");
        names1.add("Brijesh");
        names1.add("*********************************");

        names1.stream().distinct().forEach(System.out::println);

        //limit() : Selects first n elements
        //Intermediate Operation

        names1.stream().limit(4).forEach(System.out::println);
        System.out.println("*********************************");

        // skip() : Skips first n elements
        //Intermediate Operation
        //Skipping first 4 names
        names1.stream().skip(5).forEach(System.out::println);

        //map() : Applies a function
        //Intermediate Operation
        //Returns length of each name

        names1.stream().map(String::length).forEach(System.out::println);

        //sorted() : Sorting according to natural order
        //Intermediate Operation
        //Sorting the names according to natural order

        names1.stream().sorted().forEach(System.out::println);
        System.out.println("*********************************");

        //sorted(Comparator) : Sorting according to supplied comparator
        //Intermediate Operation
        //Sorting the names according to their length

        names1.stream().sorted((String name1, String name2) -> name1.length() - name2.length()).forEach(System.out::println);

        // reduce() : Produces a single value
        // Terminal Operation
        //This method performs reduction operation on elements of a stream using initial value and binary operation.

        int sum = Arrays.stream(new int[]{7, 5, 9, 2, 8, 1}).reduce(0, (a, b) -> a + b);
        System.out.println(sum);

        //There is another form of reduce() method which takes no initial value. But returns an Optional object.

        OptionalInt sum1 = Arrays.stream(new int[]{7, 5, 9, 2, 8, 1}).reduce((a, b) -> a + b);
        System.out.println(sum1);
        System.out.println("*********************************");

        // min() : Finding the minimum
        //Terminal Operation
        // It returns minimum element in a stream wrapped in an Optional object.
        OptionalInt min = Arrays.stream(new int[]{7, 5, 9, 2, 8, 1}).min();
        System.out.println(min);

        //max() : Finding the maximum
        //Terminal Operation
        // It returns maximum element in a stream wrapped in an Optional object.
        OptionalInt max = Arrays.stream(new int[]{7, 5, 9, 2, 8, 1}).max();
        System.out.println(max);
        System.out.println("*********************************");

        // count() : Counting the elements
        // Terminal Operation
        // Returns the number of elements in a stream.

        long noOfBigNames = names1.stream().filter((String name3) -> name3.length() > 5).count();
        System.out.println(noOfBigNames);
        System.out.println("*********************************");

        // collect() : Returns mutable container
        // Terminal Operation
        //collect() method is a special case of reduction operation called mutable reduction operation because it returns mutable result container such as List or Set.
        //Storing first 3 names in a mutable container

        List<String> first3Names = names1.stream().limit(3).collect(Collectors.toList());
        System.out.println(first3Names);
        System.out.println("*********************************");

        // ********-Finding And Matching Operations-********
        //anyMatch() : Any one element matches
        //Short-circuiting Terminal Operation
        // Returns true if any one element of a stream matches with given predicate. This method may not evaluate all the elements of a stream. Even if the first element matches with given predicate, it ends the operation.

        if (names1.stream().anyMatch((String name5) -> name5.length() == 5)) {
            System.out.println("Yes... There is a name exist with 5 letters");
        }

        //allMatch() : All elements matches
        //Terminal Operation
        // This method returns true if all the elements of a stream matches with given predicate. Otherwise returns false.

        if (names1.stream().allMatch((String name6) -> name6.length() > 3)) {
            System.out.println("All are big names");
        }

        //noneMatch() : No element matches
        //Terminal Operation
        //Returns true only if all the elements of a stream doesn’t match with given predicate.

        if (names1.stream().allMatch((String name7) -> name7.length() == 2)) {
            System.out.println("There is no two letter name");
        }
        System.out.println("NO");

        //findFirst() : Finding first element
        //Short-circuiting Terminal Operation
        //Returns first element of a stream wrapped in an Optional object.

        Optional<String> firstElement = Stream.of("First", "Second", "Third", "Fourth").findFirst();
        System.out.println(firstElement);

        //findAny() : Finding any element
        // Short-circuiting Terminal operation
        // Randomly returns any one element in a stream. The result of this operation is unpredictable. It may select any element in a stream. Multiple invocations on the same source may not return same result.

        Optional<String> anyElement = Stream.of("First", "Second", "Third", "Fourth").findAny();
        System.out.println(anyElement);

        //forEach()
        //Terminal Operation
        //Performs an action on all elements of a stream.

        Stream.of("First", "Second", "Second", "Third", "Fourth").limit(3).distinct().forEach(System.out::println);

        // toArray() : Stream to array
        //Terminal Operation
        // Returns an array containing elements of a stream.
        //Storing first 3 names in an array

        Object[] streamArray = names1.stream().limit(3).toArray();
        System.out.println(Arrays.toString(streamArray));

        //peek() :
        //Intermediate Operation
        // Performs an additional action on each element of a stream. This method is only to support debugging where you want to see the elements as you pass in a pipeline.

        names1.stream()
                .filter(name -> name.length() > 5)
                .peek(e -> System.out.println("Filtered Name :" + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped Name :" + e))
                .toArray();

    }}



