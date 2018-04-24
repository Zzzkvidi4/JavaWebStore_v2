export class JsonHttpResponse<T>{
  errors: string[];
  isSuccessful: boolean;
  data: T;
}
