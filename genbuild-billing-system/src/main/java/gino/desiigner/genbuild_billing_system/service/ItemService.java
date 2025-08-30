package gino.desiigner.genbuild_billing_system.service;

import gino.desiigner.genbuild_billing_system.io.ItemRequest;
import gino.desiigner.genbuild_billing_system.io.ItemResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {

    ItemResponse add(ItemRequest request, MultipartFile file);

    List<ItemResponse> fetchItems();

    void deleteItem(String itemId);
}
