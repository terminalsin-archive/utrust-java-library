<p align="center">
  <img width="30%" height="30%" src="https://miro.medium.com/max/2260/1*ONEziBaPiLUTDdbQraoaQg.png">
  <br>
  <a href="https://github.com/terminalsin/utrust-java-library/issues"><img alt="GitHub issues" src="https://img.shields.io/github/issues/terminalsin/utrust-java-library"></a>
  <a href="https://github.com/terminalsin/utrust-java-library/network"><img alt="GitHub forks" src="https://img.shields.io/github/forks/terminalsin/utrust-java-library"></a>
  <a href="https://github.com/terminalsin/utrust-java-library/stargazers"><img alt="GitHub stars" src="https://img.shields.io/github/stars/terminalsin/utrust-java-library"></a>
  <a href="https://github.com/terminalsin/utrust-java-library"><img alt="GitHub license" src="https://img.shields.io/github/license/terminalsin/utrust-java-library"></a>
</p>
 

## What is UTrust? 
Utrust is a seamless integration that gives e-commerce businesses the power to accept digital currencies - and get all the benefits you can’t with just traditional payment methods. Read more on https://utrust.com/

## How to use the API?
It's very simple, here's an example (SandboxStoreTest.java)

```java
private static final String DUMMY_TEST_KEY = "u_test_api_344c04e4-9f81-4496-b63a-d79f6ac21e46";

@Test
public void order1Test() {
    final UTrustStoreClient uTrustStoreClient = new UTrustStoreClient(DUMMY_TEST_KEY, true);

    final OrderRequest order = new OrderRequest();
    order.setCountry("FR");
    order.setCurrency("EUR");
    order.setEmail("test@test.test");
    order.setReference("TEST #" + new Random().nextDouble());
    order.setReturnUrl("google.com");
    order.setTotal("20.00");

    final OrderRequest.Item item = new OrderRequest.Item();
    item.setSku("test1");
    item.setName("Test!");
    item.setCurrency("EUR");
    item.setPrice("10.00");
    item.setQuantity(2);

    order.addItem(item);

    final OrderResponse response = uTrustStoreClient.generateOrder(order);

    System.out.println(response);
}
```

## Integration
Using maven:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
     <groupId>com.github.terminalsin</groupId>
     <artifactId>utrust-java-library</artifactId>
     <version>1.0.0</version>
</dependency>
```

Using gradle:

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
// Build stuff...
  
dependencies {
    implementation 'com.github.terminalsin:utrust-java-library:Tag'
}

```

## Todo
- [x] Stores API
- [x] Basic order system
- [ ] Merchants API
- [ ] Remove GSON?

## Dependencies
Google GSON: https://github.com/google/gson (Shaded)

## Sponsors
![Your kit](https://www.yourkit.com/images/yklogo.png)

YourKit supports open source projects with innovative and intelligent tools
for monitoring and profiling Java and .NET applications.
YourKit is the creator of <a href="https://www.yourkit.com/java/profiler/">YourKit Java Profiler</a>,
<a href="https://www.yourkit.com/.net/profiler/">YourKit .NET Profiler</a>,
and <a href="https://www.yourkit.com/youmonitor/">YourKit YouMonitor</a>.

## Contact
Issues tab. Won't be offering direct support.
