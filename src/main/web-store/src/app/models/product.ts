import {ProductType} from "./product-type";
import {Country} from "./country";

export class Product{
  productId: number;
  name: string;
  count: number;
  price: number;
  productType: ProductType;
  productTypeId: number;
  country: Country;
  countryId: number;
}
