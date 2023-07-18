package com.example.storageservice;

import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StorageServiceApplicationTests {
    @Mock
    private CreateItemStorageService createItemStorageService;
    @Test
    void CreateItemStorageTest() {
        //CreateItemStorageResponse createItemStorageRequest= createItemStorageService.createItemStorage(new CreateItemStorageRequest(UUID.randomUUID(),5,5.0f));

    }


}
