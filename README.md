# FarmCollector Spring Boot Application

## Introduction
Organization “FarmCollector”  wants to collect information from Farmers for every field for every season, per farm (2 API):
1. Planted:   	
   a. Planting Area (in acres).
   b. Type of crops planted.
   c. Amount of Expected product (in tons)
2. Harvested:
   a. Actual amount of harvested product.
   Organization “FarmCollector”  want to see reports for every season shows expected vs actual amount of product:
    1. For each farm
    2. For each Type of crops


## API Endpoints
By default, the application runs on `http://localhost:8080`.

### Submit Harvest Data

```http
POST /api/farm-controller/harvest
```
#### Request Body

```json
{
  "cropTypeId": 1,
  "actualProduct": 100.5,  
  "fieldId": 1,
  "season": "SPRING"
}
```

### Submit Plant Data

```http
POST /api/farm-controller/plant
```

#### Request Body

```json
{
    "cropTypeId": 2,
    "expectedProduct": 200.5,
    "fieldId": 2,
    "season": "SUMMER"
}
```

### Generate Farm Report
```http
GET /api/farm-controller/reports/harvest/farmer/{farmerId}
```

### Generate Crop Report
```http
GET /api/farm-controller/reports/plant/crop/{cropTypeId}
```
