import './App.css';
import {Container, makeStyles, Typography} from "@material-ui/core";

const useStyles = makeStyles((theme) => ({
    root: {
      padding: '20px 0',
    },
    title: {
        paddingBottom: '40px',
    },
    accountCard: {
        border: '1px solid gray',
        borderRadius: '5px',
        marginBottom: '15px',
        padding: '10px 20px',
    },
    accountId: {
        color: 'gray',
        marginRight: '10px',
    }
}));

function App() {
    const classes = useStyles();
    const customers = [
        {
            "id": 1,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 2,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": [
                {
                    "id": 1,
                    "number": "b8acb750-9709-4c53-85ea-b2544f725a5e",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 2,
                    "number": "e69b8efd-f127-4b29-94d0-3a8dbed5a19d",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 3,
                    "number": "6bb91239-f4bb-422e-9d18-d531c15a933a",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 4,
                    "number": "d4b17fa4-edc8-4720-b6ac-ec9ab075ced5",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 5,
                    "number": "f3ae33e2-56f8-465a-bcdf-0ba3c60b4723",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 6,
                    "number": "1cef7960-64dd-47e2-b1bd-819580037f29",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 7,
                    "number": "786f2177-b553-45c8-b6a3-46e0213cb267",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 8,
                    "number": "d2e165ba-0fc8-4943-817b-a944ef5fc9f5",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 9,
                    "number": "fcc07c30-2f04-46bb-acd4-9016ba14de75",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 10,
                    "number": "b8d8118c-b316-43db-9931-2a7a204b0855",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 11,
                    "number": "9eb3fd56-a1d2-4572-bed9-18ab56ae8eb7",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 12,
                    "number": "3f678882-987b-4982-8448-24799ba7b43e",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 13,
                    "number": "9ac9cb52-fd42-4d7f-9557-beece975df14",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 14,
                    "number": "93f8b9a1-c951-41fd-a9bf-6a503503e2e0",
                    "currency": "GBP",
                    "balance": 0.0
                },
                {
                    "id": 15,
                    "number": "dd41eb4e-ab25-4c37-8914-69a5af2d965d",
                    "currency": "GBP",
                    "balance": 0.0
                }
            ]
        },
        {
            "id": 3,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 4,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 5,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 6,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 7,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 8,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 9,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 10,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        },
        {
            "id": 11,
            "name": "Leonid",
            "email": "leonidpodriz@gmail.com",
            "age": 19,
            "accounts": []
        }
    ];
    return (
        <Container maxWidth="sm" className={classes.root}>
            <Typography variant="h2" className={classes.title}>
                Bank
            </Typography>
            <div>
                <h2>Accounts</h2>
                {
                    customers.map( customer => {
                        return (
                            <div className={classes.accountCard}>
                                <h3>
                                    <span className={classes.accountId}>{customer.id}</span>
                                    {customer.name}
                                </h3>
                                <ul>
                                    <li>Email: {customer.email}</li>
                                    <li>Age: {customer.age}</li>
                                </ul>

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

                            </div>
                        )
                    })
                }
            </div>
        </Container>
    );
}

export default App;
