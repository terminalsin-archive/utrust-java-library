package com.utrust.test;

import com.utrust.api.UTrustStoreClient;
import com.utrust.api.model.Item;
import com.utrust.api.model.store.OrderRequest;
import com.utrust.api.model.store.OrderResponse;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Ghast
 * @since 19/02/2021
 * UTrust-Java-Library © 2021
 */
public class SandboxStoreTest {

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

        final Item item = new Item();
        item.setSku("test1");
        item.setName("Test!");
        item.setCurrency("EUR");
        item.setPrice("10.00");
        item.setQuantity(2);

        order.addItem(item);

        final OrderResponse response = uTrustStoreClient.generateOrder(order);

        System.out.println(response);
    }
}
