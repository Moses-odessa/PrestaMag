package ua.moses.prestamag.controller;

import android.content.Context;
import android.test.mock.MockContext;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import ua.moses.prestamag.entity.Category;
import ua.moses.prestamag.entity.Product;
import ua.moses.prestamag.entity.ProductDetails;

import static org.junit.Assert.*;

public class PrestashopServiceTest {
    private PrestashopClient client;

    @Before
    public void setUp() throws Exception {
        Context context = new MockContext();
        this.client = new PrestashopClient(context);
        assertNotNull(context);

    }

    @Test
    public void listCategoriesTest() throws IOException {
        PrestashopService service = client.getService();
        Call<Map<String, List<Category>>> call = service.listCategories(0);
        Map<String, List<Category>> body = call.execute().body();
        List<Category> list = body.get("categories");
        assertNotNull(list);
        assertNotEquals(0, list.size());
    }

    @Test
    public void categoryByIdTest() throws IOException {
        PrestashopService service = client.getService();
        Call<Map<String,List<Category>>> call = service.categoryById(1);
        Response<Map<String, List<Category>>> execute = call.execute();
        Map<String,List<Category>> body = execute.body();
        Category category = body.get("categories").get(0);
        assertNotNull(category);
        assertEquals(1, category.getId());
    }

    @Test
    public void listProductsTest() throws IOException {
        PrestashopService service = client.getService();
        Call<Map<String, List<Product>>> call = service.listProducts(2);
        Map<String, List<Product>> body = call.execute().body();
        List<Product> list = body.get("products");
        assertNotNull(list);
        assertNotEquals(0, list.size());
    }

    @Test
    public void productDetailsTest() throws IOException {
        PrestashopService service = client.getService();
        Call<Map<String, ProductDetails>> call = service.productDetails(1);
        final Response<Map<String, ProductDetails>> execute = call.execute();
        Map<String, ProductDetails> body = execute.body();
        ProductDetails productDetails = body.get("product");
        assertNotNull(productDetails);
        assertEquals(1, productDetails.getId());
    }

}