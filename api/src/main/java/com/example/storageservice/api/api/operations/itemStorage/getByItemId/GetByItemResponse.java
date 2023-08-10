package com.example.storageservice.api.api.operations.itemStorage.getByItemId;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetByItemResponse implements OperationResponse {

   private int quantity;
   private Float price;
}
