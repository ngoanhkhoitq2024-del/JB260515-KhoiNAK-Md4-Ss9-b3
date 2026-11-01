package re.edu.warehouseservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {
    @GetMapping("/stock/{medicineCode}")
    public String checkStock(@PathVariable String medicineCode) {
        return "Medicine " + medicineCode + " has 100 items in stock";
    }
}