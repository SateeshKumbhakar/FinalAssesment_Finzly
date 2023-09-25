export interface Customer {
    customerId: number;
    customerName: string;
    password: string;
    customerAadharcardno: string;
    otp: string,
    address: {
        street:string;
         city:string;
         state:string;
         postalCode:string
    },
    contactInfo: {
        email:string;
       phone:string;
    }

}
