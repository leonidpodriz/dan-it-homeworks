import {BASE_URL} from "./constants";

class RejectedRequest extends Error {
}

class BaseService {

    is2xxStatus = (status) => (status - 200) < 100;

    getFetchInit = (method, body) => {
        return {
            method: method,
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json'
            },
            body: body ? JSON.stringify(body) : null,
        };
    };

    request = async (url, method, body) => {
        const response = await fetch(url, this.getFetchInit('GET', body));

        if (!this.is2xxStatus(response.status)) {
            throw new RejectedRequest(`Status: ${response.status}`);
        }

        return response.json();
    }

    get = async (url, body = null) => {
        return this.request(url, 'GET', body);
    }

    post = async (url, body = null) => {
        return this.request(url, 'POST', body);
    }


}

export class BankService extends BaseService {
    BASE_URL = BASE_URL;

    getAllCustomers = () => {
        return this.get(this.BASE_URL);
    }

    createCustomer = (data) => {
        return this.post(this.BASE_URL, data);
    };

    createCustomerAccount = (customerId, data) => {
        return this.post(`${BASE_URL}${customerId}/accounts/`, data);
    };
}

export const service = new BankService();
