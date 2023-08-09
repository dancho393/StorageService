package com.example.storageservice.api.api.operations.purchase.getforuser;

import com.example.storageservice.api.api.operations.base.OperationResponse;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@Setter
@Builder
@NoArgsConstructor
public class GetPurchaseForUserResponse implements OperationResponse {
    List purchases;

}
