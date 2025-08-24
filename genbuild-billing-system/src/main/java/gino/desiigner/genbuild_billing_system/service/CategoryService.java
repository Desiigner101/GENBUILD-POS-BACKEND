package gino.desiigner.genbuild_billing_system.service;

import gino.desiigner.genbuild_billing_system.io.CategoryRequest;
import gino.desiigner.genbuild_billing_system.io.CategoryResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CategoryService {
    CategoryResponse add(CategoryRequest request, MultipartFile file);

    List<CategoryResponse> read();

    void delete(String categoryId);

}
