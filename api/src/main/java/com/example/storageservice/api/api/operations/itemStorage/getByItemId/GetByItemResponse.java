package com.example.storageservice.api.api.operations.itemStorage.getByItemId;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByItemResponse implements OperationResponse {

   private int quantity=0;
   private Float price=0.0f;
}