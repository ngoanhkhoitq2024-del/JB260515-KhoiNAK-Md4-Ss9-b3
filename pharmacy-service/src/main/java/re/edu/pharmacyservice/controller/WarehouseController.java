package re.edu.pharmacyservice.controller;

import re.edu.pharmacyservice.client.WarehouseClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pharmacy")
public class WarehouseController {
    private final WarehouseClient warehouseClient;

    public WarehouseController(WarehouseClient warehouseClient) {
        this.warehouseClient = warehouseClient;
    }

    @GetMapping("/stock/{medicineCode}")
    public String checkStock(@PathVariable String medicineCode) {
        return warehouseClient.checkStock(medicineCode);
    }
}