1. Date类甚至已过时。 打算替换Date类的新类是LocalDate，LocalTime和LocalDateTime。

   LocalDate类表示日期。 没有时间或时区的表示。
   LocalTime类表示时间。 没有日期或时区的表示。
   LocalDateTime类表示日期时间。 没有时区的表示。

   

   即OffsetDate，OffsetTime和OffsetDateTime， 带时区

2. Instant类表示精确到纳秒的时间瞬间
   Duration类是用 Java 语言首次带来的全新概念。 它表示两个时间戳之间的差异。

3. Duration处理较小的时间单位，例如毫秒，秒，分钟和小时。 它们更适合与应用程序代码进行交互。 要与人互动，您需要使持续时间更长，该类与Period类一起提供。
4. BiConsumer-> 消费两个参数的consumer 接口
5. Consumer->消费一个参数的consumer 接口



java8 流api

1. Stream.of, Stream.generate() 生成无限的无序流， 一般用limit 限制元素个数

2. 中间操作 filter， sort， map 返回流对象本身

3. 终结操作： foreach， collect， match ，count， reduce（规约）reduce 操作可以实现从Stream中生成一个值， 最后返回一个值，findfirst

4. toMap

   public Map<Long, String> getIdNameMap(List<Account> accounts) {
   return accounts.stream().collect(Collectors.toMap(Account::getId, Account::getUsername));
   }

   public Map<Long, Account> getIdAccountMap(List<Account> accounts) {
   return accounts.stream().collect(Collectors.toMap(Account::getId, account -> account));
   }其实还可以使用Function接口中的一个默认方法 Function.identity() 如下

   

   重复key的情况。
   在list转为map时，作为key的值有可能重复，这时候流的处理会抛出个异常：Java.lang.IllegalStateException:Duplicate key。这时候就要在toMap方法中指定当key冲突时key的选择。(这里是选择第二个key覆盖第一个key)
   public Map<String, Account> getNameAccountMap(List<Account> accounts) {
   return accounts.stream().collect(Collectors.toMap(Account::getUsername, Function.identity(), (key1, key2) -> key2));
   }

   

   用groupingBy 或者 partitioningBy进行分组
   根据一个字段或者属性分组也可以直接用groupingBy方法，很方便。
   Map<Integer, List<Person>> personGroups = Stream.generate(new PersonSupplier()).
   limit(100).
   collect(Collectors.groupingBy(Person::getAge));
   Iterator it = personGroups.entrySet().iterator();
   while (it.hasNext()) {
   Map.Entry<Integer, List<Person>> persons = (Map.Entry) it.next();
   System.out.println("Age " + persons.getKey() + " = " + persons.getValue().size());
   }

   

   partitioningBy可以理解为特殊的groupingBy，key值为true和false，当然此时方法中的参数为一个判断语句（用于判断的函数式接口）
   Map<Boolean, List<Person>> children = Stream.generate(new PersonSupplier()).
   limit(100).
   collect(Collectors.partitioningBy(p -> p.getAge() < 18));
   System.out.println("Children number: " + children.get(true).size());
   System.out.println("Adult number: " + children.get(false).size());





Java 流装箱示例

1. 原始类型集合转换 需要先装箱，再进行流操作 再转成集合



Lambda 表达式

1. 在编程中， Lambda 表达式（或函数）只是一个匿名函数，即不带名称且不受标识符约束的函数。

   换句话说，lambda 表达式是无名称的函数，以常量值形式给出，并精确地写在需要的地方，通常作为其他函数的参数。



Java 8 方法引用示例

1. 我们可以使用`class::methodName`类型的语法从类或对象中引用方法

   | 方法引用                       | 描述                                   | 方法引用示例                                            |
   | ------------------------------ | -------------------------------------- | ------------------------------------------------------- |
   | **静态方法**的引用             | 用于从类中引用静态方法                 | `Math::max`等同于`(x, y) -> Math.max(x,y)`              |
   | 来自实例的**实例方法**的引用   | 使用所提供对象的引用来引用实例方法     | `System.out::println`等同于`x -> System.out.println(x)` |
   | 来自类类型的**实例方法**的引用 | 在上下文提供的对象的引用上调用实例方法 | `String::length`等同于`str -> str.length()`             |
   | **构造器**的引用               | 引用构造器                             | `ArrayList::new`等同于`() -> new ArrayList()`           |



