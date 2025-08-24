package gino.desiigner.genbuild_billing_system.repository;

import gino.desiigner.genbuild_billing_system.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository <CategoryEntity, Long> {

    Optional<CategoryEntity>findByCategoryId(String categoryId);
}
