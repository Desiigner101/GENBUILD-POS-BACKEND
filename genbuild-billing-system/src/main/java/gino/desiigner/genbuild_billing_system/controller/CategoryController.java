package gino.desiigner.genbuild_billing_system.controller;

import gino.desiigner.genbuild_billing_system.io.CategoryRequest;
import gino.desiigner.genbuild_billing_system.io.CategoryResponse;
import gino.desiigner.genbuild_billing_system.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request){
       return categoryService.add(request);
    }

    @GetMapping
    public List<CategoryResponse> fetchCategories(){
       return categoryService.read();
    }
}
