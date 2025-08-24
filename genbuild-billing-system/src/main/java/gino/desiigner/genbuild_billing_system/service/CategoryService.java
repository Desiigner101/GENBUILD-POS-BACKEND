package gino.desiigner.genbuild_billing_system.service;

import gino.desiigner.genbuild_billing_system.io.CategoryRequest;
import gino.desiigner.genbuild_billing_system.io.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse add(CategoryRequest request);

    List<CategoryResponse> read();

    void delete(String categoryId);

}
