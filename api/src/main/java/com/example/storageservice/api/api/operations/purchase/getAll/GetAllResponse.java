package com.example.storageservice.api.api.operations.purchase.getAll;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.List;

;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAllResponse implements OperationResponse {
   List<GetAllPurchase> purchaseList;
}
