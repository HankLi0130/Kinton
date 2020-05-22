## Color

- kintonBlack: #231F20
- kintonYellow: #FBDA32

## JSON Format

### MenuCategory

```
{
  "id": 1,  // Int
  "pic": "pic_category_pork",   // String
  "name": "Pork",   // String
  "type": 1 // Int
}
```

- type enum

>- Pork = 1
>- Chicken = 2
>- Vegetarian = 3
>- Sides = 4
>- Dessert = 5

### MenuItem

```
{
  "id": 1,  // Int
  "type": 1,    // Int category type
  "pic": "pic_ramen_pork_original", // String
  "title": "Pork Original", // String
  "subtitle": "sea salt, pork, seasoned egg, nori, scallions",  // String
  "price": 12.95    // BigDecimal
}
```

### RewardItem

```
{
  "id": 1,  // Int
  "pic": "pic_reward_1",    // String
  "title": "10pc GYOZA + Badge",    // String
  "requested_points": 10,   // Int
}
```

### KintonCode (QR code)

```
{
  "action": 2,  // Int, 1: withdraw  2: deposit
  "points": 10, // Int
  "description": "get one point from Church branch" // String
}
```

## Entity

### PointTransaction