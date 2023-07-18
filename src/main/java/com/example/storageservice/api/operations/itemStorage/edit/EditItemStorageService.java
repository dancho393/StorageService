package com.example.storageservice.api.operations.itemStorage.edit;

import com.example.storageservice.api.operations.base.Operation;
import org.springframework.stereotype.Service;

@Service
public interface EditItemStorageService extends Operation<EditItemStorageResponse, EditItemStorageRequest> {
     EditItemStorageResponse operationProcess(EditItemStorageRequest itemStorage);
}
