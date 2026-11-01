package re.edu.pharmacyservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WarehouseClient {
    private final RestTemplate restTemplate = new RestTemplate();

    @CircuitBreaker(name = "warehouseCB", fallbackMethod = "warehouseFallback")
    public String checkStock(String medicineCode) {
        String url = "http://localhost:8082/api/v1/warehouse/stock/" + medicineCode;
        return restTemplate.getForObject(url, String.class);
    }

    public String warehouseFallback(String medicineCode, Throwable exception) {
        throw new ResponseStatusException(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Warehouse service is unavailable"
        );
    }
}