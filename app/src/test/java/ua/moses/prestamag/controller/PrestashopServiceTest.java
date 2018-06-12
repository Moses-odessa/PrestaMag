package ua.moses.prestamag.controller;

import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import ua.moses.prestamag.controller.PrestashopService;
import ua.moses.prestamag.entity.Category;

import static org.junit.Assert.*;

public class PrestashopServiceTest {
    @Test
    public void listCategoriesTest() throws IOException {
        PrestashopService service = PrestashopService.retrofit.create(PrestashopService.class);
        Call<Map<String, List<Category>>> call = service.listCategories(0);
        Map<String, List<Category>> body = call.execute().body();
        List<Category> list = body.get("categories");
        assertNotNull(list);
        assertNotEquals(0, list.size());
    }

    @Test
    public void categoryByIdTest() throws IOException {
        PrestashopService service = PrestashopService.retrofit.create(PrestashopService.class);
        Call<Map<String,List<Category>>> call = service.categoryById(1);
        Response<Map<String, List<Category>>> execute = call.execute();
        Map<String,List<Category>> body = execute.body();
        Category category = body.get("categories").get(0);
        assertNotNull(category);
        assertEquals(1, category.getId());
    }

}