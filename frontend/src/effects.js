import {service} from "./services";


export const getCustomersEffect = (setCustomers) => () => {
    service.getAllCustomers().then(data => setCustomers(data));
}