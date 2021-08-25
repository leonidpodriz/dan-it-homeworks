import './App.css';
import {
    Button,
    Card,
    CardContent,
    Container,
    FormControl,
    InputLabel,
    makeStyles,
    MenuItem,
    Select,
    TextField,
    Typography
} from "@material-ui/core";
import {useEffect, useState} from "react";
import {BASE_URL, CURRENCIES} from "./constants";
import {getFormData, handleFormControlChange} from "./utils";
import {getCustomersEffect} from "./effects";


const createCustomer = async (data) => {
    const response = await fetch(`${BASE_URL}`, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data) // body data type must match "Content-Type" header
    });

    return response.json();
};

const createCustomerAccount = async (customerId, data) => {
    const response = await fetch(`${BASE_URL}${customerId}/accounts/`, {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        }, body: JSON.stringify(data) // body data type must match "Content-Type" header
    });

    return response.json();
};


const useStyles = makeStyles(() => ({
    root: {
        padding: '20px 0',
    },
    title: {
        paddingBottom: '40px',
    },
    innerTitle: {
        marginBottom: '20px',
    },
    form: {
        marginBottom: '30px',
    },
    formInput: {
        marginBottom: '10px',
        width: '100%',
    },
    accountCard: {
        marginBottom: '15px',
    },
    accountId: {
        color: 'gray',
        marginRight: '10px',
    }
}));

const onPreventedFormSubmit = (func) => (event) => {
    event.preventDefault();
    func(event);
}

const onAccountSubmitFactory = (customerId, currency, allCustomers, setCustomers) => () => {
    if (!customerId || !currency) return;
    const customerToUpdate = allCustomers.find(customer => customer.id === customerId);

    createCustomerAccount(customerId, {currency}).then(
        (newAccount) => {
            customerToUpdate.accounts = [...customerToUpdate.accounts, newAccount];
            setCustomers([...allCustomers]);
        }
    )
};

const onCustomerSubmitFactory = (allCustomers, setCustomers) => (event) => {
    createCustomer(
        getFormData(event.target)
    ).then(
        newCustomer => setCustomers([...allCustomers, newCustomer])
    );
}

function App() {
    const classes = useStyles();
    const [allCustomers, setAllCustomers] = useState([]);
    const [currency, setCurrency] = useState(null);
    const [customer, setCustomer] = useState(null);

    useEffect(getCustomersEffect(setAllCustomers), []);

    const onCustomerSubmit = onPreventedFormSubmit(onCustomerSubmitFactory(allCustomers, setAllCustomers));

    const onAccountSubmit = onPreventedFormSubmit(
        onAccountSubmitFactory(customer, currency, allCustomers, setAllCustomers)
    );


    return (
        <Container maxWidth="sm" className={classes.root}>
            <Typography variant="h2" className={classes.title}>
                Bank
            </Typography>
            <form onSubmit={onCustomerSubmit} className={classes.form}>
                <Typography variant="h5" className={classes.innerTitle}>
                    Create customer
                </Typography>

                <TextField
                    id="name"
                    variant='outlined'
                    label="Full name"
                    name="name"
                    fullWidth
                    className={classes.formInput}
                    required
                />

                <TextField
                    id="age"
                    variant='outlined'
                    label="Age"
                    name="age"
                    inputMode='numeric'
                    type='number'
                    fullWidth
                    className={classes.formInput}
                    required
                />

                <TextField
                    id="email"
                    variant='outlined'
                    label="Email"
                    inputMode="email"
                    fullWidth
                    className={classes.formInput}
                    name="email"
                    required
                />

                <Button variant='contained' color='primary' type='submit'>Create</Button>
            </form>
            <form onSubmit={onAccountSubmit}>
                <Typography variant="h5" className={classes.innerTitle}>
                    Create account
                </Typography>

                <FormControl variant="outlined" className={classes.formInput} required>
                    <InputLabel id="demo-simple-select-outlined-label">Currency</InputLabel>
                    <Select
                        labelId="demo-simple-select-outlined-label"
                        id="demo-simple-select-outlined"
                        label="Currency"
                        fullWidth
                        onChange={handleFormControlChange(setCurrency)}
                        value={currency}
                    >
                        {CURRENCIES.map(currency => <MenuItem value={currency}>{currency}</MenuItem>)}
                    </Select>
                </FormControl>


                <FormControl variant="outlined" className={classes.formInput} required>
                    <InputLabel id="demo-simple-select-outlined-label">Customer</InputLabel>
                    <Select
                        labelId="demo-simple-select-outlined-label"
                        id="demo-simple-select-outlined"
                        label="Customer"
                        onChange={handleFormControlChange(setCustomer)}
                        value={customer}
                    >
                        {
                            allCustomers.map(customer => (
                                <MenuItem value={customer.id}>{customer.name}</MenuItem>
                            ))
                        }
                    </Select>
                </FormControl>

                <Button variant='contained' color='primary' type='submit'>Create</Button>

            </form>
            <div>
                <h2>Accounts</h2>
                {
                    allCustomers.map(customer => {
                        return (
                            <Card variant='outlined' className={classes.accountCard}>
                                <CardContent>
                                    <Typography color="textSecondary" gutterBottom>
                                        ID: {customer.id}
                                    </Typography>
                                    <Typography variant="h5" component="h2">
                                        {customer.name}
                                    </Typography>
                                    <Typography color="textSecondary">
                                        {customer.email}
                                    </Typography>
                                    <Typography variant="body2" component="p">
                                        Age: {customer.age}
                                    </Typography>
                                    {
                                        customer.accounts.length !== 0 ? (
                                            <>
                                                <h4>Accounts</h4>
                                                {
                                                    customer.accounts.map(account => {
                                                        return (
                                                            <div>
                                                                <pre>{account.number}</pre>
                                                                {account.balance} {account.currency}
                                                                <hr/>
                                                            </div>
                                                        )
                                                    })
                                                }
                                            </>
                                        ) : null
                                    }


                                </CardContent>

                            </Card>
                        )
                    })
                }
            </div>
        </Container>
    );
}

export default App;
