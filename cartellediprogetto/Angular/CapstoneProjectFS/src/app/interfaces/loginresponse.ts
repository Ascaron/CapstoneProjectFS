export interface Loginresponse {
  token:string,
  type:string,
  id:number,
  username:string,
  email:string,
  roles:string[],
  expirationTime:string

}
