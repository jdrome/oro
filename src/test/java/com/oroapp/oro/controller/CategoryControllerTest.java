package com.oroapp.oro.controller;

import com.oroapp.oro.dto.CategoryDTO;
import com.oroapp.oro.entity.Category;
import com.oroapp.oro.service.CategoryService;
import com.oroapp.oro.mapper.CategoryMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private CategoryMapper categoryMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateCategory() throws Exception {
        CategoryDTO inputDto = new CategoryDTO();
        inputDto.setName("Groceries");

        Category category = new Category();
        category.setName("Groceries");

        Category savedCategory = new Category();
        savedCategory.setName("Groceries");

        CategoryDTO resultDto = new CategoryDTO();
        resultDto.setName("Groceries");

        when(categoryMapper.toEntity(any(CategoryDTO.class))).thenReturn(category);
        when(categoryService.saveCategory(any(Category.class))).thenReturn(savedCategory);
        when(categoryMapper.toDTO(any(Category.class))).thenReturn(resultDto);

        mockMvc.perform(post("/api/categories")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(inputDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Groceries"));
    }

    @Test
    void testGetCategoryByName() throws Exception {
        String name = "Utilities";

        Category category = new Category();
        category.setName(name);

        CategoryDTO dto = new CategoryDTO();
        dto.setName(name);

        when(categoryService.findByName(name)).thenReturn(category);
        when(categoryMapper.toDTO(category)).thenReturn(dto);

        mockMvc.perform(get("/api/categories/name/{name}", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(name));
    }

    @Test
    void testGetCategoryById() throws Exception {
        Long id = 1L;

        Category category = new Category();
        category.setName("Rent");

        CategoryDTO dto = new CategoryDTO();
        dto.setName("Rent");

        when(categoryService.findById(id)).thenReturn(category);
        when(categoryMapper.toDTO(category)).thenReturn(dto);

        mockMvc.perform(get("/api/categories/id/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Rent"));
    }

    @Test
    void testGetCategories() throws Exception {
        Category category1 = new Category();
        category1.setName("Food");

        Category category2 = new Category();
        category2.setName("Transport");

        List<Category> categories = Arrays.asList(category1, category2);

        CategoryDTO dto1 = new CategoryDTO();
        dto1.setName("Food");

        CategoryDTO dto2 = new CategoryDTO();
        dto2.setName("Transport");

        when(categoryService.findAll()).thenReturn(categories);
        when(categoryMapper.toDTO(category1)).thenReturn(dto1);
        when(categoryMapper.toDTO(category2)).thenReturn(dto2);

        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Food"))
                .andExpect(jsonPath("$[1].name").value("Transport"));
    }
}
