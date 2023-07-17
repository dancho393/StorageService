package com.example.storageservice;

import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageRequest;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageResponse;
import com.example.storageservice.api.operations.itemStorage.create.CreateItemStorageService;
import com.example.storageservice.controllers.ItemStorageController;
import com.example.storageservice.data.repositories.ItemStorageRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class StorageServiceApplicationTests {


    @Mock
    private CreateItemStorageService createItemStorageService;
    @Test
    void CreateItemStorageTest() {
        CreateItemStorageResponse createItemStorageRequest= createItemStorageService.createItemStorage(new CreateItemStorageRequest(UUID.randomUUID(),5,5.0f));

    }


}
