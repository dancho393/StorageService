package com.example.storageservice.core.core.operations.purchase.create;

import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseOperation;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseRequest;
import com.example.storageservice.api.api.operations.purchase.create.CreatePurchaseResponse;
import com.example.storageservice.persistence.persistence.entities.ItemStorage;
import com.example.storageservice.persistence.persistence.entities.Purchase;
import com.example.storageservice.persistence.persistence.entities.Shipment;
import com.example.storageservice.persistence.persistence.enums.EstimatedTime;
import com.example.storageservice.persistence.persistence.enums.ShipmentStatus;
import com.example.storageservice.persistence.persistence.repositories.ItemStorageRepository;
import com.example.storageservice.persistence.persistence.repositories.PurchaseRepository;
import com.example.storageservice.persistence.persistence.repositories.ShipmentRepository;
import com.example.zoostore.api.operations.item.get.GetItemResponse;
import com.example.zoostore.restexport.ZooStoreRestClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CreatePurchaseIMPL implements CreatePurchaseOperation {
    private final PurchaseRepository purchaseRepository;
    private final ItemStorageRepository itemStorageRepository;
    private final ZooStoreRestClient zooStoreRestClient;
    private ShipmentRepository shipmentRepository;
    @Override
    public CreatePurchaseResponse operationProcess(CreatePurchaseRequest request) {

        Float discountedPrice=discount(request.getTotalPrice(), request.getDiscountPoints());
        List<ItemStorage> itemStorageList =itemStorageRepository.findAll();
        Boolean successful = checkItemsWithEnoughQuantity(request.getItems(),itemStorageList)
                &&request.getUserBalance()>=discountedPrice;
        ArrayList<ItemStorage> list=new ArrayList<>();
        List<Shipment> shipments=new ArrayList<>();

        if(successful){
           request.getItems().forEach((key, value) -> {
               ItemStorage itemStorage = itemStorageList.stream()
                       .filter(item -> item.getItemId().equals(key))
                       .findFirst()
                       .orElseThrow(() -> new RuntimeException("Not Found Storage"));
               itemStorage.setQuantity(itemStorage.getQuantity() - value);
               list.add(itemStorage);
               GetItemResponse response = zooStoreRestClient.getItemById(itemStorage.getItemId().toString());
                shipments.add(makeShipment(response.getVendorCountry(),
                        response.getVendorCity(),
                        request.getUserContinent(),
                        request.getUserCountry(),
                        request.getUserCity(),
                        request.getUserContinent(),
                        key,
                        value
                        ));

           });
           itemStorageRepository.saveAll(list);
        }


        Purchase purchase= Purchase.builder()
                .userId(request.getUserId())
                .purchaseDate(new Timestamp(System.currentTimeMillis()))
                .shipments(shipments)
                .totalPrice(discountedPrice)
                .items(request.getItems())
                .successful(successful)
                .build();

        purchaseRepository.save(purchase);
        shipments.forEach(shipment -> shipment.setPurchase(purchase));
        shipmentRepository.saveAll(shipments);

        return CreatePurchaseResponse
                .builder()
                .discountedPrice(discountedPrice)
                .successful(successful)
                .totalPrice(request.getTotalPrice())
                .purchaseDate(new Timestamp(System.currentTimeMillis()))
                .build();
    }
    public  boolean checkItemsWithEnoughQuantity(Map<UUID, Integer> items,List<ItemStorage> itemStorageList) {
       return items.entrySet().stream()
                .allMatch(entry -> itemStorageList.stream()
                        .anyMatch(item -> item.getItemId().equals(entry.getKey()) && item.getQuantity() >= entry.getValue()));
    }
    public Float discount(Float totalPrice,int discountPoints){
        if(discountPoints==0)
            return totalPrice;
        if (discountPoints>0&&discountPoints<2000)
            return (totalPrice/100)*95;//5% discount
        if(discountPoints>=2000&&discountPoints<4000)
            return (totalPrice/100)*90;//10% discount
        if(discountPoints>=4000&&discountPoints<6000)
            return (totalPrice/100)*85;//15% discount
        if(discountPoints>=6000&&discountPoints<8000)
            return (totalPrice/100)*80;//20% discount
        if(discountPoints>=8000)
            return (totalPrice/100)*75;//25% discount


        return totalPrice;

    }

    private Shipment makeShipment(String fromCountry,
                                 String fromCity,
                                 String fromContinent,
                                 String toCountry,
                                 String toCity,
                                 String toContinent,
                                 UUID itemId,
                                 int itemQuantity){
        EstimatedTime estimatedTime= calculateEstimatedTime(fromCity,
                fromCountry,
                fromContinent,
                toCity,
                toCountry,
                toContinent);

        return Shipment.builder()
                .fromCity(fromCity)
                .fromCountry(fromCountry)
                .fromContinent(fromContinent)
                .toCity(toCity)
                .toCountry(toCountry)
                .toContinent(toContinent)
                .shipmentStatus(ShipmentStatus.WAITING)
                .itemId(itemId)
                .itemQuantity(itemQuantity)
                .estimatedTime(estimatedTime.toString())
                .estimatedArrival(calculateArrivalTime(estimatedTime))
                .build();
    }
    private EstimatedTime calculateEstimatedTime(String vendorCity,
                                                String vendorCountry,
                                                String vendorContinent,
                                                String userCity,
                                                String userCountry,
                                                String userContinent){
        if(vendorCity.equals(userCity))
            return EstimatedTime.TWODAYS;
        if(vendorCountry.equals(userCountry))
            return EstimatedTime.FOURDAYS;
        if(userContinent.equals(vendorContinent))
            return EstimatedTime.SEVENDAYS;
        return EstimatedTime.TENDAYS;
    }
    private String calculateArrivalTime(EstimatedTime estimatedTime){
        int days=0;
        switch (estimatedTime){
            case TWODAYS -> days=2;
            case FOURDAYS -> days=4;
            case SEVENDAYS -> days=7;
            case TENDAYS -> days=10;
        }
        return LocalDate.now().plusDays(days).toString();
    }
}