Java 8 Optional

1. 创建optional 对象
2. 默认/不存在的值和动作 Company company = companyOptional.orElse(new Company());
3. **几乎在所有时间**都应该使用`Optional`**作为可能不返回值的函数**的返回类型。



Java 谓词示例 – 谓词过滤器

1. Predicate， 流处理方法中的filter



Java8 日期

1. 所有关键的公共类都是不可变的并且是线程安全的
   其他计算领域可以采用的定义的术语和行为

2. [`LocalDate`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html)类表示日期。 没有时间或时区的表示

3. [`LocalTime`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html)类表示时间。 没有日期或时区的表示。

4. [`LocalDateTime`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html)类表示日期时间。 没有时区的表示。

5. `Instant`类表示精确到纳秒的时间点

   ```java
   Instant instant = Instant.now();
   System.out.println(instant.toString());                                 //2013-05-15T05:20:08.145Z
   System.out.println(instant.plus(Duration.ofMillis(5000)).toString());   //2013-05-15T05:20:13.145Z
   System.out.println(instant.minus(Duration.ofMillis(5000)).toString());  //2013-05-15T05:20:03.145Z
   System.out.println(instant.minusSeconds(10).toString());                //2013-05-15T05:19:58.145Z
   ```

6. [`Duration`](https://docs.oracle.com/javase/8/docs/api/java/time/Duration.html)类是用 Java 语言首次带来的全新概念。 它表示两个时间戳之间的差异。

7. 要与人互动，您需要获得更大的持续时间，并以[`Period`](https://docs.oracle.com/javase/8/docs/api/java/time/Period.html)类给出。

8. 日期调整器： 

   ```java
   LocalDate date = LocalDate.of(2013, Month.MAY, 15);                        //Today
   
   LocalDate endOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
   System.out.println(endOfMonth.toString());                                 //2013-05-31
   
   LocalDate nextTue = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
   System.out.println(nextTue.toString());                                    //2013-05-21
   ```

9. 日期格式化通过两个类别（主要是`DateTimeFormatterBuilder`和`DateTimeFormatter`）支持

   ```java
   DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
   formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
                   .appendLiteral("-")
                   .appendZoneOrOffsetId();
   DateTimeFormatter formatter = formatterBuilder.toFormatter();
   System.out.println(formatter.format(ZonedDateTime.now()));
   ```



Java8文件操作

1. 使用Files.list()列出所有文件和子目录

   ```java
   Files.list(Paths.get("."))
           .forEach(System.out::println);
   
    Output:
   
   .\filename1.txt
   .\directory1
   .\filename2.txt
   .\Employee.java
   ```

2. 使用过滤器表达式仅列出目录内的文件

   ```java
   Files.list(Paths.get("."))
           .filter(Files::isRegularFile)
           .forEach(System.out::println);
   
    Output:
   
   .\filename1.txt
   .\filename2.txt
   .\Employee.java
   ```

3. 读文件， 逐行

   ```java
   Path filePath = Paths.get("c:/temp", "data.txt");
   
   //try-with-resources
   try (Stream<String> lines = Files.lines( filePath )) 
   {
       lines.forEach(System.out::println);
   } 
   catch (IOException e) 
   {
       e.printStackTrace();
   }
   ```

4. 写入文件，两种方式

   ```java
   //Get the file reference
   Path path = Paths.get("c:/output.txt");
   
   //Use try-with-resource to get auto-closeable writer instance
   try (BufferedWriter writer = Files.newBufferedWriter(path)) 
   {
       writer.write("Hello World !!");
   }
   ```

```java
String content = "Hello World !!";

Files.write(Paths.get("c:/output.txt"), content.getBytes());
```





Java8 连接字符串

1. ```java
   String joinedString = String.join(", ", "How", "To", "Do", "In", "Java");
   System.out.println(joinedString);
   
   Output:
   
   How, To, Do, In, Java
   ```

2. ```java
   StringJoiner joiner = new StringJoiner(", ", "[", "]");
   
   joiner.add("How")
           .add("To")
           .add("Do")
           .add("In")
           .add("Java");
   
   Output:
   
   [How, To, Do, In, Java]
   ```